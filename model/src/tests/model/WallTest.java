package model;

import model.Entities.Wall;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author TRISTAN
 * test class for the wall
 */
public class WallTest {

    private Wall wallUnderTest;

    /**
     * test wall creation
     * @throws Exception exception thrown if the wall isn't instantiated correctly
     */
    @Before
    public void setUp()throws Exception {
        wallUnderTest = new Wall();
    }

    @Test
    public void testIsFallable() {
        // Setup

        // Run the test
        final boolean result = wallUnderTest.isFallable();

        // Verify the results
        assertFalse(result);
    }
}
