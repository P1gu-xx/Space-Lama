/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Arme;
import ch.p1gu.game.composant.Vitesse;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 *
 * @author Michael
 */
public class ControleSuperLama extends VoidEntitySystem {

    @Mapper
    private ComponentMapper<Vitesse> mapperVitesse;

    @Mapper
    private ComponentMapper<Arme> mapperArme;

    @Override
    protected void processSystem() {
        Entity superLama = world.getManager(TagManager.class).getEntity("SuperLama");
        Vitesse vSuperLama = mapperVitesse.get(superLama);
        Arme arme = mapperArme.get(superLama);
        float x = 0, y = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= 250;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += 250;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= 250;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += 250;
        }

        arme.enTir = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        vSuperLama.x = x;
        vSuperLama.y = y;

    }

}
