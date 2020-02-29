/*
 * Descripción: Fabrica para Goku
 * Fecha: 21/09/2019
 * Versión: 1.0
 */
package logic.factories;

import logic.products.Body;
import logic.products.GokuBody;
import logic.products.GokuSprite;
import logic.products.Sprite;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class GokuFac implements CharacterFac{
    
    public Sprite createSprite() {
        return new GokuSprite();
    }

    public Body createBody() {
        return new GokuBody();
    }
}
