
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args) {
        //opens selfie picture
        /*String fileName = FileChooser.pickAFile();
        Picture pictObj = new Picture(fileName);
        pictObj.explore();*/
        //relative path
        //Picture apic = new Picture("images\\beach.jpg");
        //change with selfie picture
        //Picture me = new Picture("images/beach.jpg");
        //Picture me1 = new Picture("images/beach.jpg");
        //Picture me2 = new Picture("images/beach.jpg"); 
        
        // Pixel.getColor(): Color
        // Pixel.getRed(): int
        // Pixel.getGreen(): int
        // Pixel.getBlue(): int
        // Pixel.getAlpha(): int
        // Pixel.getAverage(): double
        // Pixel.setColor(newColor: Color): void
        // Pixel.setRed(int value): void
        // Pixel.setGreen(int value): void
        // Pixel.setBlue(int value): void
        
        // Picture.getPixel(x: int, y: int): Pixel
        // Picture.drawString(text: String, xPos: int, yPos: int): void
        // Picture.getPixels(): Pixel[]
        // Picture.getWidth(): int
        // Picture.getHight(): int
        // Picture.write(String fileName): boolean
        
        Picture dude = new Picture("dude.jpg");
        Pixel[] pxs = dude.getPixels();
        // grayscale
        for(Pixel px : pxs) {
            int avg = (int)px.getAverage();
            px.setColor(new Color(avg, avg, avg));
        }
        // 0 - 255
        // dark blue | red | light blue | off white
        Arrays.sort(pxs, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
        int group = Math.round(pxs.length / 4);
        Color[] colours = {
            new Color(9, 23, 89),
            new Color(255, 43, 43),
            new Color(156, 208, 240),
            new Color(255, 250, 250)
        };
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < group; j++) {
                Color colour = colours[i];
                pxs[j + (group * i)].setColor(colour);
            }
        }
        dude.explore();
        // min - max
        // dark blue | red | light blue | off white
        
        dude.write("images/caterpillar1.jpg");
    }
    public static int sum(Pixel px) { return px.getRed() + px.getBlue() + px.getGreen(); }
}
