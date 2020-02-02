package com.b07.f19.e2;

public interface Node { 
  
  /**
   * get the nodes id.
   * @return the id of the node.
   */
  public int getId();
	  
  /**
   * Checks if nodes have same id.
   * @param n the node to be compared to.
   * @return true if nodes have same id, false otherwise.
   */
  public boolean equals(Node n);

}
