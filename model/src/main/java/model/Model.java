package model;

import model.Map.Map;
import model.dao.MapDAO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Lucien
 * the class for the model
 */
public class Model implements IModel {

    /*the map*/
    private Map map;

    /*the map id*/
    private int map_id;

    /*the entities array*/
    private ArrayList<IEntity> entities;

    /*the model constructor*/
    public Model(int map_id) {
        try {
            this.map_id = map_id;
            map = new Map(this.readMap(this.map_id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        entities = new ArrayList<>();
    }

    /**
     * the method to call the readmap method
     * @param id the map id
     * @return MapDAO
     * @throws SQLException the exception
     */
    @Override
    public String readMap(int id) throws SQLException {
        return MapDAO.readMap(id);
    }

    /**
     * the ùethod to add an entity
     * @param entity the entity
     */
    @Override
    public void addEntity(IEntity entity) {
        entities.add(entity);
    }

    /**
     * the arraylist which contains the entities
     * @return ArrayList IEntity
     */
    @Override
    public ArrayList<IEntity> getEntities() {
        return entities;
    }

    /**
     * @return the map
     */
    public Map getMap() {
        return map;
    }

    public int getMapID() {
        return map_id;
    }

    /**
     * @return the entity player
     */
    @Override
    public IEntity getPlayer() {
        for (IEntity entity : entities) {
            if (entity.isPlayer())
                return entity;
        }
        return null;
    }

    /**
     * the method to read the image
     * @return BufferedImage
     */
    @Override
    public BufferedImage getSpritePack() {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File("images/spritepack.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

}
