/*
 * Descripción: Manejador música metal
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.chain;

import logic.strategy.StrategyHouse;
import logic.strategy.StrategyIn;
import logic.strategy.StrategyMetal;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class HandlerMetal extends MusicHandler {

    public StrategyIn StrategyDef(String dec) {
        if (dec.equals("Metal")) {
            StrategyIn st;
            st = new StrategyMetal();
            return st;
        } else {
            return succ.StrategyDef(dec);
        }
    }
}