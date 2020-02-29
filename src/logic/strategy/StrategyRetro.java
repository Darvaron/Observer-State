/*
 * Descripción: Estrategia música retro
 * Fecha: 14/02/2020
 * Versión: 1.0
 */
package logic.strategy;

import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import static logic.strategy.StrategyIn.play;


/**
 *
 * @author David Armando Rodríguez Varón, Juán Sebastián Sánchez Tabares
 */
public class StrategyRetro extends StrategyIn {

    @Override
    public void getSongs() throws FileNotFoundException, JavaLayerException {
        songs = new Player[3];
        for (int i = 0; i < 3; i++) {
            songs[i] = new Player(new FileInputStream("src/resources/music/retro"+i+".mp3"));  
        }
        play(songs);
    }

}
