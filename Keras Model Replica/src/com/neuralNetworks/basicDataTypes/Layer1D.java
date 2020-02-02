package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class Layer1D implements Layer{

	private ArrayList<Node1D> nodesInLayer = new ArrayList<Node1D>();
	private Integer dimensions = 0;
	
	public Layer1D(Integer dimensions) {
	  
	  this.dimensions = dimensions;
	  this.nodesInLayer = createNodesInLayerHelper(dimensions);
	  
	}
	
	private ArrayList<Node1D> createNodesInLayerHelper(Integer dimensions){
	  ArrayList<Node1D> firstD = new ArrayList<Node1D>();
	  for (int i = 0; i < dimensions; i++) {
	    firstD.add(new Node1D());
	  }
	  firstD.trimToSize();
	  return firstD;
	}
	
	public void addNode(Node1D node) {
		Node1D nodeInLayer = nodesInLayer.get(node.getNodeID());
		nodeInLayer.setLayerID(node.getLayerID());
        nodeInLayer.setNodeID(node.getNodeID());
        nodeInLayer.setNodeValue(node.getNodeValue());
        nodeInLayer.setWeights(node.getWeights());
	}
	
	public ArrayList<Node1D> getNodes(){
		return this.nodesInLayer;
	}
	
	public Node1D getNode(int nodeID) {
		return this.nodesInLayer.get(nodeID);
	}
	
	public Integer getDimensions() {
	  return this.dimensions;
	}
	
}
