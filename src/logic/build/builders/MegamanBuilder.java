/*
 * Descripción: Se contruye a Megaman
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
public class MegamanBuilder extends CharacterBuilder {
  
    public void buildCharacter() {
        mainChar = new logic.build.CharacterC();
    }

    public void buildRunR(ArrayList<Image> img) {
        for (int i = 0; i <= 9; i++) {
            mainChar.addrunR(img.get(i));
        }
    }

    public void buildRunL(ArrayList<Image> img) {
        for (int i = 15; i < 24; i++) {
            mainChar.addrunL(img.get(i));
        }
    }

    @Override
    public void buildSkill(ArrayList<Image> img) {
        for (int i = 10; i < 15; i++) {
            mainChar.addSkill(img.get(i));
        }
    }

    @Override
    public void buildBody(Body bd) {
        mainChar.defineBody(bd);
    }

}
