/*
 * Descripción: Clase principal del patrón composite
 * Fecha: 27/10/2019
 * Versión: 1.0
 */
package logic.composite;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import logic.build.CharacterInterface;
import logic.products.Body;
import java.util.Iterator;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class Composite implements CharacterInterface {

    ArrayList<CharacterInterface> group = new ArrayList<CharacterInterface>();

    public void add(CharacterInterface c){
        group.add(c);
    }
    
    @Override
    public void draw(Graphics g) {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.draw(g);
        }
    }

    @Override
    public void calculatePos() {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.calculatePos();
        }
    }

    @Override
    public void defineBody(Body body) {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.defineBody(body);
        }
    }

    @Override
    public void addrunR(Image i) {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.addrunR(i);
        }
    }

    @Override
    public void addrunL(Image i) {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.addrunL(i);
        }
    }

    @Override
    public void addSkill(Image i) {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.addSkill(i);
        }
    }

    @Override
    public void setX(int x) {
        for (Iterator<CharacterInterface> it = group.iterator(); it.hasNext();) {
            CharacterInterface ch = it.next();
            ch.setX(x);
        }
    }

    @Override
    public void setY(int y) {
        int s=0;
        for(Iterator<CharacterInterface> it= group.iterator(); it.hasNext();){
            CharacterInterface ch = it.next();
            ch.setY(y+s);
            s+=100;
        } 
    }

    @Override
    public void setXp(int xp) {
        for(Iterator<CharacterInterface> it= group.iterator(); it.hasNext();){
            CharacterInterface ch = it.next();
            ch.setXp(xp);
        } 
    }

    @Override
    public void setYp(int yp) {
        int s=0;
        for(Iterator<CharacterInterface> it= group.iterator(); it.hasNext();){
            CharacterInterface ch = it.next();
            ch.setYp(yp+s);
            s+=100;
        } 
    }
    
    //Retorna todos los personajes
    public ArrayList<CharacterInterface> getParts(){
        return group;
    }
    //Para modificar con decorator los personajes
    public void setParts(ArrayList<CharacterInterface> group){
        this.group=group;
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getXp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getYp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setState(int state) {
        for(Iterator<CharacterInterface> it= group.iterator(); it.hasNext();){
            CharacterInterface ch = it.next();
            ch.setState(state);
        } 
    }

    @Override
    public Rectangle getRect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Body getBody() {
        return group.get(0).getBody();
    }

}
