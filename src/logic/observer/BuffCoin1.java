/*
 * Descripción: Subject patron observer
 * Fecha: 25/02/2020
 * Versión: 1.0
 */
package logic.observer;

import logic.products.Body;
import view.CanvasChar;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class BuffCoin1 implements Observer {

    @Override
    public void update() {
        Body newBody;
        //Observa CanvasChar
        //Cambia la vida a favor de los personajes cuando el personaje solitario coge la moneda
        newBody = CanvasChar.charGroup[0].getBody();
        newBody.setDefaultLife(newBody.getDefaultLife() - 500);
        CanvasChar.comp.defineBody(newBody);
        CanvasChar.charGroup[0].defineBody(newBody);       
    }

}
