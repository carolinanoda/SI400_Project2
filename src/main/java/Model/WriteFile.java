package Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Class responsible for asking the user the location where he wants to save
 * the text file.
 *
 * @author Carolina Noda Morishita
 * @author Gustavo Ramos Romagnolo
 * @author Marcos César Medeiros
 * @author Mariana Pereira Araújo
 * @author Thamires de Melo Prado
 * @version 1.0
 */

public class WriteFile {
    private static WriteFile instance = null;
    
    /**
     * Class constructor.
     * @return WriteFile instance of WriteFile class.
     */
    public static WriteFile getInstance() {
        if (instance == null) {
            instance = new WriteFile();
        }
        return instance;
    }
    
    /**
     * Writes file to disk, given a path and the contents of the file.
     * @param content String text that will be stored inside the file.
     * @param file_name String representing the file name or the path of the file.
     * @throws IOException Exception thrown when there is a problem writing the file.
     */
    public void writeFile(String content, String file_name) throws IOException {
        JFileChooser chooser = new JFileChooser();
        JFrame parentFrame = new JFrame();
        Writer file;

        chooser.setDialogTitle("Selecione o destino do arquivo");
        chooser.setSelectedFile(new File(file_name));

        int userSelection = chooser.showSaveDialog(parentFrame);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File savedFile = chooser.getSelectedFile();
                file = new OutputStreamWriter(new FileOutputStream(savedFile.getAbsolutePath()), StandardCharsets.UTF_8);
                file.write(content);
                file.close();
            } catch (IOException error) {
                System.out.println("Ocorreu um erro ao salvar o arquivo: " + error);
            }
        } else {
            System.out.println("Nenhum diretório selecionado.");
        }
    }
}