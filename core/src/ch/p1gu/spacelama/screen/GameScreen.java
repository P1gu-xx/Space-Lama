package ch.p1gu.spacelama.screen;

import ch.p1gu.game.systeme.CalculerVitesse;
import ch.p1gu.game.systeme.CollisionSuperLamaEnnemis;
import ch.p1gu.game.systeme.CollisionSuperLamaTirsEnnemis;
import ch.p1gu.game.systeme.CollisionTirLamaAvecEnnemi;
import ch.p1gu.game.systeme.ControleGameOver;
import ch.p1gu.game.systeme.ControleResteDansEcran;
import ch.p1gu.game.systeme.ControleSuperLama;
import ch.p1gu.game.systeme.ControleTirSuperLama;
import ch.p1gu.game.systeme.Deplacer;
import ch.p1gu.game.systeme.affichage.DessinerFormes;
import ch.p1gu.game.systeme.affichage.DessinerImage;
import ch.p1gu.game.systeme.GenerateurEnnemi;
import ch.p1gu.game.systeme.GenerateurTirEnnemi;
import ch.p1gu.game.systeme.NettoyeurHorsEcrant;
import ch.p1gu.game.systeme.NettoyeurMort;
import ch.p1gu.game.systeme.affichage.DessinerHUD;
import ch.p1gu.spacelama.EntityFactory;
import ch.p1gu.spacelama.MyGame;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Michael
 */
public class GameScreen implements Screen {

    private World world;
    private OrthographicCamera guiCam;
    private SpriteBatch batch;
    
    
    public GameScreen() {
        world = new World();
        world.setManager(new GroupManager());
        world.setManager(new TagManager());
        
        world.setSystem(new ControleSuperLama());
        world.setSystem(new ControleTirSuperLama());
        world.setSystem(new GenerateurEnnemi());
        world.setSystem(new GenerateurTirEnnemi());
        world.setSystem(new CalculerVitesse());
        world.setSystem(new Deplacer());  
        world.setSystem(new ControleResteDansEcran());
        world.setSystem(new NettoyeurHorsEcrant());
        world.setSystem(new CollisionTirLamaAvecEnnemi());
        world.setSystem(new CollisionSuperLamaEnnemis());
        world.setSystem(new CollisionSuperLamaTirsEnnemis());
        
        world.setSystem(new ControleGameOver());
        world.setSystem(new NettoyeurMort());
        //world.setSystem(new DessinerFormes());
        world.setSystem(new DessinerImage());
        world.setSystem(new DessinerHUD());

        EntityFactory.creerSuperLama(world, 10, MyGame.hauteur/2-10, 0, 0, 100, 20).addToWorld();

        world.initialize();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        System.out.println("nbr entity : " + world.getEntityManager().getActiveEntityCount());
        world.process();
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
    }

}

