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
            List<TextLines> text = TextLinesDAO.getInstance().retrieveAllLines(groupId);
            WriteFile file_writer = WriteFile.getInstance();
            
            for (TextLines line : text) {
               textArea.append(line.getText() + "\n");
               file_writer.writeFile(line.getText() + "\n");
            }
            
            textArea.setCaretPosition(0);
        } catch (IOException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }

    
}
