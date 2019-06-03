package model.Entities;

/**
 * @author Lucien
 * the class for the exit object
 */
public class Exit extends Sprites {
    
    /*Sprite ID*/
    public static final int spriteID = 6;
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
