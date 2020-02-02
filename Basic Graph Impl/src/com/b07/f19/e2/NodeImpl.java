package com.b07.f19.e2;

public class NodeImpl implements Node {

  int id;

  /**
   * constructor for NodeImpl
   */
  public NodeImpl() {
    this.id = (int) (Math.random() * 10000000);
  }
  
  /**
   * constructor overload for NodeImpl
   */
  public NodeImpl(int id) {
    this.id = id;
  }

  /**
   * get the nodes id.
   * 
   * @return the id of the node.
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   * Checks if nodes have same id.
   * 
   * @param n the node to be compared to.
   * @return true if nodes have same id, false otherwise.
   */
  @Override
  public boolean equals(Node n) {
    return (this.id == n.getId());
  }
}
