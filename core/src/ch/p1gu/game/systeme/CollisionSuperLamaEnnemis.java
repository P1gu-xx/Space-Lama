/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.Vie;
import ch.p1gu.spacelama.GlobalGameVariable;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Michael
 */
public class CollisionSuperLamaEnnemis extends VoidEntitySystem {

    @Mapper
    private ComponentMapper<Position> mapperPos;
    @Mapper
    private ComponentMapper<Dimension> mapperDim;
    @Mapper
    private ComponentMapper<Vie> mapperVie;

    @Override
    protected void processSystem() {

        Entity superLama = world.getManager(TagManager.class).getEntity("SuperLama");
        ImmutableBag<Entity> ennemis = world.getManager(GroupManager.class).getEntities("Ennemis");

        Position sPos = mapperPos.get(superLama);
        Dimension sDim = mapperDim.get(superLama);
        Rectangle sTir = new Rectangle(sPos.x, sPos.y, sDim.largeur, sDim.hauteur);

        for (int j = 0; j < ennemis.size(); j++) {
            Entity e = ennemis.get(j);
            Position ePos = mapperPos.get(e);
            Dimension eDim = mapperDim.get(e);

            Rectangle rEnn = new Rectangle(ePos.x, ePos.y, eDim.largeur, eDim.hauteur);
            if (rEnn.overlaps(sTir)) {
                Vie sVie = mapperVie.get(superLama);
                Vie eVie = mapperVie.get(e);
                sVie.vie--;
                eVie.vie=0;
                GlobalGameVariable.multiplicateurScore = 1;
            }

        }

    }

}
