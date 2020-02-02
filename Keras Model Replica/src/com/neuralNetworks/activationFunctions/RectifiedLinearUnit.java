package com.neuralNetworks.activationFunctions;

public class RectifiedLinearUnit implements ActivationFunction {

	@Override
	public double nodeValue(double weightedSum) {
		
		return Math.max(0.00, weightedSum);
	}

}
