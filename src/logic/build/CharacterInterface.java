/*
 * Descripción: Interfaz del personaje
 * Fecha: 1/10/2019
 * Versión: 1.0
 */

package logic.build;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import logic.products.Body;


/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public interface CharacterInterface {

    public void draw(Graphics g);
    public void calculatePos();
    public void defineBody(Body body);
    public void addrunR(Image i);
    public void addrunL(Image i);
    public void addSkill(Image i);
    public void setX(int x);
    public void setY(int y);
    public void setXp(int xp);
    public void setYp(int yp);
    public Body getBody();
    public int getX();
    public int getY();
    public int getXp();
    public int getYp();
    public void setState(int state);
    public Rectangle getRect();
    public int getState();
    
}
