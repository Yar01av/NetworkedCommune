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
 NotNull: neighbours != null
 ID: ID == nodeCount
     */
    
    public enum Status {
        REACHED,  // Message reached the node
        DENIED,  // Message was rejected by the right node
        FAILED  // Message could not reach a node
    }
    
    private static int nodeCount = 0;  // #nodes created with the constructor
                                       // should not be modified outside of the 
                                       // contructor
    public final int ID;  // #nodes created with the constructor
    private Collection<Node> neighbours;  // List of the nodes connected to this
    BiFunction<Node, Integer, Node> searchAlgorithm;  // How to find the 
                                                              // node needed
    
    public Node(Collection<Node> neighbours, 
                BiFunction<Node, Integer, Node> searchAlgorithm) {
        this(searchAlgorithm);
        this.neighbours = neighbours;
    }
    
    public Node(BiFunction<Node, Integer, Node> searchAlgorithm) {
        ID = nodeCount++;
        this.searchAlgorithm = searchAlgorithm;
    }
    
    /**
     * Used to send messages
     * @param adresseeID  Node (id of) to send the message to
     * @param message  Message to be send to the node
     * @return Status that indicates whether the message reached the node
     */
    public Status sendMessage(int adresseeID, String message) { 
        final Node destintion = searchAlgorithm.apply(this, adresseeID);

        if (destintion == null) {
            return Status.FAILED;
        } else {
            return sendMessage(destintion, message);
        }
    }
    
    public Status sendMessage(Node addressee, String message) {
        System.out.println("Node-" + ID + " sends message to node-" 
                           + addressee.ID);
        
        addressee.receiveMessage(message);
        
        System.out.println("Node-" + addressee.ID + " reached");
        
        return Status.REACHED;
    }
    
    private void receiveMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); 
            //To change body of generated methods, choose Tools | Templates.
    }

    public void setNeighbours(Collection<Node> neighbours) {
        this.neighbours = neighbours;
    }
    
    /**
     * Adds the node to the list of the neighbours and adds itslf to the node's 
     * neighbours
     * 
     * @param node  Node to be connected to
     */
    public void connect(Node node) {
        node.neighbours.add(this);  // Add this to the node's neighbours
        this.neighbours.add(node);  // And  the other way around
    }
    
    /**
     * Removes the node from the list of the neighbours and removes itself from 
     * the node's neighbours
     * 
     * @param node  Node to be connected to
     */
    public void disconnect(Node node) {
        node.neighbours.remove(this);  // Add this to the node's neighbours
        this.neighbours.remove(node);  // And  the other way around
    }
}
