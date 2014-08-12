package ch.p1gu.spacelama.screen;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;
import ch.p1gu.spacelama.Assets;
import ch.p1gu.spacelama.MyGame;
import ch.p1gu.spacelama.tween.SpriteTweenAccessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Michael
 */
public class SplashScreen implements Screen {


    private SpriteBatch batch;
    private Sprite bg, titre, superLama;
    private TweenManager tweenManager;

    public SplashScreen() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        bg.draw(batch);
        titre.draw(batch);
        superLama.draw(batch);
        batch.end();

        tweenManager.update(delta);
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void show() {
        //creation du sprite batch
        batch = new SpriteBatch();
        
        //creation du bg + definition de la taille
        bg = new Sprite(Assets.bg);
        bg.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //creation du titre +definition de la taille
        titre = new Sprite(Assets.titre);
        titre.setBounds(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8 * 3, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 6);

        //cration du lama + definition de la taille
        superLama = new Sprite(Assets.superLama);
        superLama.setBounds(-Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() / 5, Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() / 6);
        
        //cration du gestionnair de Tween + enregistrement
        tweenManager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteTweenAccessor());

        //creation de l'animation
        Timeline.createSequence()
                .push(Tween.set(superLama, SpriteTweenAccessor.Y).target(Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6))
                .push(Tween.set(titre, SpriteTweenAccessor.X).target(-titre.getWidth() - superLama.getWidth() - 20))
                .beginParallel()
                .push(Tween.to(titre, SpriteTweenAccessor.X, 2f).target(Gdx.graphics.getWidth() / 2 - titre.getWidth() / 2))
                .push(Tween.to(superLama, SpriteTweenAccessor.X, 2f).target(Gdx.graphics.getWidth()))
                .end()
                .setCallback(new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
            	MyGame.game.setScreen(new MainMenuScreen());
            }
        })
                .start(tweenManager);
        
        // evite de voire des image avant l'animation
        tweenManager.update(Float.MIN_VALUE);


    }
    
    @Override
    public void hide() {
    }

    @Override
    public void pause() {
        dispose();
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}