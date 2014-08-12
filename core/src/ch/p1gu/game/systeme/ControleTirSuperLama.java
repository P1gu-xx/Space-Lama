/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Arme;
import ch.p1gu.game.composant.Position;
import ch.p1gu.spacelama.EntityFactory;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.TagManager;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;

/**
 * 
 * @author Michael
 */
public class ControleTirSuperLama extends VoidEntitySystem {

	@Mapper
	private ComponentMapper<Arme> mapperArme;
	@Mapper
	private ComponentMapper<Position> mapperPosition;

	@Override
	protected void processSystem() {
		Entity superLama = world.getManager(TagManager.class).getEntity(
				"SuperLama");
		Arme arme = mapperArme.get(superLama);
		arme.dernierTir += Gdx.graphics.getDeltaTime();
		if (arme.enTir) {

			Position p = mapperPosition.get(superLama);
			switch (arme.type) {
			case 1:
				if (arme.dernierTir > 0.05f) {
					EntityFactory.creerTirLama(world, p.x + 20, p.y + 15, 300,
							(int) ((Math.random() - 0.5) * 30), 1).addToWorld();
					arme.dernierTir = 0;
				}
				break;
			default:
				throw new AssertionError();
			}
		}

	}

}
