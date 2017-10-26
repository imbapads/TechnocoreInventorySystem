

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.app;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Pads
 */
public class SQLiteLogin {
    public static int count;
    static java.sql.Connection conn  = null;
    static java.sql.Statement stmt = null;
    
    static File temp = new File("inventory.sqlite");
    static String url = "jdbc:sqlite:" + temp.getAbsolutePath().replace("\\", "\\\\");
  //static String url = "jdbc:sqlite:C:\\Users\\Pads\\Documents\\NetBeansProjects\\TechnoCorePM\\src\\com\\inventory\\app\\inventory.sqlite";
  
    public static boolean openDB(){
        boolean result = false;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);

            System.out.println("OK! SQLite DB session connected.");
            result = true;
        }
        catch(Exception e){
            
           String error = e.getMessage();
            System.out.println("Open DB Error:" + e.getMessage());
        } 
        return result;
    }
     public static boolean closeDB(){
        boolean result = false;
        try{
            conn.close();

            System.out.println("OK! SQLite DB session closed.");
            result = true;
        }
        catch(Exception e){
            
            String error = e.getMessage();
            System.out.println("Close DB Error: " + e.getMessage());
        }
        return result;
    }
        public static Connection opensDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);
            System.out.println("OK! SQLite DB session connected.");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        } 
    }
        public static Connection closesDB(){
        try{
            conn.close();
            System.out.println("OK! SQLite DB session closed.");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
        public static boolean create(String table, String values){
        boolean result = false;
        String query = null;
        try{
            SQLiteLogin.stmt = conn.createStatement();
            query = "INSERT INTO "+ table +" VALUES(" + values + ")";
            stmt.executeUpdate(query);            
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
            System.out.println("Query: " + query);
        }
        return result;
    }
        public static boolean createUser(String table, String values){
        boolean result = false;
        String query = null;
        try{
            SQLiteLogin.stmt = conn.createStatement();
            query = "INSERT INTO "+ table +" (FIRSTNAME,LASTNAME,USERNAME,PASSWORD,CONPASS) VALUES(" + values + ")";
            stmt.executeUpdate(query);            
            //You can include exception handling here. (e.g. Duplicate Data, etc.)
            
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
            System.out.println("Query: " + query);
        }
        return result;
    }    
    
    //Create Record Method
    public static boolean create(String table, String columns, String stmts, String[] values){
        boolean result = false;
        String query = null;
        try{
            //query = "INSERT INTO " + table +" ("+ columns +") VALUES("+ stmts +")"; 
            query = "INSERT INTO "+ table +" ("+columns+") VALUES("+stmts+")";
            ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
            
            pstmt = conn.prepareStatement(query);
            for(int i=1,j=0;i<=values.length;i++,j++){
                pstmt.setString(i, values[j]);
            }
            //pstmt.setString(1, values[0]);
            //pstmt.setString(2, "Aug 4, 2017");
            pstmt.executeUpdate();
            
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
            System.out.println("Query: " + query);
        }
        return result;
    }
    public static String[][] read(String table){
    String[][] records = null;
    try{
        SQLiteLogin.stmt = conn.createStatement();
        
        //Count total rows
        java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
        int totalRows = rs.getInt(1);
        
        //Count total columns
        rs = stmt.executeQuery("SELECT * FROM " + table);
        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
        int totalColumns = rsmd.getColumnCount();
        
        //Initialize 2D Array "records" with totalRows by totalColumns
        records = new String[totalRows][totalColumns];
        
        //Retrieve the record and store it to 2D Array "records"
        int row=0;
        while(rs.next()){                
            for(int col=0,index=1;col<totalColumns;col++,index++){
                records[row][col] = rs.getObject(index).toString();
            }
            row++;
        }            
    }
    catch(Exception e){
        System.out.println("Read Error: " + e.getMessage());
    }
    return records;
}
public static String[][] read(String table, String[] columns){
        String[][] records = null;
        try{
            SQLiteLogin.stmt = conn.createStatement();

            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);
            

            //Count total columns
            int totalColumns = columns.length;
            count = totalRows;
            String cols = "";
            for(int i=0;i<totalColumns;i++){
                cols += columns[i];
                if((i+1)!=totalColumns)cols+=", ";
            }
            rs = stmt.executeQuery("SELECT "+ cols +" FROM " + table);

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
 public static String[][] read(String table, String where){
        String[][] records = null;
        try{
            stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table + " WHERE " + where);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE " + where);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }       
}
