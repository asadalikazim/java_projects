
package com.b07.serialization;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.b07.accounts.CustomerAccountImpl;
import com.b07.database.DatabaseDriver;
import com.b07.database.helper.DatabaseInsertHelper;
import com.b07.exceptions.DatabaseInsertException;
import com.b07.exceptions.InvalidAddressException;
import com.b07.exceptions.InvalidAgeException;
import com.b07.exceptions.InvalidItemException;
import com.b07.exceptions.InvalidPriceException;
import com.b07.exceptions.InvalidQuantityException;
import com.b07.exceptions.InvalidRoleException;
import com.b07.exceptions.ItemIdNotFoundException;
import com.b07.exceptions.RoleIdNotFoundException;
import com.b07.exceptions.SaleIdNotFoundException;
import com.b07.exceptions.UserIdNotFoundException;
import com.b07.inventory.InventoryImpl;
import com.b07.inventory.ItemImpl;
import com.b07.store.SaleImpl;
import com.b07.store.SalesLogImpl;

public class Deserialization {


  /**
   * Return the deserialized object based on input file location and name
   * 
   * @param file location and name
   * @return deserialized object
   */
  public static Object deserialize(String fileLocationAndName)
      throws SQLException, FileNotFoundException, IOException {
    try {
      FileInputStream fileInput = new FileInputStream(fileLocationAndName);
      ObjectInputStream in = new ObjectInputStream(fileInput);
      Object theEntireDatabase = in.readObject();
      in.close();
      fileInput.close();
      return theEntireDatabase;
    } catch (IOException i) {
      System.out.println("Deserialization failed");
      return null;
    } catch (ClassNotFoundException c) {
      System.out.println("Cat class not found");
      System.out.println("Deserialization failed");
      return null;
    }
  }

  /**
   * Insert the database object into database
   * 
   * @param the database object
   * 
   */
  public static void insertTheNewDatabase(DatabaseInOneObject theEntireDatabase)
      throws InvalidAddressException, InvalidAgeException, DatabaseInsertException, SQLException,
      UserIdNotFoundException, RoleIdNotFoundException, InvalidRoleException, InvalidItemException,
      InvalidPriceException, ItemIdNotFoundException, InvalidQuantityException,
      SaleIdNotFoundException, ClassNotFoundException {


    if (theEntireDatabase == null) {
      System.out.println("the file that you want to deserialize is empty");
    }
    HashMap<Integer, ArrayList<Object>> allusers = theEntireDatabase.getAllusers();
    for (Integer key : allusers.keySet()) {
      ArrayList<Object> singleUser = allusers.get(key);
      DatabaseInsertHelper.insertNewUser((String) singleUser.get(0), (int) singleUser.get(1),
          (String) singleUser.get(2), (String) singleUser.get(5));
      DatabaseInsertHelper.insertUserRole(key, (int) singleUser.get(3));
      DatabaseInsertHelper.insertRole((String) singleUser.get(4));
    }

    List<ItemImpl> allitems = theEntireDatabase.getAllitems();
    for (int i = 0; i < allitems.size(); i++) {
      DatabaseInsertHelper.insertItem(allitems.get(i).getName(), allitems.get(i).getPrice());
    }

    InventoryImpl inventory = theEntireDatabase.getInventory();
    HashMap<ItemImpl, Integer> itemMap = inventory.getItemMap();
    for (ItemImpl key : itemMap.keySet()) {
      DatabaseInsertHelper.insertInventory(key.getId(), itemMap.get(key));
    }

    SalesLogImpl allSales = theEntireDatabase.getAllSales();
    List<SaleImpl> allsales = allSales.getSales();
    for (int i = 0; i < allsales.size(); i++) {
      DatabaseInsertHelper.insertSale(allsales.get(i).getUser().getId(),
          allsales.get(i).getTotalPrice());
      HashMap<ItemImpl, Integer> singleitemMap = allsales.get(i).getItemMap();
      for (ItemImpl key : singleitemMap.keySet()) {
        DatabaseInsertHelper.insertItemizedSale(allsales.get(i).getId(), key.getId(),
            singleitemMap.get(key));
      }


    }
    List<List<CustomerAccountImpl>> allAccounts = theEntireDatabase.getAllCustomerAccount();
    for (int i = 0; i < allAccounts.size(); i++) {
      for (int j = 0; j < allAccounts.get(i).size(); j++) {
        DatabaseInsertHelper.insertCustomerAccount(allAccounts.get(i).get(j).getUser().getId());

      }

    }



  }



}

