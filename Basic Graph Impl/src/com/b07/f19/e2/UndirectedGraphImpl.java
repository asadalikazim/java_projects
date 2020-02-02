package com.b07.f19.e2;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphImpl implements Graph {

  List<Node> nodes_in_graph;
  List<Edge> edges_in_graph;

  /**
   * constructor for UndirectedGraphImpl
   */
  public UndirectedGraphImpl() {
    this.nodes_in_graph = new ArrayList<Node>();
    this.edges_in_graph = new ArrayList<Edge>();
  }

  /**
   * Adds an edge between node a and node b.
   * 
   * @param a the first node.
   * @param b the second node.
   * @return true if edge was added, and false if the edge already existed.
   * @throws NodeNotFoundException if either a or b are not part of the graph, throw this exception.
   */
  @Override
  public boolean addEdge(Node a, Node b) throws NodeNotFoundException {
    if (nodes_in_graph.contains(a) && nodes_in_graph.contains(b)) {
      List<Node> connected_to_a = getConnectedNodes(a);
      if (connected_to_a.contains(b)) {
        return false;
      } else {
        Edge alpha = new EdgeImpl(a, b);
        edges_in_graph.add(alpha);
        return true;
      }

    } else {
      throw new NodeNotFoundException();
    }

  }

  /**
   * add a node to graph.
   * 
   * @param a the node to be added.
   * @return true if node was added, false o/w.
   */
  @Override
  public boolean addNode(Node a) {
    if (nodes_in_graph.contains(a)) {
      return false;
    } else {
      nodes_in_graph.add(a);
      return true;
    }

  }

  /**
   * removes Edge between Node a and Node b.
   * 
   * @param a the first Node.
   * @param b the second Node.
   * @return true if edge was found and removed, false if edge was not in graph.
   * @throws NodeNotFoundException if either a or b are not part of the graph, throw this exception.
   */
  @Override
  public boolean removeEdge(Node a, Node b) throws NodeNotFoundException {
    if (nodes_in_graph.contains(a) && nodes_in_graph.contains(b)) {
      List<Node> connected_to_a = getConnectedNodes(a);
      if (!connected_to_a.contains(b)) {
        return false;
      } else {
        for (int i = 0; i < edges_in_graph.size(); i++) {
          if ((edges_in_graph.get(i).getFirstNode().getId() == a.getId()
              && edges_in_graph.get(i).getSecondNode().getId() == b.getId())
              || (edges_in_graph.get(i).getFirstNode().getId() == b.getId()
                  && edges_in_graph.get(i).getSecondNode().getId() == a.getId())) {
            edges_in_graph.remove(i);
            return true;
          }
        }
        return false;
      }
    } else {
      throw new NodeNotFoundException();
    }
  }

  /**
   * Checks if Node a is contained in the graph.
   * 
   * @param a Node to be checked.
   * @return true if Node a is in the graph, false otherwise.
   */
  @Override
  public boolean contains(Node a) {
    return nodes_in_graph.contains(a);
  }

  /**
   * Gives the number of nodes contained in the graph.
   * 
   * @return an int representing the number of nodes in the graph.
   */
  @Override
  public int size() {
    return nodes_in_graph.size();
  }

  /**
   * Returns a list of the nodes connected to Node a.
   * 
   * @param a the Node of interest.
   * @return A list of Nodes connected to a.
   * @throws NodeNotFoundException if a is not in the Graph.
   */
  @Override
  public List<Node> getConnectedNodes(Node a) throws NodeNotFoundException {
    if (nodes_in_graph.contains(a)) {
      List<Node> connected_nodes = new ArrayList<Node>();
      for (int i = 0; i < edges_in_graph.size(); i++) {
        if (edges_in_graph.get(i).getFirstNode().getId() == a.getId()) {
          connected_nodes.add(edges_in_graph.get(i).getSecondNode());
        } else if (edges_in_graph.get(i).getSecondNode().getId() == a.getId()) {
          connected_nodes.add(edges_in_graph.get(i).getFirstNode());
        }
      }

      return connected_nodes;
    } else {
      throw new NodeNotFoundException();
    }
  }


  /**
   * get a list containing all the edges.
   * 
   * @return a list of Edges contained in the Graph.
   */
  @Override
  public List<Edge> getEdges() {
    return edges_in_graph;
  }

  /**
   * A string representation of the graph.
   * 
   * @return String representation of graph in format a<->b;b<->c;d;e->f;
   */
  @Override
  public String toString() {
    List<String> working_list = new ArrayList<String>();
    String working_string = "";

    for (int i = 0; i < nodes_in_graph.size(); i++) {

      Node working_node = nodes_in_graph.get(i);
      List<Node> connected_nodes = new ArrayList<Node>();

      for (int j = 0; j < edges_in_graph.size(); j++) {
        if (edges_in_graph.get(j).getFirstNode().getId() == working_node.getId()) {
          connected_nodes.add(edges_in_graph.get(j).getSecondNode());
        } else if (edges_in_graph.get(j).getSecondNode().getId() == working_node.getId()) {
          connected_nodes.add(edges_in_graph.get(j).getFirstNode());
        }
      }

      for (int k = 0; k < connected_nodes.size(); k++) {
        String current_string = String.valueOf(working_node.getId()) + "<->"
            + String.valueOf(connected_nodes.get(k).getId()) + ";";
        String other_pversion = String.valueOf(connected_nodes.get(k).getId()) + "<->"
            + String.valueOf(working_node.getId()) + ";";

        if (!working_list.contains(other_pversion)) {
          working_list.add(current_string);
        }

      }

      if (connected_nodes.size() == 0
          && !working_list.contains(String.valueOf(working_node.getId()) + ";")) {
        working_list.add(String.valueOf(working_node.getId()) + ";");
      }

    }

    for (int l = 0; l < working_list.size(); l++) {
      working_string += working_list.get(l);
    }
    
    System.out.println(working_string);

    return working_string;

  }


}
