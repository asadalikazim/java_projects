package com.neuralNetworks.probabilityDistributions;

import java.util.ArrayList;

public class SoftMax implements ProbabilityDistribution {

	@Override
	public ArrayList<Double> sumToOne(ArrayList<Double> inputVector) {
		
		ArrayList<Double> returnVector = new ArrayList<Double>();
		double sum = 0.0;
		
		for (int i = 0; i < inputVector.size(); i++) {
			sum += Math.pow(Math.E, inputVector.get(i));
		}
		
		for (int i = 0; i < inputVector.size(); i++) {
			returnVector.add(Math.pow(Math.E, inputVector.get(i))/sum);
		}
		
		return returnVector;
	}

}
