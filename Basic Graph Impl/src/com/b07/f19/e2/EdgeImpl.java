package com.b07.f19.e2;

public class EdgeImpl implements Edge {

  Node first;
  Node second;

  /**
   * constructor method for EdgeImpl
   * 
   * @param first: the first node in the edge
   * @param second: the second node in the edge
   */
  public EdgeImpl(Node first, Node second) {
    this.first = first;
    this.second = second;
  }

  /**
   * get the first node of the Edge.
   * 
   * @return the first Node.
   */
  @Override
  public Node getFirstNode() {
    return this.first;
  }

  /**
   * get the second node of the Edge.
   * 
   * @return the second Node.
   */
  @Override
  public Node getSecondNode() {
    return this.second;
  }

  /**
   * returns the position of Node a in the Edge.
   * 
   * @param a the Node to find
   * @return 1 if first Node, 2 if second Node, 0 if not included.
   */
  @Override
  public int nodePosition(Node a) {
    if (a.getId() == this.first.getId()) {
      return 1;
    } else if (a.getId() == this.second.getId()) {
      return 2;
    } else {
      return 0;
    }

  }

  /**
   * compares two Edges and says if their elements are the same (order agnostic).
   * 
   * @param edge the Edge to be compared
   * @return true if the two id's are same as this Edge's two id's.
   */
  @Override
  public boolean compareOrderAgnostic(Edge edge) {
    return ((edge.getFirstNode().getId() == this.first.getId())
        && (edge.SecondNode().getId() == this.second.getId()))
        || ((edge.getSecondNode().getId() == this.first.getId())
            && (edge.getFirstNode().getId() == this.second.getId()));

  }

  /**
   * see if two edges are the same.
   * 
   * @param edge to be compared to.
   * @return true if firstNode of edge and secondNode of edge are equal to this edge's.
   */
  @Override
  public boolean compare(Edge edge) {
    return (edge.getFirstNode().getId() == this.first.getId())
        && (edge.getSecondNode().getId() == this.second.getId());
  }

}
