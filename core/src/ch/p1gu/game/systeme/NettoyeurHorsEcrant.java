/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.Vie;
import ch.p1gu.spacelama.MyGame;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

/**
 *
 * @author Michael
 */
public class NettoyeurHorsEcrant extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> mapperPos;

    public NettoyeurHorsEcrant() {
        super(Aspect.getAspectForAll(Position.class));
    }

    @Override
    protected void process(Entity entity) {
        Position p = mapperPos.get(entity);
        if (p.x > MyGame.largeur + 5) {
            entity.deleteFromWorld();
        } else if (p.x < -100) {
            entity.deleteFromWorld();
        } else if (p.y < -50) {
            entity.deleteFromWorld();
        } else if (p.y > MyGame.hauteur + 100) {
            entity.deleteFromWorld();
        }
    }

}
