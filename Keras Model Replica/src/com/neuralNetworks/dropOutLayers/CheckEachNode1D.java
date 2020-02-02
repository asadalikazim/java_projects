package com.neuralNetworks.dropOutLayers;

import com.neuralNetworks.basicDataTypes.Layer1D;

public class CheckEachNode1D implements DropOutLayer {
	
	public Layer1D smallerLayer(Layer1D originalLayer, double probability) {		
		
		int dimensions = originalLayer.getDimensions();
		Layer1D smallerLayer = new Layer1D(dimensions);
		
		for (int i = 0; i < dimensions; i++) {
			double check = Math.random();
			if (check >= probability) {
				smallerLayer.addNode(originalLayer.getNode(i));
			} 
		}
		
		return smallerLayer;
	}
}
