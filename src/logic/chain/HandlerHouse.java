/*
 * Descripción: Manejador música house 
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.chain;

import logic.strategy.StrategyHouse;
import logic.strategy.StrategyIn;
import logic.strategy.StrategyRetro;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class HandlerHouse extends MusicHandler {

    public StrategyIn StrategyDef(String dec) {
        if (dec.equals("House")) {
            StrategyIn st;
            st = new StrategyHouse();
            return st;
        } else {
            return succ.StrategyDef(dec);
        }
    }
}
