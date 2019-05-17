import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Roberto Maillard
 * Read, display and write/save an image.
 */

public class Image {

    private File file;

    public Image(File file){
        // Constructor provides filepath and key
        this.file = file;
    }

    public BufferedImage readImage() {
        // Read in image from file
        BufferedImage bufferedImage = null;
        try
        {
            bufferedImage = ImageIO.read(this.file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    public void displayImage(BufferedImage image) {
        // Display image from file
        JLabel picLabel = new JLabel(new ImageIcon(image));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);

        JFrame f = new JFrame();
        f.setSize(new Dimension(image.getWidth(),image.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }

    public void writeImage(BufferedImage image,String filename){
        // Write/save PNG image to file
        try {
            File file = new File(filename);
            ImageIO.write(image,"png",file);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}