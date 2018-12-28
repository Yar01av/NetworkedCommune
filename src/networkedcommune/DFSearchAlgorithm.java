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
    //Does not work! Last return is never possible in practice, ...
        for (Node node : neighbours) {
            if (node.ID == adresseeID) {
                return node;
            } else {
                if (node.searchNode(adresseeID) != null) {
                    return node;
                }
            }
        }
        
        return null;
    } 
    
}
