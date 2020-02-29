/*
 * Description: Estado 1 fondo de pantalla
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
public class State1 implements States{

    @Override
    public Image executeAct() {
        Image bb  =new ImageIcon(getClass().getResource(
                "/resources/bgm.jpg")).getImage();
        return bb; 
    }

}
