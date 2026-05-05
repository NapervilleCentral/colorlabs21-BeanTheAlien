
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

public class Post {
    public static final Picture canvas = new Picture("images/canvas.png");
    public static int off = 0;
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
            x.setColor(new Color(x.getRed(), Math.min((int)(x.getGreen() * 4.5), 255), x.getBlue()));
        }
        var a4 = engi();
        resizeSmall(a4);
        var a5 = engi();
        resizeBig(a5);
        //255, 153, 26
        var a6 = engi();
        for(var x : a6.getPixels()) {
            x.setColor(new Color(255, Math.min(x.getGreen(), 153), Math.min(x.getBlue(), 26)));
        }
        write(al, al1, al2, al3, a4, a5, a6);
        canvas.explore();
        /*var x = new Picture("images/temple.jpg");
        x.explore();
        // 30-92
        int w = x.getWidth();
        int m = w / 2;
        var p = x.getPixels();
        for(int y = 30; y <= 92; y++) {
            for(int z = 0; z < m; z++) {
                var a = x.getPixel(z, y);
                var b = x.getPixel(w - z - 1, y);
                b.setColor(a.getColor());
            }
        }
        x.explore();*/
        //
        // mirror::vert(middle)
        // grayscale
        //gray(pxs);
        // 0 - 255
        // dark blue | red | light blue | off white
        //sort(pxs);
        /*int group = Math.round(pxs.length / 4);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < group; j++) {
                pxs[j + (group * i)].setColor(colours[i]);
            }
        }*/
        //dude.explore();
        
        // min - max
        // dark blue | red | light blue | off white
        /*Picture dude1 = new Picture("dude.jpg");
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
        dude1.explore();
        
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
        cheese(dude2);
        dude2.explore();
        
        Picture dude3 = new Picture("dude.jpg");
        stuff(new Color[] { new Color(39, 86, 107), new Color(10, 152, 98), new Color(20, 139, 116), new Color(37, 110, 94) }, dude3);
        cheese(dude3);
        dude3.explore();
        
        Picture dude4 = new Picture("dude.jpg");
        stuff(new Color[] { new Color(232, 49, 14), new Color(189, 51, 26), new Color(201, 83, 60), new Color(181, 39, 11) }, dude4);
        cheese(dude4);
        dude4.explore();
        
        save(al, 1);
        save(dude1, 2);
        save(dude2, 3);
        save(dude3, 4);
        save(dude4, 5);*/
    }
    public static Picture alien() {
        return new Picture("images/big_alien.png");
    }
    public static Picture engi() {
        return new Picture("images/engieer.png");
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
                canvas.getPixel(i + off, j).setColor(pic.getPixel(i, j).getColor());
            }
        }
        off += pic.getWidth();
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
    public static void resizeSmall(Picture al) {
        try { resize(al, 2); } catch(Exception e) {}
    }
    public static void resizeBig(Picture al) {
        try { resize(al, 0.5); } catch(Exception e) {}
    }
    /**
     * Pixel sourcePix = null
     * Pixel targetPix = null
     * for(int sx = 0, tx = 0; sx < source.getWidth(); sx++, tx++) { for(int sy = 0, ty = 0; sy < source.getHeight(); sy++, ty++) { sourcePix = getPixel(sx, sy); targetPix = getPixel(tx, ty); targetPix.setColor(sourcePix.getColor())
     */
}