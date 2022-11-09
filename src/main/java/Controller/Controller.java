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
    
//    public class connectDatabase(){
//        
//    }
//    
//    public void disconnectDatabase(){
//
//    }
    
    public static void textExibition(JTextArea textArea){
        List<TextLines> text = TextLinesDAO.getInstance().retrieveAllLines();
         for (TextLines line : text) {
             textArea.append(line.getText() + "\n");
         }
    }
    
}
