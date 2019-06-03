package model.Entities;

/**
 * @author Lucien
 * the class for the background
 */
public class Background extends Sprites {
    /*
     Sprite ID
     */
    public static final int spriteID = 2;

    /**
     * @return the sprite ID
     */
    @Override
    public int getID() {
        return spriteID;
    }

    /**
     * @return the state if the object can fall or not
     */
    @Override
    public boolean isFallable() {
        return false;
    }
}
