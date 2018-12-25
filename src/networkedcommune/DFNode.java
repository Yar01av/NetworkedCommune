/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

/**
 * Node that uses breadth-first search to find the adressee
 * 
 * @author Yaroslav Nazarov
 */
public class DFNode extends Node {
    /**
     * Representation Invariant:
     * 
     */
    
    @Override
    Node getAdresseeNode(int adresseeID) {
        for (Node node : neighbours) {
            if (node.nodeID == adresseeID) {
                System.out.println("Node-" + adresseeID + " reached!");
            } else {
                node.sendMessage(adresseeID);
            }
        }
        
        return ;
    }    
}
