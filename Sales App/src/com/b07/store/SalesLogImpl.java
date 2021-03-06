package com.b07.store;

import java.util.ArrayList;
import java.util.List;

public class SalesLogImpl implements SalesLog {

  /**
   * 
   */
  private static final long serialVersionUID = -7157788859294998552L;
  private List<SaleImpl> salesLog = new ArrayList<SaleImpl>();

  /**
   * Adds sale to the saleslog
   * 
   * @param sale the sale to be added
   */
  @Override
  public void addSale(SaleImpl sale) {
    this.salesLog.add(sale);
  }

  /**
   * return a list of sales.
   * 
   * @return list containing the sales.
   */
  @Override
  public List<SaleImpl> getSales() {
    List<SaleImpl> sales = new ArrayList<SaleImpl>();
    for (int i = 0; i < this.salesLog.size(); i++)
      sales.add(this.salesLog.get(i));
    return sales;
  }


}
