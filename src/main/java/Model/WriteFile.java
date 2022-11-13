package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author gustavo
 */
public class WriteFile {
    private static WriteFile instance = null;

    public static WriteFile getInstance() {
        if (instance == null) {
            instance = new WriteFile();
        }
        return instance;
    }
    
    public void writeFile(String content) throws IOException {
        JFileChooser chooser = new JFileChooser();
        
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Selecione o destino do arquivo");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
           try {
                File filePath = chooser.getCurrentDirectory();
                File outputFile = chooser.getSelectedFile();
                
                FileWriter file = new FileWriter(filePath);
                file.write(content);
                file.close();
           } catch (IOException error) {
                System.out.println("Ocorreu um erro: " + error);
           }

        } else {
            System.out.println("No Selection ");
        }
    }
}
    