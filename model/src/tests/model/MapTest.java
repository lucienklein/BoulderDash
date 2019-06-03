package model;

import model.Entities.Sprites;
import model.ISprite;
import model.Map.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;

/**
 * @author TRISTAN
 * test class for the map
 */
public class MapTest {

    private Map mapUnderTest;

    @Before
    public void setUp() {
        mapUnderTest = new Map("map");
    }

    @Test
    public void testGetSprite() {
        // Setup
        final int x = 0;
        final int y = 0;
        final Sprites expectedResult = null;

        // Run the test
        final Sprites result = mapUnderTest.getSprite(x, y);

        // Verify the results
        assertEquals(expectedResult, result);
    }


}
