package com.neuralNetworks.basicDataTypes;

public class Weight2D implements Weight{

	private int weightID = 0;
	private int nodeRowID = 0;
	private int nodeColID = 0;
	private int layerID = 0;
	private double value = 0.0;
	
	public void setWeightID(int weightID) {
		this.weightID = weightID;
	}
	
	public int getWeightID() {
		return this.weightID;
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
