/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.game.composant;

import com.artemis.Component;

/**
 *
 * @author Michael
 */
public class Bouclier extends Component {

    public int type;
    public boolean activer;
    public float energie;

    public Bouclier(boolean activer, float energie) {
        this.activer = activer;
        this.energie = energie;
    }

}
