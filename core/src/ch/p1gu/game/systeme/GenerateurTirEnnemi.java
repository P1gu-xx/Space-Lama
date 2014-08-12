/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.EnnemiDeltaTir;
import ch.p1gu.game.composant.Arme;
import ch.p1gu.spacelama.EntityFactory;
import ch.p1gu.spacelama.EntityFactory;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.systems.VoidEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;

/**
 *
 * @author Michael
 */
public class GenerateurTirEnnemi extends VoidEntitySystem {

    @Mapper
    private ComponentMapper<EnnemiDeltaTir> mapperEDT;
    @Mapper
    private ComponentMapper<Position> mapperPos;
    @Mapper
    private ComponentMapper<Dimension> mapperDim;
    @Mapper
    private ComponentMapper<Arme> mapperArme;

    @Override
    protected void processSystem() {
        ImmutableBag<Entity> ennemis = world.getManager(GroupManager.class).getEntities("Ennemis");
        for (int i = 0; i < ennemis.size(); i++) {
            Entity e = ennemis.get(i);
            EnnemiDeltaTir edt = mapperEDT.get(e);
            if (edt.tempEcoule > 1f) {
                edt.tempEcoule = 0;
                Position p = mapperPos.get(e);
                Dimension d = mapperDim.get(e);
                EntityFactory.creerTirEnnemi(world, p.x, p.y + d.hauteur / 2, mapperArme.get(e).type).addToWorld();
            } else {
                edt.tempEcoule += Gdx.graphics.getDeltaTime();
            }

        }
    }

}
