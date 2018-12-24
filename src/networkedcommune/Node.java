/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Yaroslav Nazarov
 */
public abstract class Node {
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
    protected final int nodeID;  // #nodes created with the constructor
    protected Collection<Node> neighbours;  // List of the nodes connected to this
    
    public Node() {
        nodeID = nodeCount++;
    }
    
    /**
     * Used to send messages
     * @param adressee  Node to send the message to
     * @return Status that indicates whether the message reached the node
     */
    public abstract Status sendMessage(int adresseeID);
    
    public int getNodeID() {
        return nodeID;
    }
}
