/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Acceleration;
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
public class CalculerVitesse extends EntityProcessingSystem {

    @Mapper
    ComponentMapper<Vitesse> mapperVit;
    @Mapper
    ComponentMapper<Acceleration> mapperAcc;

    public CalculerVitesse() {
        super(Aspect.getAspectForAll(Vitesse.class, Acceleration.class));
    }

    @Override
    protected void process(Entity e) {
        float delta = Gdx.graphics.getDeltaTime();
        Vitesse v = mapperVit.get(e);
        Acceleration a = mapperAcc.get(e);

        v.x += a.x * delta;
        v.y += a.y * delta;

    }
}
