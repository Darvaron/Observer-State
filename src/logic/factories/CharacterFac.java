/*
 * Descripción: Interfaz fabrica abstracta
 * Fecha: 21/08/2019
 * Ver: 1.0
 */
package logic.factories;

import logic.products.Body;
import logic.products.Sprite;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public interface CharacterFac {

    public Sprite createSprite();
    public Body createBody();

}
