/*
 * Descripción: Fondo
 * Fecha: 24/09/2019
 * Versión: 1.0
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import logic.state.State1;
import logic.state.State2;
import logic.state.States;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class backGround {

    Image img;
    States backState;

    public void Normal() {
        backState = new State1();
    }

    public void Modificada() {
        backState = new State2();
    }

    public backGround() {
        Normal();
    }

    public void draw(Graphics g) {
        img = backState.executeAct();
        g.drawImage(img, 0, 0, null);
    }
}
