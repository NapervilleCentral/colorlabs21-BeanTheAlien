
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
        
        Picture bug = img("caterpillar");
        
        // bug.getPixel(5, 0).setColor(new Color(255, 0, 0));
        // setAt(bug, 5, 0, new Color(255, 0, 0));
        
        Pixel[] pxs = bug.getPixels();
        
        // pxs[0].setColor(new Color(1, 2, 3));
        
        int i = 0;
        for(Pixel px : pxs) {
            if(i % 2 == 0) {
                px.setRed(ran(px.getRed()));
                px.setBlue(ran(px.getBlue()));
                px.setGreen(ran(px.getGreen()));
            }
            i++;
        }
        
        bug.explore();
    }
    public static double avg(Pixel px) {
        return px.getAverage();
    }
    public static Picture img(String name) {
        return new Picture(String.format("images/%s.jpg", name));
    }
    public static int ran(int max) { return (int)(Math.random() * max); }
    public static Color ranRGB() { return new Color(ran(255), ran(255), ran(255)); }
}
