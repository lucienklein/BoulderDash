package model;

import model.Entities.Background;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TRISTAN
 * class to test the background initialization
 */
public class BackgroundTest {
    private Background test;

    /**
     * the setup method (instantiate a testing object)
     * @throws Exception the exception if the object cannot be instantiated
     */
    @Before
    public void setUp() throws Exception {
        test = new Background();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * the method to verify if the ID is the one set up for the background
     * @throws Exception the exception related to the fact if the ID isn't the good one
     */
    @Test
    public void getID() throws Exception {
        final int expected = 2;
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