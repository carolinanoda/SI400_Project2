package Model;

import Controller.Controller;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class responsible for connecting the application with the MariaDB database.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public class MariaDBConnection implements InterfaceDatabaseDAO {
    private String DB = "jdbc:mariadb://{{host}}:{{port}}/{{database}}?user={{user}}&password={{password}}";
    private Connection connection;
    
    /**
     * Tries to establish a connection to MariaDB with user's input.
     * @return connection object of Connection class.
     */
    @Override
    public Connection getConnection() {
        if (this.connection == null) {
            try {
                String DBString = DB.replaceAll("\\{\\{host}}", Controller.MariaDBObject.getHost());
                DBString = DBString.replaceAll("\\{\\{port}}", Controller.MariaDBObject.getPort());
                DBString = DBString.replaceAll("\\{\\{database}}", Controller.MariaDBObject.getBase());
                DBString = DBString.replaceAll("\\{\\{user}}", Controller.MariaDBObject.getUser());
                DBString = DBString.replaceAll("\\{\\{password}}", Controller.MariaDBObject.getPassword());
                
                this.connection = DriverManager.getConnection(DBString);
                
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
