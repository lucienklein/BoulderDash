package model;

import model.Entities.Enemy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TRISTAN
 * test class for the enemy
 */
public class EnemyTest {
    private Enemy test;

    /**
     * test object instantiation
     * @throws Exception exception thrown if the object isn't instantiated correctly
     */
    @Before
    public void setUp() throws Exception {
        test = new Enemy();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * method to test if the Id is the correct one
     * @throws Exception exception thrown if the id isn't the good one
     */
    @Test
    public void getID()throws Exception{
final int expected = 9;
assertEquals(expected,test.getID());

    }


    @Test
    public void testIsFallable() {
        // Setup

        // Run the test
        final boolean result = test.isFallable();

        // Verify the results
        assertFalse(result);
    }
}