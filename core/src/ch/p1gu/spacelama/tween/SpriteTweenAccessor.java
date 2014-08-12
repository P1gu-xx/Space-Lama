/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.p1gu.spacelama.tween;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Michael
 */
public class SpriteTweenAccessor implements TweenAccessor<Sprite> {

    public static final int Y = 0, X = 1;

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case Y:
                returnValues[0] = target.getY();
                return 1;
            case X:
                returnValues[0] = target.getX();
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
                switch (tweenType) {
            case Y:
                target.setY(newValues[0]);
                break;
            case X:
                target.setX(newValues[0]);
               break;
        }
    }
}
