package Controller;

import Model.ConnectionFactory;
import Model.DatabaseUser;
import Model.InterfaceDatabaseDAO;
import Model.TextLines;
import Model.TextLinesDAO;
import Model.WriteFile;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.swing.JTextArea;

/**
 * Class responsible for intermediating the visualization requests for data 
 * manipulation.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public class Controller {
    public static String SGBD = "MariaDB";
    public static DatabaseUser MariaDBObject = null;
    
    /**
     * Method responsible for showing the selected text in the text area.
     * @param textArea where will be shown the selected text.
     * @param groupId int value that storages the selected group.
     */
    public static void textExibition(JTextArea textArea, int groupId){
        try {
            List<TextLines> lines = TextLinesDAO.getInstance().retrieveAllLines(groupId);

            for (TextLines line : lines) {
                textArea.append(line.getText() + "\n");
            }

            textArea.setCaretPosition(0);
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
    
    /**
     * Writes a file to disk with the text as the content.
     * @param textArea where the text was shown.
     * @param groupId int value that storages the selected group.
     * @throws IOException Exception thrown when there's a problem saving the file.
     */
    public static void makeFile(JTextArea textArea, int groupId) throws IOException {
        List<TextLines> lines = TextLinesDAO.getInstance().retrieveAllLines(groupId);
        
        String file_name = lines.get(0).getFile();
        
        (new WriteFile()).writeFile(textArea.getText(), file_name);
    }
    
    /**
     * Sets the user's input as the data for the database connection.
     * @param host
     * @param port
     * @param base
     * @param login
     * @param password 
     */
    public static void databaseUser(String host, String port, String base, String login, String password) {
        Controller.MariaDBObject = new DatabaseUser(host, port, base, login, password);
    }
    
    /**
     * Attempts to establish a connection to the database.
     * @return boolean if a connection has been establishes.
     */
    public static boolean checkDatabase() {
        try {
            InterfaceDatabaseDAO connection = (new ConnectionFactory()).getSGBD(Controller.SGBD);
            return (connection.getConnection() instanceof Connection);   
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
            return false;
        }
    }
}
