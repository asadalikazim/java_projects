package com.neuralNetworks.activationFunctions;

public class Sigmoid implements ActivationFunction {

	@Override
	public double nodeValue(double weightedSum) {
		
		return 1 / (1 + Math.exp(-weightedSum));
	}

}
