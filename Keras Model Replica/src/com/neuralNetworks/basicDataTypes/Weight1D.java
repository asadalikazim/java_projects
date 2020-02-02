package com.neuralNetworks.basicDataTypes;

public class Weight1D  implements Weight{
	
	private int weightID = 0;
	private int nodeID = 0;
	private int layerID = 0;
	private double value = 0.0;
	
	public void setWeightID(int weightID) {
		this.weightID = weightID;
	}
	
	public int getWeightID() {
		return this.weightID;
	}
	
	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}
	
	public int getNodeID() {
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
