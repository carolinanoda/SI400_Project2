package com.mycompany.si400_project2;
import java.util.List;
import Model.*;

/**
 *
 * @author marcos-medeiros
 */
public class SI400_Project2 {

    public static void main(String[] args) {
        System.out.println("Iniciando testes!");
        System.out.println("\n");

        
        System.out.println("Listando todas as linhas:");
        List<TextLines> textLines = TextLinesDAO.getInstance().retrieveAllLines();
        
        textLines.forEach(textLine -> {
            System.out.println("textLine ID is: " + textLine.getGroupId() + "\n"
                + " his file is: " + textLine.getFile() + "\n"
                + " his line is: " + textLine.getLine() + "\n"
                + " his text is: " + textLine.getText() + "\n"
            );
        });
    }
}
