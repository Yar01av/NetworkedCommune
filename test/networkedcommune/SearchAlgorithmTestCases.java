/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkedcommune;

import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Yaroslav Nazarov
 */
public abstract class SearchAlgorithmTestCases {
    List<Node> network;
    SearchAlgorithm algorithm;
    
    private Node makeNode() {
        return new Node(algorithm::searchNode);
    }
    
    //Sets the network for testing
    @Before
    public void setEmptyNetworkInstance() {
        network = new ArrayList<>();
    }
    
    /** Network architectures */
    private void addChainNetwork(int length) {
        int initLength = network.size();
        
        for (int i = 0; i < length; i++) {
            network.add(makeNode());
        }
        
        for (int i = 1; i < length; i++) {
            Node prev = network.get(initLength+i-1);
            network.get(initLength+i).connect(prev);
        }
    }
    
    private void addFork() {
        int initLength = network.size();

        addChainNetwork(2);
        network.add(makeNode());
        network.get(initLength+1).connect(network.get(initLength+2));
        network.add(makeNode());
        network.get(initLength+1).connect(network.get(initLength+3));
        
    }
    
    private void addLoop(int length) {
        int initLength = network.size();
        
        addChainNetwork(length);
        network.get(network.size() - 1).connect(network.get(initLength));
        
    }
    
    /** Tests for the searchNode method */
    @Test
    public void testSearchNodeChain() {
        addChainNetwork(5);
        
        assertEquals(algorithm.searchNode(network.get(0), 4), 
                                          network.get(4));
    }
    
    @Test
    public void testSearchNodeChainRev() {
        addChainNetwork(5);
        
        assertEquals(algorithm.searchNode(network.get(4), 0), 
                                          network.get(0));
    }
    
    @Test
    public void testSearchNodeFork() {
        addFork();
        
        assertEquals(algorithm.searchNode(network.get(0), 3), 
                                          network.get(3));
    }
    
    @Test
    public void testSearchNodeForkRev() {
        addFork();
        
        assertEquals(algorithm.searchNode(network.get(3), 0), 
                                          network.get(0));
    }
    
    @Test
    public void testSearchNodeLoop() {
        addLoop(3);
        
        assertEquals(algorithm.searchNode(network.get(0), 2), 
                                          network.get(2));
    }
}
