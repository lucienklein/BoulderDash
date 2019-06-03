package model;

import model.Entities.Rock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author TRISTAN
 * test class for the rock
 */
public class RockTest {

    private Rock rockUnderTest;

    /**
     * setup method (test rock creation)
     * @throws Exception exception thrown if the object isn't instantiated correctly
     */
    @Before
    public void setUp()throws Exception {
        rockUnderTest = new Rock();
    }

    @Test
    public void testIsFallable() {
        // Setup

        // Run the test
        final boolean result = rockUnderTest.isFallable();

        // Verify the results
        assertTrue(result);
    }
}
