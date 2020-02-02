package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class Node2D implements Node {

	private int nodeRowID = 0;
	private int nodeColID = 0;
	private int layerID = 0;
	private double nodeValue = 0.0;
	private ArrayList<Weight2D> weights = new ArrayList<Weight2D>();
	
	public void setLayerID(int layerID) {
		this.layerID = layerID;
	}
	
	public int getLayerID() {
		return this.layerID;
	}
	
	public void setNodeRowID(int nodeRowID) {
		this.nodeRowID = nodeRowID;
	}
	
	public int getNodeRowID() {
		return this.nodeRowID;
	}
	
	public void setNodeColID(int nodeColID) {
		this.nodeColID = nodeColID;
	}
	
	public int getNodeColID() {
		return this.nodeColID;
	}
	
	public void setNodeValue(double nodeValue) {
		this.nodeValue = nodeValue;
	}
	
	public double getNodeValue() {
		return this.nodeValue;
	}
	
	public void addWeight(Weight2D weight) {
		this.weights.add(weight);
	}
	
	public void setWeights(ArrayList<Weight2D> weights) {
	  this.weights = weights;
	}
	
	public Weight2D getWeight(int weightID) {
		return this.weights.get(weightID);
	}
	
	public ArrayList<Weight2D> getWeights(){
		return this.weights;
	}
}
