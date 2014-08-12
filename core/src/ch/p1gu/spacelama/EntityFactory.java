package ch.p1gu.spacelama;

import ch.p1gu.game.composant.Acceleration;
import ch.p1gu.game.composant.Arme;
import ch.p1gu.game.composant.Bouclier;
import ch.p1gu.game.composant.Dimension;
import ch.p1gu.game.composant.Position;
import ch.p1gu.game.composant.Texture;
import ch.p1gu.game.composant.Tir;
import ch.p1gu.game.composant.Vie;
import ch.p1gu.game.composant.Vitesse;
import ch.p1gu.game.composant.EnnemiDeltaTir;

import ch.p1gu.game.composant.EnnemiType;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;

public class EntityFactory {
    public static Entity creerSuperLama(World w, float pX, float pY, float vX, float vY, int texture, int vie) {
        Entity superLama = w.createEntity();

        superLama.addComponent(new Position(pX, pY));
        superLama.addComponent(new Vitesse(vX, vY));
        superLama.addComponent(new Dimension(20, 20));
        superLama.addComponent(new Arme(1));
        superLama.addComponent(new Vie(vie));
        superLama.addComponent(new Bouclier(false, 100));
        superLama.addComponent(new Texture(texture));

        w.getManager(TagManager.class).register("SuperLama", superLama);
        return superLama;
    }

    public static Entity creerTirLama(World w, float pX, float pY, float vX, float vY, int arme) {
        Entity t = w.createEntity();

        t.addComponent(new Position(pX, pY));
        switch (arme) {
            case 1:
                t.addComponent(new Dimension(5, 5));
                t.addComponent(new Vitesse(vX, vY));
                t.addComponent(new Vie(1));
                t.addComponent(new Tir(3));
                t.addComponent(new Texture(300));
                break;
            default:
                throw new AssertionError();
        }

        w.getManager(GroupManager.class).add(t, "TirsLama");

        return t;
    }

    public static Entity creerEnnemi(World w, float pX, float pY, float dX, float dY, float vX, float vY, int forme, int arme, int texture, int vie, int type) {
        Entity ennemi = w.createEntity();

        ennemi.addComponent(new Position(pX, pY));
        ennemi.addComponent(new Vitesse(vX, vY));
        ennemi.addComponent(new Dimension(dX, dY));
        ennemi.addComponent(new Arme(arme));
        ennemi.addComponent(new Vie(vie));
        ennemi.addComponent(new Texture(texture));
        ennemi.addComponent(new EnnemiType(type));
        ennemi.addComponent(new Acceleration(0.0f, 0.0f));
        ennemi.addComponent(new EnnemiDeltaTir(0));

        w.getManager(GroupManager.class).add(ennemi, "Ennemis");

        return ennemi;
    }

    public static Entity creerTirEnnemi(World w, float pX, float pY, int arme) {
        Entity t = w.createEntity();

        t.addComponent(new Position(pX, pY));
        switch (arme) {
            case 1:
                t.addComponent(new Dimension(5, 5));
                t.addComponent(new Vitesse(-150, 0));
                t.addComponent(new Vie(1));
                t.addComponent(new Tir(1));
                t.addComponent(new Texture(400));
                break;
            case 2:
                t.addComponent(new Dimension(2, 2));
                t.addComponent(new Vitesse(-150, 0));
                t.addComponent(new Vie(1));
                t.addComponent(new Tir(1));
                t.addComponent(new Acceleration(-100,0));
                t.addComponent(new Texture(401));
                break;
            default:
                throw new AssertionError();
        }

        w.getManager(GroupManager.class).add(t, "TirsEnnemis");

        return t;
    }
}