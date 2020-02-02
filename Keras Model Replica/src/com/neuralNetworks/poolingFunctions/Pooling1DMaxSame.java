package com.neuralNetworks.poolingFunctions;

import java.util.ArrayList;
import com.neuralNetworks.basicDataTypes.Layer1D;
import com.neuralNetworks.basicDataTypes.Node1D;

public class Pooling1DMaxSame implements PoolingLayer, TypeMax, PaddingSame{
  
  public Layer1D pool(Layer1D originalLayer, int dimensionOfPool) {
    
    if (dimensionOfPool/2 == 0.0) {
      return evenCaseHelper(originalLayer, dimensionOfPool);
    } else {
      return oddCaseHelper(originalLayer, dimensionOfPool);
    }
  }
  
  private Layer1D evenCaseHelper(Layer1D originalLayer, int dimensionOfPool) {
    
    Layer1D poolLayer = new Layer1D(originalLayer.getDimensions());
    
    
    return poolLayer;
  }
  
  private Layer1D oddCaseHelper(Layer1D originalLayer, int dimensionOfPool) {
    
    Layer1D poolLayer = new Layer1D(originalLayer.getDimensions());
    ArrayList<Node1D> nodes = originalLayer.getNodes();
    
    int special = (int) Math.ceil(dimensionOfPool/2);    
    
    for (int i = 0; i < special - 1; i++) {
      ArrayList<Node1D> upperSubList = (ArrayList<Node1D>) nodes.subList(0, special + i);
      ArrayList<Node1D> lowerSubList = (ArrayList<Node1D>) nodes.subList(nodes.size() - special - i, nodes.size());
      
      double upperMax = -100;
      double lowerMax = -100;
      
      for (int j = 0; j < upperSubList.size(); j++) {
        upperMax = Math.max(upperMax, upperSubList.get(j).getNodeValue());
        lowerMax = Math.max(lowerMax, lowerSubList.get(j).getNodeValue());
      }
      
      poolLayer.getNode(i).setNodeValue(upperMax);
      poolLayer.getNode(nodes.size() - i - 1).setNodeValue(lowerMax);
    }
    
    for (int i = special - 1; i < nodes.size() - (special - 1); i++) {
      ArrayList<Node1D> subList = (ArrayList<Node1D>) nodes.subList(i - (special - 1), i + special);
      
      double max = -100;
      
      for (int j = 0; j < subList.size(); j++) {
        max = Math.max(max, subList.get(j).getNodeValue());
      }
      
      poolLayer.getNode(i).setNodeValue(max);
    }
    
    return poolLayer;
  }

}
