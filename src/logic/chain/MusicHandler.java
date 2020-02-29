/*
 * Descripción: Interfaz de manejadores de petición de música
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.chain;

import logic.strategy.StrategyIn;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class MusicHandler {

    MusicHandler succ;

    public abstract StrategyIn StrategyDef(String dec);

    public MusicHandler getSuccessor() {
        return succ;
    }

    public void setSucc(MusicHandler Succ) {
        this.succ = Succ;
    }

}
