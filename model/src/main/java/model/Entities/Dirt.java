package model.Entities;

import model.IBreakable;

/**
 * @author Lucien
 * Class for the dirt
 */
public class Dirt extends Sprites implements IBreakable {

    /*
      Sprites number
     */
    public static final int spriteID = 1;

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
        return false;
    }
}
