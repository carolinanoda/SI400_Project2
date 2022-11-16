package Model;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Interface responsible for creating a contract so that the database connection
 * classes have standardized behaviors.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public interface InterfaceDatabaseDAO {
    Connection getConnection();
    ResultSet getResultSet(String query);
    void terminate();
}
