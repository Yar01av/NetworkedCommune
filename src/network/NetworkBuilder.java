/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Groups tools for quick network building
 * 
 * @author Yaroslav Nazarov
 */
public class NetworkBuilder {
    private final Function<BiFunction<Node, Integer, Node>, Node> nodeConstructor;
    private final BiFunction<Node, Integer, Node> algorithm;
    
    public NetworkBuilder(Function<BiFunction<Node, Integer, Node>, Node> constructor, BiFunction<Node, Integer, Node> algorithm) {
        nodeConstructor = constructor;
        this.algorithm = algorithm;
    }
    
    private Node makeNode() {
        return nodeConstructor.apply(algorithm);
    }
    
    public void addChain(List<Node> network, int length) {
        assert length > 0;
        
        int initLength = network.size();
        
        for (int i = 0; i < length; i++) {
            network.add(makeNode());
        }
        
        for (int i = 1; i < length; i++) {
            Node prev = network.get(initLength+i-1);
            network.get(initLength+i).connect(prev);
        }
    }
    
    public void addFork(List<Node> network) {
        int initLength = network.size();

        addChain(network, 2);
        network.add(makeNode());
        network.get(initLength+1).connect(network.get(initLength+2));
        network.add(makeNode());
        network.get(initLength+1).connect(network.get(initLength+3));
        
    }
    
    public void addLoop(List<Node> network, int length) {
        int initLength = network.size();
        
        addChain(network, length);
        network.get(network.size() - 1).connect(network.get(initLength));
        
    }
}
