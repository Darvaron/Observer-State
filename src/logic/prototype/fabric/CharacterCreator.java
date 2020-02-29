/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.prototype.fabric;

import java.awt.Image;
import java.util.ArrayList;
import logic.build.CharacterC;
import logic.build.CharacterDir;
import logic.build.builders.GokuBuilder;
import logic.build.builders.MegamanBuilder;
import logic.factories.CharacterFac;
import logic.factories.GokuFac;
import logic.factories.MegamanFac;
import logic.products.Body;
import logic.products.Sprite;
import logic.prototype.prototypes.Goku;
import logic.prototype.prototypes.Megaman;
import view.Main;

/**
 *
 * @author PC-Lirol
 */
public class CharacterCreator {

    private Goku goku;
    private CharacterDir dir1;
    private Megaman megaman;
    private CharacterDir dir2;
    private Main jfr;
    public CharacterFac factory;
    public Body bodyCharacter;
    public Sprite spriteCharacter;
    public CharacterFac factory1;
    public Body bodyCharacter1;
    public Sprite spriteCharacter1;

    public CharacterCreator() {
        goku = new Goku();
        megaman = new Megaman();

        //Crea los personajes
        
        //Pide partes por abstract factory
        factory= new GokuFac();
        factory1= new MegamanFac();
        //Goku
        bodyCharacter=factory.createBody();
        spriteCharacter=factory.createSprite();
        //Megaman
        bodyCharacter1=factory1.createBody();
        spriteCharacter1=factory1.createSprite();
        
        //Builder
        //Crea los directores
        
        //1 para goku, 2 para megaman
        dir1= new CharacterDir();
        dir2= new CharacterDir();
        
        dir1.setConstructor(new GokuBuilder());
        dir2.setConstructor(new MegamanBuilder());
        dir1.buildChar(spriteCharacter.getImages(), bodyCharacter);
        dir2.buildChar(spriteCharacter1.getImages(), bodyCharacter1);
        
        goku.setBody(dir1.getCharacter().getBody());
        megaman.setBody(dir2.getCharacter().getBody());
        goku.setRunL(dir1.getCharacter().getRunL());
        megaman.setRunL(dir2.getCharacter().getRunL());
        goku.setRunR(dir1.getCharacter().getrunR());
        megaman.setRunR(dir2.getCharacter().getrunR());
        goku.setSkill(dir1.getCharacter().getSkill());
        megaman.setSkill(dir2.getCharacter().getSkill());
        goku.setState(4);
        megaman.setState(4);
        goku.setActualImg(0);
        megaman.setActualImg(0);
        
    }
    
    public CharacterC retrieveCharacter(String kindOfCharacter) {
        if ("m".equals(kindOfCharacter)) {
            return (CharacterC) megaman.clone();
        } else if ("g".equals(kindOfCharacter)) {
            return (CharacterC) goku.clone();
        } // if	

        return null;
    } // method retrieveAnimal

}
