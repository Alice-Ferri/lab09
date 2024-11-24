package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;
/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";

    private File f = new File(PATH);
    /**
     * @param f to set for the file
     */
    public void setFile(final File f) {
        this.f = f;
    }

    /**
     * @return file that is set to write
     */
    public File getFile() {
        return this.f;
    }

    /**
     * @return String Path's file 
     */
    public String getPath() {
        return this.f.getAbsolutePath();
    }

    /**
     * @param stringToSave in the file
     * @throws IOException
     */
    public void newContent(final String stringToSave) throws IOException {
        try (PrintStream ps = new PrintStream(f, StandardCharsets.UTF_8.name())) {
            ps.print(stringToSave);
        } catch (final IOException e1) {
            JOptionPane.showMessageDialog(null, "Errore nella scrittura:" + e1.getMessage());
        }
    }
}
