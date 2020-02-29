/*
 * Description: Estado 2 fondo de pantalla
 * Fecha: 29/02/2020
 * Versión: 1.0
 */
package logic.state;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class State2 implements States{

    @Override
    public Image executeAct() {
        Image bb  =new ImageIcon(getClass().getResource(
                "/resources/bgg.jpg")).getImage();
        return bb; 
    }

}
