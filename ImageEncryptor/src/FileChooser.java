import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * @author Roberto Maillard
 * Show file open dialog and choose your image files.
 */

public class FileChooser {
    private File[] file;

    public FileChooser(){
        JFileChooser jFileChooser = new JFileChooser();
        // Select multiple files
        jFileChooser.setMultiSelectionEnabled(true);
        // Select image files
        FileNameExtensionFilter filter =
                new FileNameExtensionFilter("Images","png","jpg","jpeg","bmp","gif","tif","tiff");
        jFileChooser.setFileFilter(filter);
        jFileChooser.setFileHidingEnabled(false);
        // Show file open dialog
        int result = jFileChooser.showOpenDialog(new JFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            // File array gets selected files
            this.file = jFileChooser.getSelectedFiles();
        }
    }

    public File[] getFiles() {
        return this.file;
    }
}
