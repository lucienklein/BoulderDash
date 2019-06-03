package model.Entities;

import model.*;

/**
 * @author Tristan The class for the enemy
 */
public class Enemy extends Sprites implements IEnemy {
    /* The sprite ID */
    public static final int spriteID = 9;

    /**
     * @return the sprite ID
     */
    public int getID() {
        return spriteID;
    }

    /**
     * @return the state if the object can fall
     */
    @Override
    public boolean isFallable() {
        return true;
    }
}
