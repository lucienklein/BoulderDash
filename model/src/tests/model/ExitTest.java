package model;

import model.Entities.Exit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TRISTAN
 * test class for the exit
 */
public class ExitTest {
    private Exit test;

    /**
     * we create a test object
     * @throws Exception exception thrown if the object isn't instantiated correctly
     */
    @Before
    public void setUp() throws Exception {
        test = new Exit();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * test method to verify if the id is the good one
     * @throws Exception exception thrown if the id isn't the one supposed to be
     */
    @Test
    public void getID() throws Exception {
        final int expected = 6;
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