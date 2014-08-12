/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Vie;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

/**
 *
 * @author Michael
 */
public class NettoyeurMort extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Vie> mapperVie;

    public NettoyeurMort() {
        super(Aspect.getAspectForAll(Vie.class));
    }

    @Override
    protected void process(Entity entity) {
        Vie v = mapperVie.get(entity);
        if (v.vie < 1) {
            entity.deleteFromWorld();
        }
    }

}
