/*
 * TODO 
 * > create abstract singleton
 */
package storage;

import utility.Resetable;

/**
 *
 * @author Yaroslav Nazarov
 */
abstract public class Recorder implements Resetable {    
    /**
     * Adds an entry to the database (unique for this owner)
     * 
     * @param message  text of the new entry
     * @param ownerID  id to be used to name the DB
     */
    abstract public void addRecord(String message, int ownerID);
}
