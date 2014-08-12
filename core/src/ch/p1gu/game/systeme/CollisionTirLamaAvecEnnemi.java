/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme;

import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.Tir;
import ch.p1gu.game.composant.Vie;
import ch.p1gu.spacelama.GlobalGameVariable;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.managers.GroupManager;
import com.artemis.systems.VoidEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.math.Rectangle;

/**
 * 
 * @author Michael
 */
public class CollisionTirLamaAvecEnnemi extends VoidEntitySystem {

	@Mapper
	private ComponentMapper<Position> mapperPos;
	@Mapper
	private ComponentMapper<Dimension> mapperDim;
	@Mapper
	private ComponentMapper<Vie> mapperVie;
	@Mapper
	private ComponentMapper<Tir> mapperTir;

	@Override
	protected void processSystem() {
		ImmutableBag<Entity> tirsLama = world.getManager(GroupManager.class)
				.getEntities("TirsLama");
		ImmutableBag<Entity> ennemis = world.getManager(GroupManager.class)
				.getEntities("Ennemis");

		for (int i = 0; i < tirsLama.size(); i++) {
			Entity t = tirsLama.get(i);
			Position tPos = mapperPos.get(t);
			Dimension tDim = mapperDim.get(t);

			Rectangle rTir = new Rectangle(tPos.x, tPos.y, tDim.largeur,
					tDim.hauteur);

			for (int j = 0; j < ennemis.size(); j++) {
				Entity e = ennemis.get(j);
				Position ePos = mapperPos.get(e);
				Dimension eDim = mapperDim.get(e);

				Rectangle rEnn = new Rectangle(ePos.x, ePos.y, eDim.largeur,
						eDim.hauteur);
				if (rEnn.overlaps(rTir)) {
					Vie tVie = mapperVie.get(t);
					Vie eVie = mapperVie.get(e);
					tVie.vie--;
					eVie.vie -= mapperTir.get(t).puissance;

					GlobalGameVariable.score += 10 * GlobalGameVariable.multiplicateurScore;
					GlobalGameVariable.multiplicateurScore += 1;
				}

			}

		}
	}
}
