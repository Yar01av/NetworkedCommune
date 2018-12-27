/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author Yaroslav Nazarov
 */
public class Node {
    /**
     * Model: A node that can send messages t other node in the network.
     * 
     * PI:
     * NotNull: neighbours != null
     * ID: nodeID == nodeCount
     */
    
    public enum Status {
        REACHED,  // Message reached the node
        DENIED,  // Message was rejected by the right node
        FAILED  // Message could not reach a node
    }
    
    private static int nodeCount = 0;  // #nodes created with the constructor
                                       // should not be modified outside of the 
                                       // contructor
    public final int nodeID;  // #nodes created with the constructor
    Collection<Node> neighbours;  // List of the nodes connected to this
    BiFunction<Node, Integer, Node> searchAlgorithm;  // How to find the 
                                                              // node needed
    
    public Node(Collection<Node> neighbours, 
                BiFunction<Node, Integer, Node> searchAlgorithm) {
        nodeID = nodeCount++;
        this.neighbours = neighbours;
        this.searchAlgorithm = searchAlgorithm;
    }
    
    /**
     * Used to send messages
     * @param adresseeID  Node (id of) to send the message to
     * @param message  Message to be send to the node
     * @return Status that indicates whether the message reached the node
     */
    public Status sendMessage(int adresseeID, String message) {
        System.out.println("Node-" + nodeID + " sends message to node-" 
                           + adresseeID);
        
        try {
            final Node destintion = searchAlgorithm.apply(this, adresseeID);
            destintion.receiveMessage(message);
        } catch (IllegalArgumentException e) {
            return Status.FAILED;
        }
        
        System.out.println("Node-" + adresseeID + " reached");
        
        return Status.REACHED;
    }
    
    private void receiveMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
    }
}
