package com.neuralNetworks.probabilityDistributions;

import java.util.ArrayList;
import java.util.Collections;

public class SimpleRatio implements ProbabilityDistribution {

  @Override
  public ArrayList<Double> sumToOne(ArrayList<Double> inputVector) {
    
    double min = Collections.min(inputVector);
    double sum = 0.00;
    
    for (int i = 0; i < inputVector.size(); i++) {
      inputVector.set(i, inputVector.get(i) + min);
      sum += inputVector.get(i);
    }
    
    for (int i = 0; i < inputVector.size(); i++) {
      inputVector.set(i, inputVector.get(i)/sum);
    }
    
    return inputVector;
  }

}
