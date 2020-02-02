package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class NodeND implements Node {

	private ArrayList<Integer> nodeID = new ArrayList<Integer>();
	private int layerID = 0;
	private double nodeValue = 0.0;
	private ArrayList<WeightND> weights = new ArrayList<WeightND>();
	private int dimensions = 0;
	
	public NodeND(int dimensions) {
		this.dimensions = dimensions;
		for (int i = 0; i < dimensions; i++) {
		  nodeID.add(0);
		}
		nodeID.trimToSize();
	}
	
	public void setLayer(int layerID) {
		this.layerID = layerID;
	}
	
	public int getLayerID() {
		return this.layerID;
	}
	
	public void setNodeID(ArrayList<Integer> nodeID) {
		this.nodeID = nodeID;
	}
	
	public ArrayList<Integer> getNodeID() {
		return this.nodeID;
	}
	
	public void setNodeValue(double nodeValue) {
		this.nodeValue = nodeValue;
	}
	
	public double getNodeValue() {
		return this.nodeValue;
	}
	
	public void addWeight(WeightND weight) {
		this.weights.add(weight);
	}
	
	public void setWeights(ArrayList<WeightND> weights) {
	  this.weights = weights;
	}
	
	public WeightND getWeight(int weightID) {
		return this.weights.get(weightID);
	}
	
	public ArrayList<WeightND> getWeights(){
		return this.weights;
	}
	
}
