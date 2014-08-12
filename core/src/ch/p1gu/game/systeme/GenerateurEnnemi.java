/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.spacelama.EntityFactory;
import ch.p1gu.spacelama.MyGame;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;

/**
 *
 * @author Michael
 */
public class GenerateurEnnemi extends VoidEntitySystem {

    private float delta;
    private float vitesseDeGeneration;

    public GenerateurEnnemi() {
        delta = 0;
        vitesseDeGeneration = 0.5f;
    }

    @Override
    protected void processSystem() {
        float d = Gdx.graphics.getDeltaTime();
        if (delta > vitesseDeGeneration) {
            delta = 0;
            vitesseDeGeneration -= 0.1f * delta;
            EntityFactory.creerEnnemi(world, MyGame.largeur, (int) ((Math.random() * (MyGame.hauteur - 21))), 20, 20, -100, 0, 2, 2, 200, 5, 1).addToWorld();
        } else {
            delta += d;
        }

        vitesseDeGeneration -= 0.005f * d;
    }

}
