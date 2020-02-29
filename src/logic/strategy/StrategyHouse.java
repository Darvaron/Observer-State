/*
 * Descripción: Estrategia música house
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.strategy;

import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author David Armando Rodríguez Varón, Juán Sebastián Sánchez Tabares
 */
public class StrategyHouse extends StrategyIn {

    @Override
    public void getSongs() throws FileNotFoundException, JavaLayerException {
        /*songs = new AudioClip[3];
        for (int i = 0; i < 3; i++) {
            songs[i] = java.applet.Applet.newAudioClip(getClass().getResource("/resources/music/house" + i + ".wav"));
        }
        play(songs);*/
        songs = new Player[3];
        for (int i = 0; i < 3; i++) {
            songs[i] = new Player(new FileInputStream("src/resources/music/house"+i+".mp3"));  
        }
        play(songs);
    }

}
