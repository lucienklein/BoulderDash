package model;

import model.Entities.Dirt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TRISTAN
 * the test class for the dirt
 */
public class DirtTest {
    private Dirt test;

    /**
     * the setup method where we instantiate a test object
     * @throws Exception the exception thrown if the the object isn't instanciated correctly
     */
    @Before
    public void setUp() throws Exception {
        test = new Dirt() ;
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * the method to verify that the sprite ID is the one for the dirt
     * @throws Exception the exception thrown if the id is different from the one it should be
     */
    @Test
    public void getID() throws Exception {
        final int expected = 1;
        assertEquals(expected, test.getID());
    }

}