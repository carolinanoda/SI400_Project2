package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author marcos-medeiros, GutoRomagnolo
 */
public class SQLiteConnection implements InterfaceDatabaseDAO {
    private String DB = "jdbc:sqlite:SI400A-Project2.db";
    private Connection connection;
    
    @Override
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

    @Override
    public ResultSet getResultSet(String query) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
        return resultSet;
    }
    
    @Override
    public void terminate() {
        try {
            (this.getConnection()).close();
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
