/*
 * Descripción: Personaje
 * Fecha: 22/09/2019
 * Versión: 1.0
 */
package logic.build;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import logic.products.Body;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class CharacterC implements Cloneable, CharacterInterface{

    //Sprites para correr y para la habilidad
    ArrayList<Image> runR = new ArrayList<Image>();
    ArrayList<Image> runL = new ArrayList<Image>();
    ArrayList<Image> skill = new ArrayList<Image>();
    Body body;
    //Estado que determina si esta corriendo para la izquierda, derecha, en habilidad o ninguna
    //0 abajo, 1 corre derecha, 2 habilidad, 3 correr izquierda, 4 quieto
    int state = 0;
    int actualImg;
    Image img;
    int x = 0;
    int y = 0;
    int xp = 0;
    int yp = 0;

    //Metodo que pinta
    public void draw(Graphics g) {
        switch (state) {
            case 0://Abajo
                img = runR.get(actualImg % 3);
                y += 2;
                yp += 2;
                break;
            case 1://Derecha
                img = runR.get(actualImg % runR.size());
                x += 2;
                xp += 2;
                break;
            case 2://Habilidad
                img = skill.get(actualImg % skill.size());
                y -= 2;
                yp -= 2;
                break;
            case 3://Izquierda
                img = runL.get(actualImg % runL.size());
                x -= 2;
                xp -= 2;
                break;
            case 4:
                img = runR.get(0);
        }
        calculatePos();
        if (y < -25) {
            y = 710;
            yp = 700;
        } else if (y > 725) {
            y = -25;
            yp = -15;
        }
        if (xp > 1010) {
            x = -0;
            xp = -75;
        } else if (xp < -185) {
            x = 1070;
            xp = 1000;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, xp, yp, null);
        g.setColor(Color.red);
        g.drawString("Nombre: " + body.getName(), x, y);
        g.drawString("Skill: " + body.getSkillName(), x, y + 15);
        g.drawString("Life: " + body.getDefaultLife(), x, y + 30);
        actualImg++;
    }

    //Clonamiento
    @Override
    public CharacterC clone() {
        CharacterC clonedCharacter = null;
        try {
            clonedCharacter = (CharacterC) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } // catch	
        return clonedCharacter;
    } // method clone

    //Posicion en el tablero
    public void calculatePos() {
        switch (state) {
            case 0://Abajo
                y += 2;
                yp += 2;
                break;
            case 1://Derecha
                x += 2;
                xp += 2;
                break;
            case 2://Habilidad
                y -= 2;
                yp -= 2;
                break;
            case 3://Izquierda
                x -= 2;
                xp -= 2;
                break;
            case 4:
                break;
        }
    }

    //Rectangulo
    public Rectangle getRect(){
        Rectangle rect = null;
        rect = new Rectangle(xp, yp, img.getWidth(null), img.getHeight(null));
        return rect;
    }
    
    public void addrunR(Image i) {
        runR.add(i);
    }

    public void addrunL(Image i) {
        runL.add(i);
    }

    public void addSkill(Image i) {
        skill.add(i);
    }

    public void defineBody(Body body) {
        this.body = body;
    }

    //Getters
    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getYp() {
        return yp;
    }

    public void setYp(int yp) {
        this.yp = yp;
    }

    public ArrayList<Image> getrunR() {
        return runR;
    }

    public ArrayList<Image> getRunL() {
        return runL;
    }

    public ArrayList<Image> getSkill() {
        return skill;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public int getActualImg() {
        return actualImg;
    }

    public void setActualImg(int actualImg) {
        this.actualImg = actualImg;
    }

    public void setRunR(ArrayList<Image> runR) {
        this.runR = runR;
    }

    public void setRunL(ArrayList<Image> runL) {
        this.runL = runL;
    }

    public void setSkill(ArrayList<Image> skill) {
        this.skill = skill;
    }

    public void setBody(Body body) {
        this.body = body;
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

    @Override
    public Body getBody() {
       return body;
    }

}
