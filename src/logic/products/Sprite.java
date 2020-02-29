/*
 * Descripción: Sprite abstracto
 * Fecha: 21/09/2019
 * Versión: 1.0
 */
package logic.products;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class Sprite {

    private ArrayList<Image> images;

    public Sprite() {
    }

    public Sprite(String url, int imgCounter, int imageCounterR) {
        images = new ArrayList<Image>();
        
        //Guarda las imagenes del sprite
        for (int i = 0; i < imgCounter; i++) {
            Image image = new ImageIcon(getClass().getResource("/resources/" + url + i+".png")).getImage();
            images.add(image);
        }
    }

    public ArrayList<Image> getImages() {
        return images;
    }
    
}
