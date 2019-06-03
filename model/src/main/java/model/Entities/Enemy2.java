package model.Entities;

import model.IEnemy;

public class Enemy2 extends Sprites implements IEnemy {
    /*
    the sprite ID
     */
public static final int spriteID = 10;

    /**
     * the getter for the sprite ID
     * @return the sprite ID
     */
    @Override
    public int getID() {
        return spriteID;
    }

    /**
     * the method to know if the object can fall or not
     * @return the boolean state if it can fall or not
     */
    @Override
    public boolean isFallable() {
        return false;
    }
}
