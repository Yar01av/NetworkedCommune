/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

/**
 * Depth-first search algorithm
 * 
 * @author Yaroslav Nazarov
 */
public class DFSearchAlgorithm implements SearchAlgorithm {
    @Override
    public Node searchNode(Node startingNode, int adresseeID) {
        for (Node node : startingNode.getNeigbours()) {
            if (!node.equals(startingNode)) {
                if (node.ID == adresseeID) {
                    return node;
                } else {
                    if (searchNode(node, adresseeID) != null) {
                        return node;
                    }
                }
            } 
        }
        
        return null;
    } 
    
}
