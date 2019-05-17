import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Roberto Maillard
 * Encrypt and decrypt an image with a bitwise XOR one-time pad encryption using Random with a seed.
 */

public class PixelEncrypt {

    private Random random;

    public PixelEncrypt(long key) {
        // Constructor
        this.random = new Random(key);
    }

    public BufferedImage encryptImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        // Create a buffered image.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Iterate through every pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color c = new Color(image.getRGB(x, y));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                // Encrypt pixel
                int[] rgb = pixelEncrypt(red, green, blue);
                // Set pixel
                bufferedImage.setRGB(x, y, new Color(rgb[0], rgb[1], rgb[2]).getRGB());
            }
        }
        return bufferedImage;
    }

    private int[] pixelEncrypt(int red, int green, int blue){
        // Bitwise XOR encryption on each RGB color pixel
        int randomValue = this.random.nextInt(255);
        red = red^randomValue;

        randomValue = this.random.nextInt(255);
        green = green^randomValue;

        randomValue = this.random.nextInt(255);
        blue = blue^randomValue;

        // Returns an int array with the encrypted RGB colors
        return new int[]{red,green,blue};
    }
}
