package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class Node1D implements Node{
	
	private int nodeID = 0;
	private int layerID = 0;
	private double nodeValue = 0.0;
	private ArrayList<Weight1D> weights = new ArrayList<Weight1D>();
	
	public void setLayerID(int layerID) {
		this.layerID = layerID;
	}
	
	public int getLayerID() {
		return this.layerID;
	}
	
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	
	public int getNodeID() {
		return this.nodeID;
	}
	
	public void setNodeValue(double nodeValue) {
		this.nodeValue = nodeValue;
	}
	
	public double getNodeValue() {
		return this.nodeValue;
	}
	
	public void addWeight(Weight1D weight) {
		this.weights.add(weight);
	}
	
	public void setWeights(ArrayList<Weight1D> weights) {
	  this.weights = weights;
	}
	
	public Weight1D getWeight(int weightID) {
		return this.weights.get(weightID);
	}
	
	public ArrayList<Weight1D> getWeights(){
		return this.weights;
	}
}
