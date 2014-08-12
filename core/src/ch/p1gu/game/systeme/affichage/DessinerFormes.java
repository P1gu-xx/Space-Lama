/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme.affichage;

import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * 
 * @author Michael
 */
public class DessinerFormes extends EntityProcessingSystem {

	@Mapper
	private ComponentMapper<Position> mapperPos;
	@Mapper
	private ComponentMapper<Dimension> mapperDim;

	private ShapeRenderer rendererFilled;

	public DessinerFormes() {
		super(Aspect.getAspectForAll(Position.class, Dimension.class));
	}

	@Override
	protected void initialize() {
		rendererFilled = new ShapeRenderer();

	}

	@Override
	protected void begin() {
		// on démarre notre renderer de façon à ce qu'il dessine des contours
		rendererFilled.begin(ShapeType.Filled);
	}

	@Override
	protected void end() {
		// à la fin de l'éxecution de notre système, on referme notre
		// renderer
		rendererFilled.end();
	}

	@Override
	protected void process(Entity e) {
		// on récupère la position à l'aide du mapper de position
		Position p = mapperPos.get(e);
		// on récupère la dimension à l'aide du mapper de dimensions
		Dimension d = mapperDim.get(e);

		rendererFilled.rect(p.x, p.y, d.largeur, d.hauteur);

	}

}
