package ch.p1gu.spacelama.screen;

import ch.p1gu.spacelama.MyGame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameOverScreen implements Screen {

	private BitmapFont font;
	private SpriteBatch batch;
	private float deltaGameOver;

	public GameOverScreen() {
		font = new BitmapFont(Gdx.files.internal("data/font/blackFont.fnt"), false);
		batch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.scale(0.02f);
		dessinerStringCentreRectangle("GAME OVER", new Rectangle(0, 0,
				MyGame.largeur, MyGame.hauteur));
		batch.end();

		deltaGameOver += delta;
		if (deltaGameOver > 2) {
			MyGame.game.setScreen(new GameScreen());
		}
	}

	private void dessinerStringCentreRectangle(String text, Rectangle r) {
		float fontX = r.x + r.width / 2 - font.getBounds(text).width / 2;
		float fontY = r.y + r.height / 2 + font.getBounds(text).height / 2;
		font.draw(batch, text, fontX, fontY);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
