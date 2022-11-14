package Controller;

import Model.TextLines;
import Model.TextLinesDAO;
import Model.WriteFile;
import java.io.IOException;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author carol
 */

public class Controller{
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
    
    public static void setLoginDB(String login) {
        Configurations.MariaDB_login = login;
    }
    
    public static String getLoginDB() {
        return Configurations.MariaDB_login;
    }
    
    public static void setPasswordDB(String password) {
        Configurations.MariaDB_password = password;
    }
    
    public static String getPasswordDB() {
        return Configurations.MariaDB_password;
    }
}
