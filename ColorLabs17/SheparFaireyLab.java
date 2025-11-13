
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
    public static void main(String[] args) {
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
        Color[] colours = {
            new Color(9, 23, 89),
            new Color(255, 43, 43),
            new Color(156, 208, 240),
            new Color(255, 250, 250)
        };
        
        Picture dude = new Picture("dude.jpg");
        Pixel[] pxs = dude.getPixels();
        // grayscale
        gray(pxs);
        // 0 - 255
        // dark blue | red | light blue | off white
        sort(pxs);
        int group = Math.round(pxs.length / 4);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < group; j++) {
                pxs[j + (group * i)].setColor(colours[i]);
            }
        }
        //dude.explore();
        
        // min - max
        // dark blue | red | light blue | off white
        Picture dude1 = new Picture("dude.jpg");
        Pixel[] pxs1 = dude1.getPixels();
        gray(pxs1);
        sort(pxs1);
        int s = sum(pxs1[0]);
        int b = sum(pxs1[pxs1.length - 1]);
        int group1 = (b - s) / 4;
        for(Pixel px : pxs1) {
            int brightness = sum(px);
            int grp = groupOf(brightness, s, group1);
            px.setColor(colours[grp]);
        }
        //dude1.explore();
        
        Color[] colours2 = {
            new Color(51, 138, 46),
            new Color(42, 79, 110),
            new Color(170, 122, 57),
            new Color(168, 56, 59)
        };
        Picture dude2 = new Picture("dude.jpg");
        Pixel[] pxs2 = dude2.getPixels();
        gray(pxs2);
        sort(pxs2);
        int group2 = Math.round(pxs2.length / 4);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < group2; j++) {
                pxs2[j + (group2 * i)].setColor(colours2[i]);
            }
        }
        Graphics g = dude2.getGraphics();
        g.setFont(new Font("Comic Sans MS", Font.BOLD, dude2.getWidth() / 5));
        g.setColor(new Color(255, 255, 0));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("Cheese", (dude.getWidth() - fm.stringWidth("Cheese")) / 2, dude.getHeight());
        dude2.explore();
        
        //dude.write("dude1.jpg");
        //dude1.write("dude2.jpg");
        dude2.write("dude3.jpg");
    }
    public static int sum(Pixel px) { return px.getRed() + px.getBlue() + px.getGreen(); }
    public static void gray(Pixel[] pxs) {
        for(Pixel px : pxs) {
            int avg = (int)px.getAverage();
            px.setColor(new Color(avg, avg, avg));
        }
    }
    public static int groupOf(int v, int s, int i) {
        if(v < s + i) return 0;
        if(v < s + 2 * i) return 1;
        if(v < s + 3 * i) return 2;
        return 3;
    }
    public static void sort(Pixel[] pxs) {
        Arrays.sort(pxs, (p1, p2) -> Integer.compare(sum(p1), sum(p2)));
    }
}
