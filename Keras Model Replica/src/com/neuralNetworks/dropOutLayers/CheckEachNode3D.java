package com.neuralNetworks.dropOutLayers;

import java.util.ArrayList;
import com.neuralNetworks.basicDataTypes.Layer3D;

public class CheckEachNode3D implements DropOutLayer {
  
  public Layer3D smallerLayer(Layer3D originalLayer, double probability) {
    
    ArrayList<Integer> dimensions = originalLayer.getDimensions();
    Layer3D smallerLayer = new Layer3D(dimensions);    
    
    for (int i = 0; i < dimensions.get(0); i++) {     
      for (int j = 0; j < dimensions.get(1); j++) {        
        for (int k = 0; k < dimensions.get(2); k++) {          
          double check = Math.random();
          if (check >= probability) {
            smallerLayer.addNode(originalLayer.getNode(i, j, k));
          }
        }
      }
    }
    
    return smallerLayer;
  }
}
