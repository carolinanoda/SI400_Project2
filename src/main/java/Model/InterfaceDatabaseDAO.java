package Model;

import java.sql.Connection;

/**
 *
 * @author marcos-medeiros
 */
public interface InterfaceDatabaseDAO {
    Connection getConnection();
    void terminate();
}
