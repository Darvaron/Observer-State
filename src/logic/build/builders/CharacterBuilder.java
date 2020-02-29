/*
 * Descripción: Builder Padre
 * Fecha: 22/09/2019
 * Versión: 1.0
 */
package logic.build.builders;

import java.awt.Image;
import java.util.ArrayList;
import logic.build.CharacterC;
import logic.products.Body;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class CharacterBuilder {

    protected CharacterC mainChar;

    public CharacterC getChar() {
        return mainChar;
    }

    public abstract void buildCharacter();
    
    public abstract void buildRunR(ArrayList<Image> img);

    public abstract void buildSkill(ArrayList<Image> img);

    public abstract void buildBody(Body bd);

    public abstract void buildRunL(ArrayList<Image> img);

}
