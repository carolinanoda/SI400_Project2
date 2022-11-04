/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcos-medeiros
 */
public class MariaDBConnection {
    public final String DB = "jdbc:mariadb://localhost:3306/DB?user={{user}}&password={{password}}";
    
    private Connection connection;
    
    private String user = null;
    private String password = null;
    
    public MariaDBConnection(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            try {
                DB.replaceAll("\\{\\{user\\}\\}", this.user);
                DB.replaceAll("\\{\\{password\\}\\}", this.password);
                
                this.connection = DriverManager.getConnection(DB);
                
                if (this.connection != null) {
                    DatabaseMetaData metadata = this.connection.getMetaData();
                }
            } catch (SQLException exception) {
                System.err.println("Exception: " + exception.getMessage());
            }
        }
        return this.connection;
    }
    
    public void terminate() {
        try {
            (this.getConnection()).close();
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}