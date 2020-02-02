package com.neuralNetworks.basicDataTypes;

import java.util.ArrayList;

public class WeightND implements Weight {

	private int weightID = 0;
	private ArrayList<Integer> nodeID = new ArrayList<Integer>();
	private int layerID = 0;
	private double value = 0.0;
	private int dimension = 0;
	
	public WeightND(int dimensionN) {
		this.dimension = dimensionN;
	}
	
	public void setWeightID(int weightID) {
		this.weightID = weightID;
	}
	
	public int getWeightID() {
		return this.weightID;
	}
	
	public void setNodeID(ArrayList<Integer> nodeID) {
		this.nodeID = nodeID;
	}
	
	public ArrayList<Integer> getNodeID() {
		return this.nodeID;
	}
	
	public void setlayerID(int layerID) {
		this.layerID = layerID;
	}
	
	public int getLayerID() {
		return this.layerID;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
	
}
