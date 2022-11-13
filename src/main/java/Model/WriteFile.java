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
        JFrame parentFrame = new JFrame();
        Writer file;

        chooser.setDialogTitle("Selecione o destino do arquivo");

        int userSelection = chooser.showSaveDialog(parentFrame);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File savedFile = chooser.getSelectedFile();
                file = new OutputStreamWriter(new FileOutputStream(savedFile.getAbsolutePath() + ".txt"), StandardCharsets.UTF_8);
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