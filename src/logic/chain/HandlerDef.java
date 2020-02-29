/*
 * Descripción: Manejador música defecto
 * Versión: 1.0
 */
package logic.chain;

import logic.strategy.StrategyIn;


/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class HandlerDef extends MusicHandler {

    public StrategyIn StrategyDef(String dec) {
        System.out.println("Error, opción no valida");
        return null;
    }
}
