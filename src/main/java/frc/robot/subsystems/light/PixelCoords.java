package frc.robot.subsystems.light;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

class PixelCoords {
    private static int[][] colors = new int[256][3];

    public static void main(String[] args) throws IOException {
        setPixels(new File("vendordeps\\bitmaps\\debug.bmp"));

        for (int[] vals : colors) {
            System.out.print(String.format(" (r: %s g: %s b: %s)", vals[0], vals[1], vals[2]));
        }

        System.out.println();
    }

    public static void setPixels(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);
        
        for (int row = 0; row < 16; row++) {
            for (int col = 0; col < 16; col++) {
                int color = img.getRGB(col, row);

                int b = color & 0xff;
                int g = (color & 0xff00) >> 8;
                int r = (color & 0xff0000) >> 16;

                if (row % 2 == 0) {
                    colors[row*15 + col] = new int[] {r, g, b};
                } else {
                    colors[row*16 + 15 - col] = new int[] {r, g, b};
                }
            }
        }
    }

    public static int[][] getColors() {
        return colors;
    }
}