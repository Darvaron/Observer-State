/*
 * Descripción: Manejador música retro
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.chain;

import logic.strategy.StrategyIn;
import logic.strategy.StrategyRetro;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class HandlerRetro extends MusicHandler {

    @Override
    public StrategyIn StrategyDef(String dec) {
        if (dec.equals("Retro")) {
            StrategyIn st;
            st = new StrategyRetro();
            return st;
        } else {
            if(succ==null) System.out.println("mal");
            return succ.StrategyDef(dec);
        }
    }

}
