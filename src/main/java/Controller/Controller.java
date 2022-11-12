package Controller;

import Model.TextLines;
import Model.TextLinesDAO;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author carol
 */

public class Controller{
    public static void textExibition(JTextArea textArea, int groupId){
        try {
            List<TextLines> text = TextLinesDAO.getInstance().retrieveAllLines(groupId);

            for (TextLines line : text) {
               textArea.append(line.getText() + "\n");
            }   
        } catch (Exception exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
    
}
