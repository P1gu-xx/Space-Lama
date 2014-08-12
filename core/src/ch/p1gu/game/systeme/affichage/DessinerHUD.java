/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme.affichage;

import ch.p1gu.game.composant.Vie;
import ch.p1gu.game.composant.Bouclier;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author Michael
 */
public class DessinerHUD extends VoidEntitySystem {

    @Mapper
    private ComponentMapper<Vie> mapperVie;
    @Mapper
    private ComponentMapper<Bouclier> mapperBou;

    private ShapeRenderer rendererFilled;

    @Override
    protected void processSystem() {
        Entity superLama = world.getManager(TagManager.class).getEntity("SuperLama");
        Vie vie = mapperVie.get(superLama);
        Bouclier bouclier = mapperBou.get(superLama);
        
        for (int i = 0; i < vie.vie; i++) {
        	rendererFilled.setColor(Color.RED);
        	rendererFilled.circle(10+((i*12)), 7, 5);
        }
        
        rendererFilled.setColor(Color.BLUE);
        rendererFilled.rect(5, 17, bouclier.energie*1, 10);
    }

    @Override
    protected void initialize() {

    	rendererFilled = new ShapeRenderer();

    }

    @Override
    protected void begin() {

    	rendererFilled.begin(ShapeRenderer.ShapeType.Filled);
    }

    @Override
    protected void end() {
        //à la fin de l'éxecution de notre système, on referme notre renderer
    	rendererFilled.end();
    }
}
