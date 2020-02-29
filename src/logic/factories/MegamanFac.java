/*
 * Descripción: Fabrica para Megaman
 * Fecha: 21/09/2019
 * Versión: 1.0
 */
package logic.factories;

import logic.products.Body;
import logic.products.MegamanBody;
import logic.products.MegamanSprite;
import logic.products.Sprite;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class MegamanFac implements CharacterFac {

    public Sprite createSprite() {
        return new MegamanSprite();
    }

    public Body createBody() {
        return new MegamanBody();
    }

}
