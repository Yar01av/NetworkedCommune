/*
 * TODO 
 * > create abstract singleton
 */
package storage;

import java.util.ArrayList;
import java.util.List;
import utility.Resetable;

/**
 *
 * @author Yaroslav Nazarov
 */
abstract public class Recorder implements Resetable {
    static private List<Recorder> recorders = new ArrayList<>();
    
    public Recorder() {
        recorders.add(this);
    }
    
    /**
     * Adds an entry to the database (unique for this owner)
     * 
     * @param message  text of the new entry
     * @param senderID  who has sent this message
     */
    abstract public void addRecord(String message, int senderID);
    
    /**
     * Extracts all of its entries
     * 
     */
    abstract public void getAllRecords();
    
    /**
     * Empties the storage of all the instances of the class;
     */
    public static void emptyInstnces() {
        for (Recorder recorder : recorders) {
            recorder.reset();
        }
        
        //Optinally: delete the instances allowing them to be potentially 
        //garbage collected at the cost of failing to guarantee the contract
    }
}
