/*
 * Descripción: moneda
 * Fecha: 26/09/2019
 * Versión: 1.0
 */
package view.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import logic.build.CharacterC;
import logic.build.CharacterInterface;
import logic.decorator.CharBack;
import view.Main;

/**
 *
 * @author David Armando Rodríguez Varón, Juan Sebastián Sánchez Tabares
 */
public class Coin extends Objecto{

    public Coin() {
        super("coin_", 6,"coin");
    }
    
    public CharacterInterface doEfect(CharacterInterface charIn) {
        CharacterInterface back = new CharBack(charIn);
        return back;
        /*Graphics2D g2d = (Graphics2D) Main.canvas.imgBuffer.getGraphics();
        g2d.drawImage(Main.canvas.imgBuffer, 0, 0, -1000, -700, null);
        AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
        tx.translate(-Main.canvas.imgBuffer.getWidth(null), -Main.canvas.imgBuffer.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        Main.canvas.imgBuffer = op.filter((BufferedImage)Main.canvas.imgBuffer, null);*/
    }
    
}
