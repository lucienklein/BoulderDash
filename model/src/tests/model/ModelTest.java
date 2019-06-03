package model;

import model.Map.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TRISTAN
 * test class for the model
 */
public class ModelTest {
private Map test;

    /**
     * method to create a test map to verify the model integrity
     * @throws Exception exception thrown if the map isn't correctly instantiated
     */
    @Before
    public void setUp() throws Exception {
        test = new Map("1,1,1,1,1,1");
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void readMap() throws Exception {
    }

    @Test
    public void addEntity() throws Exception {
    }

    @Test
    public void getEntities() throws Exception {
    }

    @Test
    public void getMap() throws Exception {
    }

    @Test
    public void getPlayer() throws Exception {
    }

    @Test
    public void getSpritePack() throws Exception {
    }

}