package hr.mogh.crackingthecodinginterview.ch1;

/**
 * Solves the following problem:
 * <p/>
 * <code>Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degrees. Can you do this in place?</code><br/>
 * <p/>
 * Created by vlado on 14.3.2016.
 */
public class ImageRotator {

    /**
     * Rotates an image 90 degrees in place.<br/>
     * Space complexity: <code>O(n)</code>.<br/>
     * Time complexity: <code>O(n^2)</code>.
     *
     * @param image Image to be rotated
     */
    public static void rotateImage(short[][] image) {
        int rows = image[0].length;
        int columns = image.length;
        for (int i = 0; i < Math.floor(columns / 2.0); i++) {
            for (int j = i; j < rows - i - 1; j++) {
                short tempPixel = image[i][j];
                image[i][j] = image[j][rows - 1 - i];
                image[j][rows - 1 - i] = image[columns - 1 - i][rows - 1 - j];
                image[columns - 1 - i][rows - 1 - j] = image[columns - 1 - j][i];
                image[columns - 1 - j][i] = tempPixel;
            }
        }
    }
}
