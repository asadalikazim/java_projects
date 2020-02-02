package com.neuralNetworks.dropOutLayers;

import java.util.ArrayList;
import com.neuralNetworks.basicDataTypes.LayerND;

public class CheckEachNodeND implements DropOutLayer {

  @SuppressWarnings("unchecked")
  public LayerND smallerLayer(LayerND originalLayer, double probability) {
    
    ArrayList<Integer> dimensions = originalLayer.getDimensions();
    LayerND smallerLayer = new LayerND(dimensions);
    
    int level = 0;
    for (int i = 0; i < dimensions.get(level); i++) {
      ArrayList<Integer> nodeID = new ArrayList<Integer>();
      nodeID.add(i);
      smallerLayerHelperND(nodeID, (ArrayList<Object>) originalLayer.getNodes().get(i), level, smallerLayer, originalLayer, dimensions, probability);
    }
    
    return smallerLayer;
  }
  
  @SuppressWarnings("unchecked")
  private void smallerLayerHelperND(ArrayList<Integer> nodeID, ArrayList<Object> nodeArrayObject, int level, LayerND smallerLayer, LayerND originalLayer, ArrayList<Integer> dimensions, double probability) {
    
    if (dimensions.size() == level + 1) {
      double check = Math.random();
      if (check >= probability) {
        smallerLayer.addNode(originalLayer.getNode(nodeID));
      }
    } else {
      for (int i = 0; i < dimensions.get(level); i++) {
        ArrayList<Integer> updatedNodeID = new ArrayList<Integer>();
        updatedNodeID = (ArrayList<Integer>) nodeID.clone();
        updatedNodeID.add(i);
        smallerLayerHelperND(updatedNodeID, (ArrayList<Object>) nodeArrayObject.get(i), level + 1, smallerLayer, originalLayer, dimensions, probability);
      }
    }
  }
}
