/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.Vitesse;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;

/**
 *
 * @author Michael
 */
public class Deplacer extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Position> mapperPos;
    @Mapper
    ComponentMapper<Vitesse> mapperVit;

    public Deplacer() {
        super(Aspect.getAspectForAll(Position.class, Vitesse.class));
    }

    @Override
    protected void process(Entity e) {
        float delta = Gdx.graphics.getDeltaTime();

        Position p = mapperPos.get(e);
        Vitesse v = mapperVit.get(e);

        p.x += v.x * delta;
        p.y += v.y * delta;
    }

}
