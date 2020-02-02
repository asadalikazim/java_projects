package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class Layer2D implements Layer{
	
    private ArrayList<ArrayList<Node2D>> nodesInLayer = new ArrayList<ArrayList<Node2D>>();
    private ArrayList<Integer> dimensions = new ArrayList<Integer>();
    
    public Layer2D(ArrayList<Integer> dimensions) {
    	
    	this.dimensions = dimensions;
    	this.nodesInLayer = createNodesInLayerHelper(dimensions);
    }
    
    private ArrayList<ArrayList<Node2D>> createNodesInLayerHelper(ArrayList<Integer> dimensions){
    	    	
    	ArrayList<ArrayList<Node2D>> secondD = new ArrayList<ArrayList<Node2D>>();			
    	for (int i = 0; i < dimensions.get(0); i++) {    
    			
    		ArrayList<Node2D> firstD = new ArrayList<Node2D>();    			
    		for (int j = 0; j < dimensions.get(1); j++) {
    			firstD.add(new Node2D());    				   				
    		}    			
    		firstD.trimToSize();
    		secondD.add(firstD);
    	}
    	secondD.trimToSize();    		
    	return secondD;
    }
	
	public void addNode(Node2D node) {
		Node2D nodeInLayer = nodesInLayer.get(node.getNodeRowID()).get(node.getNodeColID());
		nodeInLayer.setLayerID(node.getLayerID());
        nodeInLayer.setNodeColID(node.getNodeColID());
        nodeInLayer.setNodeRowID(node.getNodeRowID());
        nodeInLayer.setNodeValue(node.getNodeValue());
        nodeInLayer.setWeights(node.getWeights());
	}
	
	public ArrayList<ArrayList<Node2D>> getNodes(){
		return nodesInLayer;
	}
	
	public Node2D getNode(int nodeRowID, int nodeColID) {
		return nodesInLayer.get(nodeRowID).get(nodeColID);
	}
	
	public ArrayList<Integer> getDimensions(){
	  return this.dimensions;
	}
}
