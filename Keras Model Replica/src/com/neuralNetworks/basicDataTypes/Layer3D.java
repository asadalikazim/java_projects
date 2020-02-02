package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class Layer3D implements Layer{

    private ArrayList<ArrayList<ArrayList<Node3D>>> nodesInLayer = new ArrayList<ArrayList<ArrayList<Node3D>>>();
    private ArrayList<Integer> dimensions = new ArrayList<Integer>();
    
    public Layer3D(ArrayList<Integer> dimensions) {
    	
    	this.dimensions = dimensions;
    	this.nodesInLayer = createNodesInLayerHelper(dimensions);
    }
    
    private ArrayList<ArrayList<ArrayList<Node3D>>> createNodesInLayerHelper(ArrayList<Integer> dimensions){
    	
    	ArrayList<ArrayList<ArrayList<Node3D>>>  thirdD = new ArrayList<ArrayList<ArrayList<Node3D>>>();    	
    	for (int i = 0; i < dimensions.get(0); i++) {
    		
    		ArrayList<ArrayList<Node3D>> secondD = new ArrayList<ArrayList<Node3D>>();			
    		for (int j = 0; j < dimensions.get(1); j++) {    
    			
    			ArrayList<Node3D> firstD = new ArrayList<Node3D>();    			
    			for (int k = 0; k < dimensions.get(2); k++) {
    				firstD.add(new Node3D());    				   				
    			}    			
    			firstD.trimToSize();
    			secondD.add(firstD);
    		}
    		secondD.trimToSize();
    		thirdD.add(secondD);
    	}
    	thirdD.trimToSize();
    	return thirdD;
    }
	
	public void addNode(Node3D node) {
		Node3D nodeInLayer = nodesInLayer.get(node.getNodeRowID()).get(node.getNodeColID()).get(node.getNodeHgtID());
		nodeInLayer.setLayerID(node.getLayerID());
		nodeInLayer.setNodeColID(node.getNodeColID());
		nodeInLayer.setNodeRowID(node.getNodeRowID());
		nodeInLayer.setNodeHgtID(node.getNodeHgtID());
		nodeInLayer.setNodeValue(node.getNodeValue());
		nodeInLayer.setWeights(node.getWeights());
		
	}
	
	public ArrayList<ArrayList<ArrayList<Node3D>>> getNodes(){
		return nodesInLayer;
	}
	
	public Node3D getNode(int nodeRowID, int nodeColID, int nodeHgtID) {
		return nodesInLayer.get(nodeRowID).get(nodeColID).get(nodeHgtID);
	}
	
	public ArrayList<Integer> getDimensions(){
      return this.dimensions;
    }
}
