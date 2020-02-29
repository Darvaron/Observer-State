/*
 * Descripción: Invierte el movimiento del personaje y le imprime fuego atrás
 * Fecha: 27/10/2019
 * Versión: 1.0
 */
package logic.decorator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import logic.build.CharacterInterface;
import logic.products.Body;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class CharBack extends CharacterDecorator {

    private int imgFire = 1;
    private ArrayList<Image> images;

    public CharBack(CharacterInterface CharIn) {
        super(CharIn);
        //Carga las imagenes del fuego
        images = new ArrayList<Image>();
        String url = "0";
        for (int i = 1; i < 34; i++) {
            Image image = new ImageIcon(getClass().getResource("/resources/fire_" + url + i + ".png")).getImage();
            images.add(image);
            //Para que cuadren los nombres
            if (i == 9) {
                url = "";
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        //Pinta fuego
        Image imgFr = images.get(imgFire);
        Graphics2D g2d = (Graphics2D) g;
        int Ypos = CharIn.getYp()-25;
        //Para mejor impresion
        if(imgFire>10 && imgFire<18){
            Ypos-=30;
        }
        if(imgFire>18){
            Ypos-=30;
        }
        if(imgFire>26){
            Ypos-=10;
        }
        g2d.drawImage(imgFr, CharIn.getXp() - 20, Ypos, null);
        imgFire %= 32;
        imgFire++;
        //Pinta personaje
        CharIn.draw(g);
        calculatePos();
    }

    @Override
    public void calculatePos() {
        int y = CharIn.getY();
        int yp = CharIn.getYp();
        int x = CharIn.getX();
        int xp = CharIn.getXp();
        switch (CharIn.getState()) {
            case 0://Abajo
                CharIn.setY(y - 8);
                CharIn.setYp(yp - 8);
                break;
            case 1://Derecha
                CharIn.setX(x - 8);
                CharIn.setXp(xp - 8);
                break;
            case 2://Habilidad
                CharIn.setY(y + 8);
                CharIn.setYp(yp + 8);
                break;
            case 3://Izquierda
                CharIn.setX(x + 8);
                CharIn.setXp(xp + 8);
                break;
            case 4:
                break;
        }
    }

    @Override
    public void defineBody(Body body) {
        CharIn.defineBody(body);
    }

    @Override
    public void addrunR(Image i) {
        CharIn.addrunR(i);
    }

    @Override
    public void addrunL(Image i) {
        CharIn.addrunL(i);
    }

    @Override
    public void addSkill(Image i) {
        CharIn.addSkill(i);
    }

    @Override
    public void setX(int x) {
        CharIn.setX(x);
    }

    @Override
    public void setY(int y) {
        CharIn.setY(y);
    }

    @Override
    public void setXp(int xp) {
        CharIn.setXp(xp);
    }

    @Override
    public void setYp(int yp) {
        CharIn.setYp(yp);
    }

    @Override
    public void setState(int state) {
        CharIn.setState(state);
    }

    @Override
    public Rectangle getRect() {
        return CharIn.getRect();
    }

    @Override
    public int getX() {
        return CharIn.getX();
    }

    @Override
    public int getY() {
        return CharIn.getY();
    }

    @Override
    public int getXp() {
        return CharIn.getXp();
    }

    @Override
    public int getYp() {
        return CharIn.getYp();
    }

    @Override
    public int getState() {
        return CharIn.getState();
    }

    @Override
    public Body getBody() {
        return CharIn.getBody();
    }

}
