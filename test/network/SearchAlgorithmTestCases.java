/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import network.SearchAlgorithm;
import network.NetworkBuilder;
import network.Node;
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
    NetworkBuilder builder;
    
    private Node makeNode() {
        return new Node(algorithm::searchNode);
    }
    
    //Sets the network for testing
    @Before
    public void setEmptyNetworkInstance() {
        network = new ArrayList<>();
        Node.resetNodeCount();
    }
    
    /** Network architectures */

    
    /** Tests for the searchNode method */
    @Test
    public void testSearchNodeChain() {
        builder.addChain(network, 3);
        
        assertEquals(algorithm.searchNode(network.get(0), 2), 
                                          network.get(2));
    }
    
    @Test
    public void testSearchNodeChainRev() {
        builder.addChain(network, 5);
        
        assertEquals(algorithm.searchNode(network.get(4), 0), 
                                          network.get(0));
    }
    
    @Test
    public void testSearchNodeFork() {
        builder.addFork(network);
        
        assertEquals(algorithm.searchNode(network.get(0), 3), 
                                          network.get(3));
    }
    
    @Test
    public void testSearchNodeForkRev() {
        builder.addFork(network);
        
        assertEquals(algorithm.searchNode(network.get(3), 0), 
                                          network.get(0));
    }
    
    @Test
    public void testSearchNodeLoop() {
        //TODO (brunch out)
        builder.addLoop(network, 3);
        network.add(makeNode());
        network.get(3).connect(network.get(1));
        
        assertEquals(algorithm.searchNode(network.get(0), 2), 
                                          network.get(2));
    }
    
    @Test
    public void testSearchNodeItself() {
        //TODO (brunch out)
        builder.addChain(network, 2);
        
        assertEquals(algorithm.searchNode(network.get(0), 0), 
                                          network.get(0));
    }
}
