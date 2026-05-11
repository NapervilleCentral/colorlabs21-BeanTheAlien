
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import javax.imageio.ImageIO;
import java.io.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.awt.geom.*;
import java.awt.image.*;

public class Post {
    public static final Picture canvas = new Picture("images/canvas.png");
    public static int off = 0;
    public static int row = 0;
    public static ArrayList<Integer> offs = new ArrayList();
    public static void main(String[] args) throws IOException {
        /*Color[] colours = {
            new Color(9, 23, 89),
            new Color(255, 43, 43),
            new Color(156, 208, 240),
            new Color(255, 250, 250)
        };*/
        var al = engi();
        var al1 = engi();
        //var pxs = al.getPixels();
        vertMir(al1);
        //al1.explore();
        var al2 = engi();
        horizMir(al2);
        //al2.explore();
        var al3 = engi();
        for(var x : al3.getPixels()) {
            x.setColor(new Color((int)(x.getRed() / 2.5), Math.min((int)(x.getGreen() * 2.65), 255), (int)(x.getBlue() / 2.5)));
        }
        var a4 = engi();
        epicResize(a4, a4.getWidth() / 2, a4.getHeight() / 2);
        //255, 153, 26
        var a6 = engi();
        for(var x : a6.getPixels()) {
            //New Red = (R * .393) + (G * .769) + (B * .189)New Green = (R * .349) + (G * .686) + (B * .168)New Blue = (R * .272) + (G * .534) + (B * .131)
            int r = x.getRed();
            int g = x.getGreen();
            int b = x.getBlue();
            x.setColor(new Color(
                Math.min((int)(r * 0.393) + (int)(g * 0.769) + (int)(b * 0.189), 255),
                Math.min((int)(r * 0.349) + (int)(g * 0.686) + (int)(b * 0.168), 255),
                Math.min((int)(r * 0.272) + (int)(g * 0.534) + (int)(b * 0.131), 255)
            ));
        }
        var a7 = engi();
        for(var x : a7.getPixels()) {
            float s = 4.5f;
            color(x, red(x) * s, green(x) * s, blue(x) * s);
        }
        var a8 = engi();
        for(var x : a8.getPixels()) {
            color(x, 255 - red(x), 255 - green(x), 255 - blue(x));
        }
        var a9 = engi();
        deepfry(a9.getPixels());
        int a9oy = row + a9.getHeight();
        var a10 = engi();
        for(var x : a10.getPixels()) {
            post(x, 8);
        }
        var a11 = engi();
        for(var x : a11.getPixels()) {
            double a = x.getAverage();
            color(x, a, a, a);
        }
        var a12 = engi();
        vertMir(a12);
        horizMir(a12);
        var a13 = engi();
        minecraft(a13);
        write(al, al1, al2, al3, a4, a6, a7, a8, a9, a10, a11, a12, a13);
        canvas.explore();
    }
    public static void deepfry(Pixel[] pixels) {
        for(var x : pixels) {
            int ro = red(x);
            int go = green(x);
            int bo = blue(x);
            int r1 = 128 + (int)(2.5 * (ro - 128));
            int g1 = 128 + (int)(2.5 * (go - 128));
            int b1 = 128 + (int)(2.5 * (bo - 128));
            int n = 6;
            int r2 = Math.round(r1 / n) * (255 / n);
            int g2 = Math.round(g1 / n) * (255 / n);
            int b2 = Math.round(b1 / n) * (255 / n);
            float m1 = 1.8f;
            float m2 = 0.2f;
            color(x, m1 * r2, m1 * g2, m2 * b2);
        }
    }
    public static Picture alien() {
        return new Picture("images/big_alien.png");
    }
    public static Picture engi() {
        return new Picture("images/engi.png");
    }
    public static void post(Pixel x, int n) {
        int l1 = n - 1;
        int z = 255 / l1;
        Function<Integer, Double> next = (a) -> (((a * l1) / 255) + 0.5) * z;
        color(x, next.apply(red(x)), next.apply(green(x)), next.apply(blue(x)));
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
    public static void cheese(Picture picture) {
        Graphics g = picture.getGraphics();
        g.setFont(new Font("Comic Sans MS", Font.BOLD, picture.getWidth() / 5));
        g.setColor(new Color(255, 255, 0));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("Cheese", (picture.getWidth() - fm.stringWidth("Cheese")) / 2, picture.getHeight());
    }
    public static void stuff(Color[] colours, Picture pic) {
        Pixel[] pxs = pic.getPixels();
        gray(pxs);
        sort(pxs);
        int len = colours.length;
        int group = Math.round(pxs.length / len);
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < group; j++) {
                pxs[j + (group * i)].setColor(colours[i]);
            }
        }
    }
    public static void save(Picture alClone, int i) throws IOException {
        ImageIO.write(alClone.getBufferedImage(), "png", new File(String.format("images/al%d.png", i)));
    }
    public static void write(Picture... pics) {
        for(var x : pics) write(x);
    }
    public static void write(Picture pic) {
        for(int i = 0; i < pic.getWidth(); i++) {
            for(int j = 0; j < pic.getHeight(); j++) {
                canvas.getPixel(i + off, j + row * pic.getHeight()).setColor(pic.getPixel(i, j).getColor());
            }
        }
        off += pic.getWidth();
        offs.add(off);
        if(offs.size() % 4 == 0) {
            off = 0;
            row++;
        }
    }
    // sourceX, sourceY += 2 kleiner
    // sourceX, sourceY += 0.5 grosser
    public static void vertMir(Picture al) {
        int w = al.getWidth();
        int m = w / 2;
        var p = al.getPixels();
        for(int y = 0; y < al.getHeight(); y++) {
            for(int x = 0; x < m; x++) {
                var a = al.getPixel(x, y);
                var b = al.getPixel(w - x - 1, y);
                b.setColor(a.getColor());
            }
        }
    }
    public static void horizMir(Picture al) {
        int w = al.getHeight();
        int m = w / 2;
        var p = al.getPixels();
        for(int y = 0; y < al.getHeight(); y++) {
            for(int x = 0; x < m; x++) {
                var a = al.getPixel(y, x);
                var b = al.getPixel(y, w - x - 1);
                b.setColor(a.getColor());
            }
        }
    }
    private static void resize(Picture al, double s) {
        for(double x = 0, tx = 0; x < al.getWidth(); x += s, tx++) {
            for(double y = 0, ty = 0; y < al.getHeight(); y += s, ty++) {
                var a = al.getPixel((int)x, (int)y);
                var b = al.getPixel((int)tx, (int)ty);
                b.setColor(a.getColor());
            }
        }
    }
    public static void epicResize(Picture al, int sw, int sh) {
        if(sw < 25 || sh < 25) return;
        for(int i = sw; i >= 0; i--) for(int j = 0; j < sh; j++) al.getPixel(i, j).setColor(al.getPixel((int)(i * 1.5), (int)(j * 1.5)).getColor());
        epicResize(al, sw / 2, sh / 2);
    }
    /*
       int subwidth, int subheight
       for(i = subwidth, i >= 0, i--) for(j = 0, j < subheight, j++) get(i*2, j*2)
       recuyrse(i, sw/2, sh/2)
    */
    public static void resizeSmall(Picture al) {
        try { resize(al, 2); } catch(Exception e) {}
    }
    public static void resizeBig(Picture al) {
        try { resize(al, 0.1); } catch(Exception e) {}
    }
    public static Color color(Pixel x) {
        return x.getColor();
    }
    private static int clamp(int in) {
        return Math.max(0, Math.min(in, 255));
    }
    public static void color(Pixel x, Color color) {
        x.setColor(color);
    }
    public static void color(Pixel x, int r, int g, int b) {
        color(x, new Color(clamp(r), clamp(g), clamp(b)));
    }
    public static void color(Pixel x, double r, double g, double b) {
        color(x, (int)r, (int)g, (int)b);
    }
    public static int red(Pixel x) {
        return x.getRed();
    }
    public static void red(Pixel x, int r) {
        color(x, r, green(x), blue(x));
    }
    public static int green(Pixel x) {
        return x.getGreen();
    }
    public static void green(Pixel x, int g) {
        color(x, red(x), g, blue(x));
    }
    public static int blue(Pixel x) {
        return x.getBlue();
    }
    public static void blue(Pixel x, int b) {
        color(x, red(x), green(x), b);
    }
    public static void minecraft(Picture pic) {
        int chunk = 10;
        for(int x = 0; x < pic.getWidth(); x += chunk) {
            for(int y = 0; y < pic.getHeight(); y += chunk) {
                var a = pic.getPixel(x, y).getColor();
                for(int i = 1; i < chunk; i++) {
                    pic.getPixel(x, y + i).setColor(a);
                }
            }
        }
    }
    /**
     * Pixel sourcePix = null
     * Pixel targetPix = null
     * for(int sx = 0, tx = 0; sx < source.getWidth(); sx++, tx++) { for(int sy = 0, ty = 0; sy < source.getHeight(); sy++, ty++) { sourcePix = getPixel(sx, sy); targetPix = getPixel(tx, ty); targetPix.setColor(sourcePix.getColor())
     */
}