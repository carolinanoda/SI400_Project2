package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * Class responsible for connecting the application with the SQLite database.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public class SQLiteConnection implements InterfaceDatabaseDAO {
    private String DB = "jdbc:sqlite:SI400A-Project2.db";
    private Connection connection;
    
    /**
     * Tries to establish a connection to SQLite database with user's input.
     * @return connection object of Connection class.
     */
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
    
    /**
     * @param query to be executed.
     * @return resultSet integer representing the number of rows affected by the SQL statement.
     */
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
    
    /**
     * Ends connection with the database.
     */
    @Override
    public void terminate() {
        try {
            (this.getConnection()).close();
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
