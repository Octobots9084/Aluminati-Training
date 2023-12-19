import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

class PixelCoords {
    private static int[][] red = new int[16][16];
    private static int[][] green = new int[16][16];
    private static int[][] blue = new int[16][16];

    public static void main(String[] args) {
        //setPixels();

        for (int[] row : red) {
            for (int val : row) {
                System.out.print(" " + val);
            }

            System.out.println();
        }
    }

    public static void setPixels(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);
        
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 16; col++) {
                int color = img.getRGB(row, col);

                int b = color & 0xff;
                int g = (color & 0xff00) >> 8;
                int r = (color & 0xff0000) >> 16;

                if (row % 2 == 0) {
                    red[row][col] = r;
                    green[row][col] = g;
                    blue[row][col] = b;
                } else {
                    red[row][15 - col] = r;
                    green[row][15 - col] = g;
                    blue[row][15 - col] = b;
                }
            }
        }
    }

    public static int[][] getRedChannel() {
        return red;
    }

    public static int[][] getGreenChannel() {
        return green;
    }

    public static int[][] getBlueChannel() {
        return blue;
    }
}