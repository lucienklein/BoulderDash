package model.Entities;

import model.Direction;
import model.IMap;
import model.IPlay;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity implements IPlay {

    /*the image*/
    private BufferedImage image;

    /*the constructor*/
    public Player() {
        this.setIsAlive(true);
        this.setX(16);
        this.setY(16);
        this.setDirection(Direction.DOWN);
        try {
            image = ImageIO.read(new File("images/player.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * the getter to know if the object is a player or not
     * @return boolean
     */
    @Override
    public boolean isPlayer() {
        return true;
    }

    /**
     * method to call the movement
     * @param map the map
     */
    @Override
    public void move(IMap map) {}

    /**
     * @return BufferedImage
     * method to use the image related to his movement
     * (left direction means left rockford)
     */
    @Override
    public BufferedImage getImage() {
        switch (direction) {
            case UP:
                return this.image.getSubimage(2 * 16, 5 * 16, 16, 16);

            case DOWN:
                return this.image.getSubimage(0 * 16, 5 * 16, 16, 16);

            case LEFT:
                return this.image.getSubimage(3 * 16, 5 * 16, 16, 16);

            case RIGHT:
                return this.image.getSubimage(1 * 16, 5 * 16, 16, 16);
        }
        return this.image;
    }
}
