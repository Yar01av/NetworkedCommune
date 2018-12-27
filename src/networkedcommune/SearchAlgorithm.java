/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

/**
 * Contains an algorithm to get the node with the right id
 * 
 * @author Yaroslav Nazarov
 */
public interface SearchAlgorithm {
    /**
     * Gets the node with that id
     * 
     * @param startingNode  node that the search starts from
     * @param adresseeID  id of the node to find
     * @pre the node can be reached from the sending node
     * @return the node which has its id as adresseeID
     */
    abstract Node searchNode(Node startingNode, int adresseeID);
}
