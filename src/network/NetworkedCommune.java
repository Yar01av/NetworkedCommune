/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yaroslav Nazarov
 */
public class NetworkedCommune {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Poor man's test of the Recorder faciltity
        List<Node> network = new ArrayList<>();
        network.add(new Node(new DFSearchAlgorithm()::searchNode));
        network.add(new Node(new DFSearchAlgorithm()::searchNode));
        network.get(0).connect(network.get(1));
        
        network.get(0).sendMessage(1, "Hello!");
    }
    
}
