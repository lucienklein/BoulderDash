package model.Entities;

import model.Direction;
import model.IEntity;

import java.awt.image.BufferedImage;

/**
 * @author Lucien
 * the abstract class for the entities
 */
public abstract class Entity implements IEntity {
    /*x coordinate*/
    protected int x;

    /*y coordinate*/
    protected int y;

    /*state if the entity is alive*/
    protected boolean isAlive;

    /*the direction of the entity*/
    protected Direction direction;

    /*default constructor*/
    public Entity() {
    }

    /**
     * parametric constructor
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
/*
getters and setters
 */
    /**
     * @return int
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return int
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @param x the x coordinate
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y coordinate
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return boolean
     */
    @Override
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * @param isAlive the state of the character
     */
    @Override
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * @param direction the direction of the character
     */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return Direction
     */
    @Override
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return BufferedImage
     */
    @Override
    public abstract BufferedImage getImage();
}
