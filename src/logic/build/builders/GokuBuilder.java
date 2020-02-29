/*
 * Descripción: Se contruye a Goku
 * Fecha: 22/09/2019
 * Versión: 1.0
 */
package logic.build.builders;

import java.awt.Image;
import java.util.ArrayList;
import logic.products.Body;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class GokuBuilder extends CharacterBuilder {

    public void buildCharacter() {
        mainChar = new logic.build.CharacterC();
    }

    public void buildRunR(ArrayList<Image> img) {
        for (int i = 0; i <= 20; i++) {
            mainChar.addrunR(img.get(i));
        }
    }

    public void buildRunL(ArrayList<Image> img) {
        for (int i = 83; i < 104; i++) {
            mainChar.addrunL(img.get(i));
        }
    }

    public void buildSkill(ArrayList<Image> img) {
        for (int i = 21; i < 83; i++) {
            mainChar.addSkill(img.get(i));
        }
    }

    public void buildBody(Body bd) {
        mainChar.defineBody(bd);
    }

}
