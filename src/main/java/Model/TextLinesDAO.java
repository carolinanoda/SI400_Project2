package Model;

import Controller.Controller;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class responsible for obtaining records from the Fragments table and 
 * transforming them into an object to perform the data manipulation process 
 * in the program.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public class TextLinesDAO extends ConnectionFactory {
    private static TextLinesDAO instance;
    
    /**
     * Class constructor.
     * @return TextLinesDAO instance of TextLinesDAO class.
     */
    public static TextLinesDAO getInstance() {
        return ((instance == null) ? (instance = new TextLinesDAO()) : instance);
    }
    
    /**
     * @param result_set table of data representing a database result set.
     * @return textLine object that retrives the values of the columns.
     */
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
    
    /**
     * Acesses database and returns an array list with the all text lines.
     * @param query to be executed.
     * @return ArrayList textLines that represents all the text lines.
     */
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
    
    /**
     * @param groupId int value that storages the selected text.
     * @return List retriveAllLines that retrieves the records of the Framents table.
     */
    public List retrieveAllLines(int groupId) {
        return this.retrieve("SELECT * FROM Fragmentos WHERE groupId = " + groupId + " ORDER BY line ASC");
    }
}
