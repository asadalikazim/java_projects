package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class LayerND implements Layer{

	/**
	 * 
	 */
	private ArrayList<Object> nodesInLayer;
	/**
	 * 
	 */
	private ArrayList<Integer> dimensions = new ArrayList<Integer>();
	
	/**
	 * @param dimensionN
	 */
	public LayerND(ArrayList<Integer> dimensions) {
		this.dimensions = dimensions;
		this.nodesInLayer = createNodesInLayerHelper(dimensions, 0);
	}
	
	/**
	 * @param node
	 */
	public void addNode(NodeND node) {
		addNodeHelper(node, this.nodesInLayer, 0);
	}
	
	/**
	 * @return
	 */
	public ArrayList<Object> getNodes() {
		return this.nodesInLayer;
	}
	
	/**
	 * @param nodeID
	 * @return
	 */
	public NodeND getNode(ArrayList<Integer> nodeID) {
		return getNodeHelper(nodeID, this.nodesInLayer, 0);
	}
	
	/**
	 * @param node 
	 * @param nodeID
	 * @param nodeArrayObject
	 */
	@SuppressWarnings("unchecked")
	private void addNodeHelper(NodeND node, ArrayList<Object> nodeArrayObject, int level) {
		if (level + 1 == this.dimensions.size()) {
			
		  NodeND nodeInLayer = (NodeND) nodeArrayObject.get(node.getNodeID().get(level));			
		  nodeInLayer.setLayer(node.getLayerID());			
		  nodeInLayer.setNodeID(node.getNodeID());			
		  nodeInLayer.setNodeValue(node.getNodeValue());
		  nodeInLayer.setWeights(node.getWeights());
		  
		} else {
		  
		  addNodeHelper(node, (ArrayList<Object>) nodeArrayObject.get(node.getNodeID().get(level)), level + 1);
		  
		}
	}
	
	/**
	 * @param nodeID
	 * @param nodeArrayObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private NodeND getNodeHelper(ArrayList<Integer> nodeID, ArrayList<Object> nodeArrayObject, int level) {
		if (nodeID.size() == level + 1) {
			return (NodeND) nodeArrayObject.get(nodeID.get(level));
		} else {
			return getNodeHelper(nodeID, (ArrayList<Object>) nodeArrayObject.get(nodeID.get(level)), level + 1);
		}
	}
	
	
	/**
	 * @param dimensions
	 * @return
	 */
	private ArrayList<Object> createNodesInLayerHelper(ArrayList<Integer> dimensions, int level) {
		ArrayList<Object> nthD = new ArrayList<Object>();
		
		if (level + 1 == dimensions.size()) {
		  for (int i = 0; i < dimensions.get(level); i++) {
		    nthD.add((Object) new NodeND(dimensions.size()));
		  }
		  return nthD;
		} else {
		  for (int i = 0; i < dimensions.get(level); i++) {
            nthD.add((Object) createNodesInLayerHelper(dimensions, level + 1));
          }
          return nthD;		  
		}		
	}
	
	public ArrayList<Integer> getDimensions(){
      return this.dimensions;
    }
	
}
