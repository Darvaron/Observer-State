/*
 * Descripción: Interfaz de las estrategias de músicas
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.strategy;

import java.applet.AudioClip;
import java.io.FileNotFoundException;
import java.util.Random;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public abstract class StrategyIn {

    public Player[] songs;

    public static void play(Player[] s) throws JavaLayerException {
        for(int i=0; i<2; i++){
            s[i].play();
        }
    }

    public abstract void getSongs() throws FileNotFoundException,JavaLayerException;
}
