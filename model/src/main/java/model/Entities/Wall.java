package model.Entities;

public class Wall extends Sprites {
    /*sprite ID*/
    public static final int spriteID = 0;

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
