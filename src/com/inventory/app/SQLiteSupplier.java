
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.app;
import java.io.File;

/**
 *
 * @author Pads
 */
public class SQLiteSupplier {
     static java.sql.Connection conn  = null;
static java.sql.Statement stmt = null;
static java.sql.ResultSet rs = null;
    static java.sql.PreparedStatement pstmt = null;

static File temp = new File("inventory.sqlite");
static String url = "jdbc:sqlite:" + temp.getAbsolutePath().replace("\\","\\\\");
//static String url = "jdbc:sqlite:C:\\Users\\Pads\\Documents\\NetBeansProjects\\InventoryPM\\src\\com\\inventory\\app\\inventory.sqlite";
static String error = "";

public static boolean openDB(){
    boolean result = false;
    try{
        Class.forName("org.sqlite.JDBC");
        conn = java.sql.DriverManager.getConnection(url);

        System.out.println("OK! SQLite DB session connected.");
        result = true;
    }
    catch(Exception e){
        error = e.getMessage();
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
        error = e.getMessage();
        System.out.println("Close DB Error: " + e.getMessage());
    }
    return result;
} 
public static boolean create(String table, String values){
    boolean result = false;
     String query = null;
    try{
        SQLiteSupplier.stmt = conn.createStatement();
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
public static boolean update(String table, String set, String SupplierID){
    boolean result = false;
    try{
        SQLiteSupplier.stmt = conn.createStatement();
        String query = "UPDATE "+ table +" SET " + set + " WHERE SupplierID=" + SupplierID;
        stmt.executeUpdate(query);
        //You can include exception handling here. (e.g. Duplicate Data, etc.)
        result = true;
    }
    catch(Exception e){
        System.out.println("Create Error: " + e.getMessage());
    }
    return result;
}
public static boolean delete(String table, String SupplierID){
        boolean result = false;
        try{
            SQLiteSupplier.stmt = conn.createStatement();
            String query = "DELETE FROM "+ table +" WHERE SupplierID LIKE '%"+SupplierID+"%'";
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    } 
public static String[][] read(String table){
    String[][] records = null;
    try{
        SQLiteSupplier.stmt = conn.createStatement();
        
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
public static boolean executeDML(String query){
        boolean result = false;
        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Execute DML Error: " + e.getMessage());
            System.out.println("Query: " + query);
        }
        return result;
    }
public static boolean executeDML(String query, Object[] values){
        boolean result = false;
        if(openDB()){
            try{
                pstmt = null;
                pstmt = conn.prepareStatement(query);
                for(int i=1,j=0;i<=values.length;i++,j++){
                    pstmt.setObject(i, values[j]);
                }
                pstmt.executeUpdate();
                result = true;
            }
            catch(Exception e){
                error = e.getMessage();
                System.out.println("Execute DML Error: " + e.getMessage());
                System.out.println("Query: " + query);
            }
            closeDB();
        }
        return result;
    }    
public static String[][] executeDQL(String table, String[] columns, String where){
        String[][] records = null;
        if(openDB()){
            try{
                String[] w = where.split(";");
                
                stmt = conn.createStatement();
                
                //Count total rows
                rs = stmt.executeQuery("SELECT count(*) FROM " + table + " WHERE " + w[0]);
                int totalRows = 0;
                if(rs.next())totalRows = rs.getInt(1);
                
                //Format columns
                String cols = "";
                for (int i=0;i<columns.length;i++) {
                    cols += columns[i];
                    if((i+1)!=columns.length)cols+=", ";
                }
                
                //Execute DML Query
                rs = stmt.executeQuery("SELECT "+ cols +" FROM " + table + " WHERE " + w[0]);
                java.sql.ResultSetMetaData rsmd = rs.getMetaData();
                
                //Count total columns
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
                error = e.getMessage();
                System.out.println("Execute DQL Error: " + e.getMessage());
            }
            closeDB();
        }
        return records;
    } 
 public static String[][] sortA(String table, String column){
        String[][] records = null;
        try{
            SQLiteSupplier.stmt = conn.createStatement();

            //Count total rows
            java.sql.ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table + " ORDER BY "+ column);
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
public static void main(String [] args){
	if(SQLiteSupplier.openDB()){
    String SupplierID = ""; //If you receive an error, probably sqlite detect duplicate ID value.
    String SupplierName = "";
    String ContactNo =  "";
    String Address = "";
 
    if(create("Supplier","'"+SupplierID+"'"+","+"'"+SupplierName+"'"+","+"'"+ContactNo+"'"+","+"'"+Address+"'")){
        System.out.println("Inserted successfully!");
    }
    SQLiteSupplier.closeDB();
}  
        if(SQLiteSupplier.openDB()){
    String SupplierID = "";
    String SupplierName = "";
    if(update("Supplier", "SupplierName="+SupplierName+"'", SupplierID)){
        System.out.println("Updated successfully!");
    }
    SQLiteSupplier.closeDB();
} 
        if(SQLiteSupplier.openDB()){
    String SupplierID = "";
    if(delete("Supplier", SupplierID)){
        System.out.println("Deleted successfully!");
    }
    SQLiteSupplier.closeDB();
} 
        if(SQLiteSupplier.openDB()){
    String[][] r = read("Supplier");
    System.out.println("SupplierID:" + r[0][0]);
    System.out.println("SupplierName:" + r[0][1]);
    System.out.println("ContactNo:" + r[0][2]);
    System.out.println("Address:" + r[0][3]);

    SQLiteSupplier.closeDB();
}
}
}
