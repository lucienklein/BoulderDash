package model.Entities;

import model.IFallable;

/**
 * @author Lucien
 * the class for the rock
 */

public class Rock extends Sprites implements IFallable {
    /*sprite ID*/
    public static final int spriteID = 3;
    /**
     * getter for the ID
     * @return the sprite ID
     */
    @Override
    public int getID() {
        return spriteID;
    }

    /**
     * method to know if the object can fall
     * @return the state if the object can fall
     */
    @Override
    public boolean isFallable() {
        return true;
    }
}
