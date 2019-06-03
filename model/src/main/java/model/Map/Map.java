package model.Map;

import model.*;
import model.Entities.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Tristan
 * the class map to define the map characteristics
 */
public class Map implements IMap {

/*the map width*/
    private int width = 0;
/*the map height*/
    private int height = 0;
/*the array for the sprites*/
    private Sprites[][] sprites;
/*the image*/
    private BufferedImage image;

    /*the score*/
    private int score;
/* the diamonds number*/
    private int nbDiamond;

    /**
     * the class constructor
     * @param map the map
     */
    public Map(String map) {
        sprites = new Sprites[height][width];
        image = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_RGB);
        score = 0;
        nbDiamond = 0;
        stringToMapConverter(map);
    }

    /**
     * COnverter (Strings stored in an array, which will become the map
     * @param str the string (equals to the map in fact)
     */

    private void stringToMapConverter(String str) {
        String[][] str_tmp = new String[1000][1000];
        String[] tmp = str.split("\n");
        height = tmp.length;
/*we use the comma as a separator for each value of our map, in order to implement them one by one in our array*/
        for (int i = 0; i < tmp.length; i++) {
            String[] tmp2 = tmp[i].split(",");
            width = tmp2.length;

            for (int j = 0; j < tmp2.length; j++) {
                str_tmp[i][j] = tmp2[j];
            }
        }
        sprites = new Sprites[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int spriteID = (int) str_tmp[i][j].charAt(0) - 48;

                convertNumToSprite(spriteID, j, i);
                if(spriteID == Diamond.spriteID)
                    nbDiamond++;
            }
        }
    }

    /**
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the sprite
     */
    @Override
    public Sprites getSprite(int x, int y) {
        return this.sprites[y][x];
    }

    /**
     *
     * @param spriteID the sprite ID
     * @param x the x coordinate
     * @param y the y coordinate
     * @param spritePack the image spritepack.png (different textures)
     */
    @Override
    public void setSprite(int spriteID, int x, int y, BufferedImage spritePack) {
        convertNumToSprite(spriteID, x, y);
        rebuildMap(spriteID, x, y, spritePack);
    }

    /**
     *
     * @param spriteID the sprite ID
     * @param x the x coordinate
     * @param y the y coordinate
     * @param spritePack the sprites texture pack given to us
     */
    private void rebuildMap(int spriteID, int x, int y, BufferedImage spritePack) {
        Graphics g = this.getImage().getGraphics();

        int xT = spriteID % 12 * 16;
        int yT = spriteID/ 12 * 16;
        g.drawImage(spritePack.getSubimage(xT, yT, 16, 16), x * 16, y * 16, null);
    }

    /**
     * @return BufferedImage
     */
    @Override
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @param image the image
     */
    @Override
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * @return ISprite[][]
     */
    @Override
    public ISprite[][] getSprites() {
        return sprites;
    }

    /**
     * @return int
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * @return int
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * @param spriteID the sprite ID
     * @param x the x coordinate
     * @param y the y coordinate
     */
    private void convertNumToSprite(int spriteID, int x, int y) {
        switch (spriteID) {
            case Diamond.spriteID:
                sprites[y][x] = new Diamond();
                break;

            case Dirt.spriteID:
                sprites[y][x] = new Dirt();
                break;

            case Rock.spriteID:
                sprites[y][x] = new Rock();
                break;

            case Wall.spriteID:
                sprites[y][x] = new Wall();
                break;

            case Exit.spriteID:
                sprites[y][x] = new Exit();
                break;

            case Background.spriteID:
                sprites[y][x] = new Background();
                break;

            case Enemy.spriteID:
                sprites[y][x] = new Enemy();
                break;
        }
    }

    /**
     * @return the score
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * @param score the score
     */
    @Override
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the diamond number
     */
    @Override
    public int getNbDiamond() {
        return nbDiamond;
    }
}