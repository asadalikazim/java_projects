package com.neuralNetworks.lossFunctions;

import java.util.ArrayList;

public interface LossFunction {

	public ArrayList<Double> cost(ArrayList<Double> resultVector, ArrayList<Double> actualVector);
}
