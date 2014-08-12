/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.systeme.affichage;

import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.Texture;
import ch.p1gu.spacelama.Assets;
import ch.p1gu.spacelama.MyGame;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * 
 * @author Michael
 */
public class DessinerImage extends EntityProcessingSystem {

	@Mapper
	private ComponentMapper<Position> mapperPos;
	@Mapper
	private ComponentMapper<Dimension> mapperDim;
	@Mapper
	private ComponentMapper<Texture> mapperTexture;

	private OrthographicCamera guiCam;
	private SpriteBatch batch;

	public DessinerImage() {
		super(Aspect.getAspectForAll(Position.class, Dimension.class,
				Texture.class));
		
		batch = new SpriteBatch();
		guiCam = new OrthographicCamera(MyGame.largeur, MyGame.hauteur);
		guiCam.position.set(MyGame.largeur / 2, MyGame.hauteur / 2, 0);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void begin() {
		guiCam.update();
		batch.setProjectionMatrix(guiCam.combined);
		batch.enableBlending();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
	}

	@Override
	protected void end() {
		batch.end();
	}

	@Override
	protected void process(Entity e) {
		// on récupère la position à l'aide du mapper de position
		Position p = mapperPos.get(e);
		// on récupère la dimension à l'aide du mapper de dimensions
		Dimension d = mapperDim.get(e);

		Texture t = mapperTexture.get(e);

		switch (t.texture) {
		case 100:
			batch.draw(Assets.superLama, p.x, p.y, d.largeur, d.hauteur);
			break;
		case 200:
			batch.draw(Assets.vaisseau, p.x, p.y, d.largeur, d.hauteur);
			break;
		case 300:
			batch.draw(Assets.tirLama, p.x, p.y, d.largeur, d.hauteur);
			break;
		case 400:
			batch.draw(Assets.tir, p.x, p.y, d.largeur, d.hauteur);
			break;
		case 401:
			batch.draw(Assets.tir, p.x, p.y, d.largeur, d.hauteur);
			break;

		default:
			break;
		}

	}

}
