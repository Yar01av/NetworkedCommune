/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import network.NetworkBuilder;
import network.DFSearchAlgorithm;
import network.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yaroslav Nazarov
 */
public class DFSearchAlgorithmTest extends SearchAlgorithmTestCases {

    public DFSearchAlgorithmTest() {
        algorithm = new DFSearchAlgorithm();
        builder = new NetworkBuilder(Node::new, algorithm::searchNode);
    }
    
}
