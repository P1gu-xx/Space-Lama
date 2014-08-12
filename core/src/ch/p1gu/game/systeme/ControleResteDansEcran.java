/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import ch.p1gu.spacelama.MyGame;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;

/**
 *
 * @author Michael
 */
public class ControleResteDansEcran extends VoidEntitySystem {

    @Mapper
    private ComponentMapper<Position> mapperPos;
    @Mapper
    private ComponentMapper<Dimension> mapperDim;

    @Override
    protected void processSystem() {
        Entity superLama = world.getManager(TagManager.class).getEntity("SuperLama");
        Position p = mapperPos.get(superLama);
        Dimension d = mapperDim.get(superLama);

        if (p.x < 0) {
            p.x = 0;
        }

        if (p.y < 0) {
            p.y = 0;
        }
        if (p.x + d.largeur > MyGame.largeur) {
            p.x = MyGame.largeur - d.largeur;
        }

        if (p.y + d.hauteur > MyGame.hauteur) {
            p.y = MyGame.hauteur - d.hauteur;
        }
    }

}
