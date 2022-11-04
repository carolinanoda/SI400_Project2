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
public class SQLiteConnection implements InterfaceDatabaseDAO {
    public final String DB = "jdbc:sqlite:SI400A-Project2.db";

    private Connection connection;

    public Connection getConnection() {
        if (this.connection == null) {
            try {
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
