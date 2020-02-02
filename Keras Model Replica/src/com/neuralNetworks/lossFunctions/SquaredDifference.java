package com.neuralNetworks.lossFunctions;

import java.util.ArrayList;

public class SquaredDifference implements LossFunction {

	@Override
	public ArrayList<Double> cost(ArrayList<Double> resultVector, ArrayList<Double> actualVector) {
		ArrayList<Double> costVector = new ArrayList<Double>();
		
		for (int i = 0; i < resultVector.size(); i++) {
			costVector.add(Math.pow(resultVector.get(i)-actualVector.get(i), 2));
		}
		
		return costVector;
	}

}
