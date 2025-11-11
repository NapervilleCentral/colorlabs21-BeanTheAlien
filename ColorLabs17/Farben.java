
/**
 * Write a description of class Farben here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
public class Farben
{
    public static Random ran = new Random();
    public static void main(String[] args) {
        Picture bug = new Picture("images/caterpillar.jpg");
        Picture bug1 = new Picture("images/caterpillar.jpg");
        Picture bug2 = new Picture("images/caterpillar.jpg");
        Picture bug3 = new Picture("images/caterpillar.jpg");
        Picture bug4 = new Picture("images/caterpillar.jpg");
        Picture bug5 = new Picture("images/caterpillar.jpg");
        Picture bug6 = new Picture("images/caterpillar.jpg");
        bug.explore();
        Pixel[] pxs = bug.getPixels();
        for(Pixel px : pxs) {
            px.setRed(mult(px.getRed(), 0.5));
            px.setGreen(mult(px.getGreen(), 1.5));
            px.setBlue(mult(px.getBlue(), 0.25));
        }
        bug.explore();
        
        Pixel[] pxs1 = bug1.getPixels();
        for(Pixel px : pxs1) {
            px.setRed(neg(px.getRed()));
            px.setGreen(neg(px.getGreen()));
            px.setBlue(neg(px.getBlue()));
        }
        bug1.explore();
        
        Pixel[] pxs2 = bug2.getPixels();
        for(Pixel px : pxs2) {
            int avg = (int)(px.getAverage());
            px.setColor(new Color(avg, avg, avg));
        }
        bug2.explore();
        
        Pixel[] pxs3 = bug3.getPixels();
        for(Pixel px : pxs3) {
            px.setRed(light(px.getRed()));
            px.setGreen(light(px.getGreen()));
            px.setBlue(light(px.getBlue()));
        }
        bug3.explore();
        
        Pixel[] pxs4 = bug4.getPixels();
        for(Pixel px : pxs4) {
            px.setRed(dark(px.getRed()));
            px.setGreen(dark(px.getGreen()));
            px.setBlue(dark(px.getBlue()));
        }
        bug4.explore();
        
        Pixel[] pxs5 = bug5.getPixels();
        for(Pixel px : pxs5) {
            px.setRed(nextColour(px.getRed(), 50));
            px.setGreen(nextColour(px.getGreen(), -30));
            px.setBlue(nextColour(px.getBlue(), 2));
        }
        bug5.explore();
        
        Pixel[] pxs6 = bug6.getPixels();
        Color leaf = new Color(1, 255, 0);
        for(Pixel px : pxs6) {
            if(inRange(px, leaf)) px.setColor(new Color(25, 30, 189));
        }
        bug6.explore();
    }
    public static int mult(int val, double f) { return (int)(val * f); }
    public static int neg(int v) { return 255 - v; }
    public static int light(int v) { return (int)(v * 3); }
    public static int dark(int v) { return (int)(v / 3); }
    public static int nextColour(int v, int b) { return Math.min(255, v + b); }
    public static boolean inRange(Pixel px, Color colour) {
        boolean r = colour.getRed() - 20 <= px.getRed() && px.getRed() <= colour.getRed() + 20;
        boolean g = colour.getGreen() - 20 <= px.getGreen() && px.getGreen() <= colour.getGreen() + 20;
        boolean b = colour.getBlue() - 20 <= px.getBlue() && px.getBlue() <= colour.getBlue() + 20;
        return r && g && b;
    }
}
