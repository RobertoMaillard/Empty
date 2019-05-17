import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

/**
 * @author Roberto Maillard
 * Main class executes encryption/decryption.
 */

public class Main {
    public static void main(String[] args) {
        // Choose your image files
        FileChooser fileChooser = new FileChooser();
        // Type a encryption/decryption key
        Scanner scan = new Scanner(System.in);
        System.out.println("Type in your integer encryption key:");
        long key = scan.nextLong();
        scan.close();
        // Iterate through the image file array
        for (File file : fileChooser.getFiles()){
            // Read in image file
            Image image = new Image(file);
            BufferedImage bufferedImage = image.readImage();
            // Encrypt/decrypt each pixel in image
            PixelEncrypt pixelEncrypt = new PixelEncrypt(key);
            BufferedImage encryptImage = pixelEncrypt.encryptImage(bufferedImage);
            // Display encrypted/decrypted image(s)
            image.displayImage(encryptImage);
            // Write/save encrypted/decrypted image(s) adding "XOR.png" to filename
            String filePathIn = file.getAbsolutePath();
            String filePathOut = filePathIn.substring(0,filePathIn.length()-4) + "XOR.png";
            image.writeImage(encryptImage,filePathOut);
        }
        System.out.println("Your image(s) are now encrypted/decrypted.");
    }
}
