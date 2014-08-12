package ch.p1gu.spacelama;

import ch.p1gu.spacelama.screen.SplashScreen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends Game {
	
	public static Game game;
	
	 public final static int hauteur = 640, largeur = 1280;
	
	public MyGame() {
		this.game=this;
	}

	@Override
	public void create() {
		Assets.load();
		setScreen(new SplashScreen());
	}
	 
	
}
