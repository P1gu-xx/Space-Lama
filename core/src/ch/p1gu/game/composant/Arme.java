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
public class Arme extends Component {

    public boolean enTir;
    public int type;
    public float dernierTir;
    
    
    public Arme(int type) {
        this.type = type;
    }

}
