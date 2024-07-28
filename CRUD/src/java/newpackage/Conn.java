/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author samee
 */
public class Conn {
        public static Connection getConnection() {
        
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/crud1_javapoint";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,"root","");
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
}
