/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

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
public abstract class RecorderTestCases {
    Recorder storageInstance;
    
    abstract void setStorageInstance();
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        storageInstance.reset();
    }

    /**
     * Test of addRecord method, of class Recorder.
     */
    @Test
    public void testAddRecord() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test of getAllRecords method, of class Recorder.
     */
    @Test
    public void testGetAllRecords() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test of emptyInstnces method, of class Recorder.
     */
    @Test
    public void testEmptyInstnces() {
        throw new UnsupportedOperationException();
    }
}
