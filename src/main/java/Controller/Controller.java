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
 *
 * @author carol
 */

public class Controller {
    public static String SGBD = "SQLite";
    public static DatabaseUser MariaDBObject = null;
    
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
    
    public static void makeFile(JTextArea textArea, int groupId) throws IOException {
        List<TextLines> lines = TextLinesDAO.getInstance().retrieveAllLines(groupId);
        
        String file_name = lines.get(0).getFile();
        
        (new WriteFile()).writeFile(textArea.getText(), file_name);
    }
    
    public static void databaseUser(String host, String port, String base, String login, String password) {
        Controller.MariaDBObject = new DatabaseUser(host, port, base, login, password);
    }
    
    public static boolean checkDatabase() {
        try {
            System.out.println("Aqui");
            InterfaceDatabaseDAO connection = (new ConnectionFactory()).getSGBD(Controller.SGBD);
            return (connection.getConnection() instanceof Connection);   
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
            return false;
        }
    }
}
