/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

import java.util.HashSet;
import java.util.Set;



/**
 * Depth-first search algorithm
 * 
 * @author Yaroslav Nazarov
 */
public class DFSearchAlgorithm implements SearchAlgorithm {
    private Set<Node> wasSeen = new HashSet<>();
    
    @Override
    public Node searchNode(Node startingNode, int adresseeID) {
        //Only important at the very first call
        wasSeen.add(startingNode);
        
        if (startingNode.ID == adresseeID) {
            return startingNode;
        }
        
        for (Node node : startingNode.getNeigbours()) {
            if (!wasSeen.contains(node)) {
                wasSeen.add(node);
                
                if (node.ID == adresseeID) {
                    return node;
                } else {
                    //Search further if needed
                    Node furtherNode = searchNode(node, adresseeID);
        
                    if (furtherNode != null) {
                        return furtherNode;
                    } 
                }
            } 
        }
        
        return null;
    } 
}
