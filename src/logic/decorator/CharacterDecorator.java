/*
 * Descripción: Clase principal del patrón decorator
 * Fecha: 16/10/2019
 * Versión: 1.0
 */
package logic.decorator;

import logic.build.CharacterInterface;
import logic.factories.CharacterFac;
import logic.products.Body;
import logic.products.Sprite;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class CharacterDecorator implements CharacterInterface {

    protected CharacterInterface CharIn;

    public CharacterDecorator(CharacterInterface CharIn) {
        this.CharIn = CharIn;
    }
}
