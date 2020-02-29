/*
 * Descripción: Cuerpo abstracto
 * Fecha: 21/09/2019
 * Versión: 1.0
 */
package logic.products;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class Body {

    String name;
    String skillName;
    int defaultLife;
    
    public Body() {
    }

    public Body(String name, String skillName, int defaultLife) {
        this.name = name;
        this.skillName = skillName;
        this.defaultLife = defaultLife;
    }

    public String getName() {
        return name;
    }
    
    public String getSkillName() {
        return skillName;
    }

    public int getDefaultLife() {
        return defaultLife;
    }

    public void setDefaultLife(int defaultLife) {
        this.defaultLife = defaultLife;
    }
    
}
