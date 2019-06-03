package model;

import model.Entities.Player;
import model.IMap;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author TRISTAN
 * test class for the player
 */
public class PlayerTest {

    private Player playerUnderTest;

    @Before
    public void setUp() {
        playerUnderTest = new Player();
    }

    @Test
    public void testIsPlayer() {
        // Setup

        // Run the test
        final boolean result = playerUnderTest.isPlayer();

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testMove() {
        // Setup
        final IMap map = null;

        // Run the test
        playerUnderTest.move(map);

        // Verify the results
    }


}
