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
public class Acceleration extends Component{
    public float x,y;
    
    public Acceleration(float aX, float aY) {
        this.x = aX;
        this.y = aY;
    }
    
    
}
