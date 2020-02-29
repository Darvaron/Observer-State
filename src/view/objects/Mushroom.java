/*
 * Descripción: Clase hongo
 * Fecha: 26/2/2020
 * Versión: 1.0
 */
package view.objects;

import logic.build.CharacterInterface;
import logic.decorator.CharBack;

/**
 *
 * @author David Armando Rodríguez Varón
 */
public class Mushroom extends Objecto{

    public Mushroom() {
        super("mushroom", 2,"mush");
    }

    @Override
    public CharacterInterface doEfect(CharacterInterface charIn) {
        CharacterInterface back = new CharBack(charIn);
        return back;
    }
    
}
