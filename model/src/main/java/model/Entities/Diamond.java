package model.Entities;

import model.IFallable;

/**
 * @author Lucien
 * Class for the diamond
 */
public class Diamond extends Sprites implements IFallable {

    /*
     Sprites number
     */
    public static final int spriteID = 4;

    /**
     * @return the sprite ID
     */
    @Override
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