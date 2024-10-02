
package it2c.cañedomj.lbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class config {
    
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:canedomj.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }

    public void addBooks (String sql, String... values){
        try (Connection conn = this.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            
            for (int i=0; i < values.length; i++){
                pstmt.setString(i + 1, values[i]);
            }
            
            pstmt.executeUpdate();
            System.out.println("Books added Successfully!");
        }catch (SQLException e){
            System.out.println("Error Adding Record: " + e.getMessage());
        }
    }
}
