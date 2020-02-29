/*
 * Descripción: Canvas donde se mostrarán los personajes
 * Fecha: 22/09/2019
 * Versión: 1.0
 */
package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javazoom.jl.decoder.JavaLayerException;
import logic.build.CharacterC;
import logic.build.CharacterInterface;
import logic.chain.HandlerDef;
import logic.chain.HandlerHouse;
import logic.chain.HandlerMetal;
import logic.chain.HandlerRetro;
import logic.chain.MusicHandler;
import logic.composite.Composite;
import logic.decorator.CharBack;
import logic.observer.BuffCoin1;
import logic.observer.Observer;
import logic.observer.Subject;
import logic.products.Body;
import logic.prototype.fabric.CharacterCreator;
import logic.strategy.StrategyIn;
import view.objects.Coin;
import view.objects.Mushroom;
import view.objects.Objecto;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class CanvasChar extends Canvas implements KeyListener, Subject {

    public int op = 0;

    //Observer
    public static List<Observer> listObs = new ArrayList<Observer>();

    Thread musicSelection;
    static MusicHandler[] handlers;
    StrategyIn strategyC;

    Thread drawChar;
    Thread drawChar2;
    Thread drawChar3;

    public static Image imgBuffer;
    Graphics G;

    Image imgAct;
    Image imgAct2;
    Image imgAct3;

    backGround bg;

    CharacterCreator character1;
    public static CharacterInterface[] charGroup = new CharacterInterface[3];
    ArrayList<Objecto> objects = new ArrayList<Objecto>();

    //Composite
    public static Composite comp = new Composite();

    public CanvasChar(String dcs, String ms) throws FileNotFoundException, JavaLayerException {
        //Crea creator
        character1 = new CharacterCreator();
        setFocusable(true);
        setBounds(0, 0, 1000, 700);
        //Valores para posiciónes iniciales personajes
        int[] x = {170, 450, 450};
        int[] y = {150, 100, 200};
        int[] xp = {100, 370, 370};
        int[] yp = {140, 90, 190};
        //Arreglo de personajes para inicializar posiciones
        for (int i = 0; i < 3; i++) {
            charGroup[i] = character1.retrieveCharacter(dcs);
            charGroup[i].setX(x[i]);
            charGroup[i].setY(y[i]);
            charGroup[i].setXp(xp[i]);
            charGroup[i].setYp(yp[i]);
        }
        //Añade personajes al composite
        comp.add(charGroup[1]);
        comp.add(charGroup[2]);
        bg = new backGround();
        //Música
        handlers = new MusicHandler[4];

        handlers[3] = new HandlerDef();
        handlers[2] = new HandlerMetal();
        handlers[1] = new HandlerHouse();
        handlers[0] = new HandlerRetro();

        handlers[0].setSucc(handlers[1]);
        handlers[1].setSucc(handlers[2]);
        handlers[2].setSucc(handlers[3]);

        //for (int i = 0; i < handlers.length - 1; i++) {
        //    handlers[i].setSucc(handlers[i + 1]);
        //}
        strategyC = handlers[0].StrategyDef(ms);

        musicSelection = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    strategyC.getSongs();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CanvasChar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(CanvasChar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        musicSelection.start();

        //Observer
        BuffCoin1 buff1 = new BuffCoin1();
        CanvasChar.listObs.add(buff1);

        //Arreglo de objetos
        fillObjects();
        //Pinta
        drawChar = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        repaint();
                        drawChar.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (java.lang.ClassCastException e) {
                    }
                }
            }
        });
    }

    public void startPainting() {
        drawChar.setPriority(7);
        drawChar.start();
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        imgBuffer = new BufferedImage(1000, 700, BufferedImage.OPAQUE);
        G = imgBuffer.getGraphics();
        bg.draw(G);
        drawOb(G);
        charGroup[0].draw(G);
        comp.draw(G);
        g.drawImage(imgBuffer, 0, 0, null);
        verify();
    }

    //Verifica si esta encima de un objeto
    public void verify() {
        ArrayList<CharacterInterface> comparts = comp.getParts();
        for (int i = 0; i < objects.size(); i++) {
            Objecto c = null;
            c = objects.get(i);

            //Personaje independiente
            if (c.getRect().intersects(charGroup[0].getRect())) {
                if (i < 6) {
                    charGroup[0] = c.doEfect(charGroup[0]);
                }
                objects.remove(i);
                //Notifica a observadores
                notifyObservers();
                if (c.getN().equals("mush")) { //Aplicación del state
                    if (op % 2 == 0) {
                        bg.Modificada();
                    } else {
                        bg.Normal();
                    }
                    op += 1;
                }

            }
            //Composite
            //Obtiene los personajes del composite
            for (int j = 0; j < comparts.size(); j++) {
                CharacterInterface part = comparts.get(j);
                Rectangle rec = part.getRect();
                if (c.getRect().intersects(rec)) {
                    //si algún personaje toca una moneda le aplica la decoración
                    part = c.doEfect(part);
                    comparts.set(j, part);
                    objects.remove(i);
                    //Notifica a observadores
                    notifyObservers();
                    if (c.getN().equals("mush")) { //Aplicación del state
                        if (op % 2 == 0) {
                            bg.Modificada();
                        } else {
                            bg.Normal();
                        }
                        op += 1;
                    }
                }
            }

        }
        comp.setParts(comparts);

        fillObjects();
    }

//Si falta objetos los añade
    public void fillObjects() {
        while (objects.size() < 6) {
            objects.add(new Coin());
        }
        if (objects.size() == 6) {
            objects.add(6, new Mushroom());
            objects.set(5, new Coin());
        }
    }

    //Pinta los objetos
    public void drawOb(Graphics g) {
        for (int i = 0; i < 6; i++) {
            Objecto ob = objects.get(i);
            ob.drawOb(g);
        }
        Mushroom ms = (Mushroom) objects.get(6);
        ms.drawOb(g);
    }

    //Eventos
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            //Personaje 1
            case 37:
                charGroup[0].setState(3);
                break;
            case 38:
                charGroup[0].setState(2);

                break;
            case 39:
                charGroup[0].setState(1);

                break;
            case 40:
                charGroup[0].setState(0);

                break;
            //Personaje 2 y 3 por medio de composite
            case 65:
                comp.setState(3);
                break;
            case 68:
                comp.setState(1);
                break;
            case 87:
                comp.setState(2);
                break;
            case 83:
                comp.setState(0);
                break;
        }
    }

    @Override
    public void attach(Observer obs) {
        listObs.add(obs);
    }

    @Override
    public void dettach(Observer obs) {
        listObs.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < listObs.size(); i++) {
            listObs.get(i).update();
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
