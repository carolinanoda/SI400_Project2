package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcos-medeiros
 */
public class MariaDBConnection implements InterfaceDatabaseDAO {
    private String DB = "jdbc:mariadb://localhost:3306/DB?user={{user}}&password={{password}}";
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
    
    @Override
    public void terminate() {
        try {
            (this.getConnection()).close();
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
