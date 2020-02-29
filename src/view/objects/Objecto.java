/*
 * Descripción: Clase padre objetos del mapa
 * Fecha: 26/09/2019
 * Versión: 1.0
 */

package view.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import logic.build.CharacterInterface;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class Objecto{
    ArrayList<Image> images= new ArrayList<Image>();
    int x;
    int y;
    int imgN=0;
    Image img;
    String n;
    
    public void drawOb(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        img = images.get(imgN);
        g2d.drawImage(img, x, y, null);
        imgN++;
        imgN%=images.size();
    }
    
    public Objecto(String url, int quantity, String name) {
        for(int i=0;i<quantity;i++){
            Image image = new ImageIcon(getClass().getResource("/resources/" + url + i+".png")).getImage();
            images.add(image);
        }
        n= name;
        setPosition();
    }
    
    public void setPosition(){
        Random rand = new Random();
        int xr = rand.nextInt(950);
        x=xr+1;
        int yr = rand.nextInt(650);
        y=yr+1;
    }
    
    public abstract CharacterInterface doEfect(CharacterInterface c);
    
    public Rectangle getRect(){
        Rectangle rect = null;
        rect = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
        return rect;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getN() {
        return n;
    }
}
