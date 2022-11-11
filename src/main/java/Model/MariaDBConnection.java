package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marcos-medeiros
 */
public class MariaDBConnection implements InterfaceDatabaseDAO {
    private String DB = "jdbc:mariadb://localhost:3306/SI400?user={{user}}&password={{password}}";
    private Connection connection;
    private String user = null;
    private String password = null;
    
    public MariaDBConnection(String user, String password) {
        this.user = user;
        this.password = password;
    }
    
    @Override
    public Connection getConnection() {
        if (this.connection == null) {
            try {
                String DBString = DB.replaceAll("\\{\\{user}}", this.user);
                DBString = DBString.replaceAll("\\{\\{password}}", this.password);
                
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
