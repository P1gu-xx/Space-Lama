package ch.p1gu.spacelama.screen;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import ch.p1gu.spacelama.Assets;
import ch.p1gu.spacelama.MyGame;
import ch.p1gu.spacelama.tween.SpriteTweenAccessor;
import ch.p1gu.spacelama.tween.TextButtonTweenAccessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 *
 * @author Michael
 */
public class MainMenuScreen implements Screen {

    private SpriteBatch batch;
    private Sprite bg, titre, superLama;
    private Skin skin;
    private TextButton buttonPlay, buttonShop, buttonScore, buttonAchivements, buttonExit;
    private TweenManager tweenManager;
    private Stage stage;

    public MainMenuScreen() {
        //Gdx.input=RemoteAndroid.getInstance();
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

        stage.act(delta);
        stage.draw();

        tweenManager.update(delta);
    }

    @Override
    public void resize(int i, int i1) {
                //creation du sprite batch
        batch = new SpriteBatch();

        stage = new Stage();

        //creation du bg + definition de la taille
        bg = new Sprite(Assets.bg);
        bg.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //creation du titre +definition de la taille
        titre = new Sprite(Assets.titre);
        titre.setBounds(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8 * 3, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6, Gdx.graphics.getWidth() / 4 * 3, Gdx.graphics.getHeight() / 6);

        //cration du lama + definition de la taille
        superLama = new Sprite(Assets.superLama);
        superLama.setBounds(-Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() / 5, Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() / 6);
        superLama.flip(true, false);

        skin = new Skin(Gdx.files.internal("data/ui/menuSkin.json"), Assets.atlas);


        buttonPlay = new TextButton("Jouer", skin);
        buttonPlay.setX(Gdx.graphics.getWidth());
        buttonPlay.setY(Gdx.graphics.getHeight() / 14 * 10);
        buttonPlay.setHeight(Gdx.graphics.getHeight() / 14 * 1.5f);
        buttonPlay.setWidth(Gdx.graphics.getWidth() / 10 * 2);
        buttonPlay.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);

                MyGame.game.setScreen(new GameSettingsMenuScreen());
                Gdx.input.setInputProcessor(null);
            }
        });
        stage.addActor(buttonPlay);

        buttonShop = new TextButton("Magasin", skin);
        buttonShop.setX(Gdx.graphics.getWidth());
        buttonShop.setY(Gdx.graphics.getHeight() / 14 * 8);
        buttonShop.setHeight(Gdx.graphics.getHeight() / 14 * 1.5f);
        buttonShop.setWidth(Gdx.graphics.getWidth() / 10 * 2);
        buttonShop.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button); 

                
            }
        });
        stage.addActor(buttonShop);

        buttonScore = new TextButton("Score", skin);
        buttonScore.setX(Gdx.graphics.getWidth());
        buttonScore.setY(Gdx.graphics.getHeight() / 14 * 6);
        buttonScore.setHeight(Gdx.graphics.getHeight() / 14 * 1.5f);
        buttonScore.setWidth(Gdx.graphics.getWidth() / 10 * 2);
        buttonScore.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button); //To change body of generated methods, choose Tools | Templates.
            }
        });
        stage.addActor(buttonScore);

        buttonAchivements = new TextButton("Succes", skin);
        buttonAchivements.setX(Gdx.graphics.getWidth());
        buttonAchivements.setY(Gdx.graphics.getHeight() / 14 * 4);
        buttonAchivements.setHeight(Gdx.graphics.getHeight() / 14 * 1.5f);
        buttonAchivements.setWidth(Gdx.graphics.getWidth() / 10 * 2);
        buttonAchivements.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button); //To change body of generated methods, choose Tools | Templates.
            }
        });
        stage.addActor(buttonAchivements);

        buttonExit = new TextButton("Quitter", skin);
        buttonExit.setX(Gdx.graphics.getWidth());
        buttonExit.setY(Gdx.graphics.getHeight() / 14 * 2);
        buttonExit.setHeight(Gdx.graphics.getHeight() / 14 * 1.5f);
        buttonExit.setWidth(Gdx.graphics.getWidth() / 10 * 2);
        buttonExit.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                Gdx.app.exit();
                /*Dialog dialog = new Dialog("", skin) {
                    protected void result(Object object) {
                        if ((Boolean) object) {
                            Gdx.app.exit();
                        }
                    }
                }.text("Do you want to leave the game?").button("Yes", true).button("No", false).key(Input.Keys.ENTER, true)
                        .key(Input.Keys.ESCAPE, false);
                dialog.setBackground(new TextureRegionDrawable(Assets.buttonDown));
                dialog.show(stage);
*/
            }
        });
        stage.addActor(buttonExit);

        tweenManager = new TweenManager();
        Tween.registerAccessor(Sprite.class, new SpriteTweenAccessor());
        Tween.registerAccessor(TextButton.class, new TextButtonTweenAccessor());

        //creation de l'animation
        Timeline.createSequence()
                .push(Tween.set(superLama, SpriteTweenAccessor.X).target(Gdx.graphics.getWidth()))
                .push(Tween.set(superLama, SpriteTweenAccessor.Y).target(Gdx.graphics.getHeight() / 2.5f))
                .delay(1f)
                .beginParallel()
                .push(Tween.to(superLama, SpriteTweenAccessor.X, 1.5f).target(-superLama.getWidth()))
                .push(Tween.to(buttonPlay, SpriteTweenAccessor.X, 2f).target(Gdx.graphics.getWidth() / 10 * 2))
                .push(Tween.to(buttonShop, SpriteTweenAccessor.X, 2.5f).target(Gdx.graphics.getWidth() / 10 * 3))
                .push(Tween.to(buttonScore, SpriteTweenAccessor.X, 2.7f).target(Gdx.graphics.getWidth() / 10 * 4))
                .push(Tween.to(buttonAchivements, SpriteTweenAccessor.X, 2.9f).target(Gdx.graphics.getWidth() / 10 * 5))
                .push(Tween.to(buttonExit, SpriteTweenAccessor.X, 3f).target(Gdx.graphics.getWidth() / 10 * 6))
                .end()
                .start(tweenManager);

        // evite de voire des image avant l'animation
        tweenManager.update(Float.MIN_VALUE);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {


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
        stage.dispose();
        skin.dispose();
    }
}
