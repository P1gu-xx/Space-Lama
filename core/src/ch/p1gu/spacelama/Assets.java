package ch.p1gu.spacelama;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Michael
 */
public class Assets {

    public static TextureAtlas atlas;
    public static TextureRegion superLama, retour, utilisateur, vaisseau, pseudo, buttonDown, buttonUp, tir, tirLama;
    public static Texture titre, bg, bgJeux,bouclier;
    public static BitmapFont white, black;

    public static void load() {

        titre = new Texture("data/img/Titre.png");
        bg = new Texture("data/img/bg.png");
        bgJeux = new Texture("data/img/bgJeux.jpg");
        bouclier=new Texture("data/img/bouclier.png");
        
        atlas = new TextureAtlas("data/img/SpaceLama.pack");

        superLama = atlas.findRegion("SuperLama");
        retour = atlas.findRegion("Retour");
        utilisateur = atlas.findRegion("utilisateur");
        vaisseau = atlas.findRegion("vaisseau");
        pseudo = atlas.findRegion("pseudo");
        buttonDown = atlas.findRegion("buttonDown");
        buttonUp = atlas.findRegion("buttonUp");
        tir = atlas.findRegion("tir");
        tirLama = atlas.findRegion("tir_lama");




        white = new BitmapFont(Gdx.files.internal("data/font/whiteFont.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("data/font/blackFont.fnt"), false);

    }

    public static void dispose() {
        atlas.dispose();
        titre.dispose();
        bg.dispose();
        bgJeux.dispose();
        white.dispose();
        black.dispose();
        bouclier.dispose();
    }
}