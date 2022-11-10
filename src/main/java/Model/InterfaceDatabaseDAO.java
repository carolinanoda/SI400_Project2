package Model;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author marcos-medeiros
 */
public interface InterfaceDatabaseDAO {
    Connection getConnection();
    ResultSet getResultSet(String query);
    void terminate();
}
