package storage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Makes records in SQL databases. One for each owner.
 * 
 * @author Yaroslav Nazarov
 */
public class SQLRecorder extends Recorder {
    String url;
    int ownerID;

    public SQLRecorder(int ownerID) {
        this.ownerID = ownerID;
        Connection conn = null;
        
        try {
            // db parameters
            url = "jdbc:sqlite:" + ownerID + ".db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established by ID:" 
                                + ownerID);
            
            // Making the table
            String querySetUp = "CREATE TABLE IF NOT EXISTS RecievedMessages (\n"
            + "senderID INTEGER,"
            + "message STRING,"
            + "time_stamp DATETIME);";
            
            Statement stmt = conn.createStatement();
            stmt.execute(querySetUp);
            stmt.close();

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
    public void addRecord(String message, int senderID) {
        
        
        // TODO inser proper values
        String queryUpdate = "INSERT INTO RecievedMessages VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(url);
             
             PreparedStatement pstmt = conn.prepareStatement(queryUpdate)) {
            
            pstmt.setDouble(1, senderID);
            pstmt.setString(2, message);
            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void reset() {
        (new File(url)).delete();
    }

    @Override
    public void getAllRecords() {
        // TODO output the records properly
        String query = "CREATE TABLE IF NOT EXISTS RecievedMessages (\n"
            + "sender INTEGER"
            + "message STRING"
            + "time_stamp DATETIME)";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                System.out.println(rs.getInt("senderID") +  "\t" + 
                                   rs.getString("message") + "\t" +
                                   rs.getString("time_stamp"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
