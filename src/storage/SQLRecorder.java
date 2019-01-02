package storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Makes records in SQL databases. One for each owner.
 * 
 * @author Yaroslav Nazarov
 */
public class SQLRecorder extends Recorder {
    static SQLRecorder instance = null;

    private SQLRecorder() {
        
    }
    
    public static SQLRecorder getInstance() {
        if (instance == null) {
            instance = new SQLRecorder();
        }
        return instance;
    }
    
    @Override
    public void addRecord(String message, int ownerID) {
        Connection conn = null;
        
        try {
            // db parameters
            String url = "jdbc:sqlite:" + ownerID + ".db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
