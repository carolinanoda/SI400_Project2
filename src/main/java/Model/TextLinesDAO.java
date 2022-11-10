package Model;

import Controller.Configurations;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcos-medeiros, GutoRomagnolo
 */
public class TextLinesDAO extends ConnectionFactory {

    private static TextLinesDAO instance;
    private static InterfaceDatabaseDAO connection;

    private TextLinesDAO() {
        connection = getSGBD(Configurations.SGBD);
        connection.getConnection();
    }

    public static TextLinesDAO getInstance() {
        return ((instance == null) ? (instance = new TextLinesDAO()) : instance);
    }

    private TextLines buildObject(ResultSet result_set) {
        TextLines textLine = null;

        try {
            textLine =
                new TextLines(
                    result_set.getInt("groupId"),
                    result_set.getString("file"),
                    result_set.getInt("line"),
                    result_set.getString("text")
                );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return textLine;
    }

    public List retrieve(String query) {
        List<TextLines> textLines = new ArrayList();
        ResultSet result_set = connection.getResultSet(query);

        try {
            while (result_set.next()) {
                textLines.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
        return textLines;
    }

    public List retrieveAllLines() {
        return this.retrieve("SELECT * FROM Fragmentos WHERE groupId = 2 ORDER BY line ASC");
    }
}
