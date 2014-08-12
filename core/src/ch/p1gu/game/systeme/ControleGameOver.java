/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Vie;
import ch.p1gu.spacelama.MyGame;
import ch.p1gu.spacelama.screen.GameOverScreen;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;

/**
 *
 * @author Michael
 */
public class ControleGameOver extends VoidEntitySystem {

    @Mapper
    private ComponentMapper<Vie> mapperVie;

    @Override
    protected void processSystem() {
        Entity superLama = world.getManager(TagManager.class).getEntity("SuperLama");
        Vie v=mapperVie.get(superLama);
        if(v.vie<1){
            MyGame.game.setScreen(new GameOverScreen());
        }
    }

}
