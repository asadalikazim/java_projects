package com.neuralNetworks.dropOutLayers;

import java.util.ArrayList;
import com.neuralNetworks.basicDataTypes.Layer2D;

public class CheckEachNode2D implements DropOutLayer {
  
  public Layer2D smallerLayer(Layer2D originalLayer, double probability) {
    
    ArrayList<Integer> dimensions = originalLayer.getDimensions();
    Layer2D smallerLayer = new Layer2D(dimensions);    
        
    for (int i = 0; i <  dimensions.get(0); i++) {     
      for (int j = 0; j < dimensions.get(1); j++) {
        double check = Math.random();
        if (check >= probability) {
          smallerLayer.addNode(originalLayer.getNode(i, j));
        }
      }      
    }   
    
    return smallerLayer;
  }

}
