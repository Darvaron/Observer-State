/*
 * Descripción: Director del builder
 * Fecha: 22/09/2019
 * Versión: 1.0
 */
package logic.build;

import java.awt.Image;
import java.util.ArrayList;
import logic.build.builders.CharacterBuilder;
import logic.products.Body;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class CharacterDir {

    private CharacterBuilder constructor;

    public void setConstructor(CharacterBuilder constructor) {
        this.constructor = constructor;
    }

    public CharacterC getCharacter() {
        return constructor.getChar();
    }

    public void buildChar(ArrayList<Image> img, Body bd) {
        constructor.buildCharacter();
        constructor.buildBody(bd);
        constructor.buildRunR(img);
        constructor.buildRunL(img);
        constructor.buildSkill(img);
    }
}
