package View;

import model.IEntity;
import org.junit.Before;
import org.junit.Test;
import view.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * @author Tristan
 * test class for the gamepanel
 */
public class GamePanelTest {

    private GamePanel gamePanelUnderTest;

    @Before
    public void setUp() {
        gamePanelUnderTest = new GamePanel();
    }

    @Test
    public void testUpdate() {
        // Setup
        final Observable o = null;
        final Object arg = null;

        // Run the test
        gamePanelUnderTest.update(o, arg);

        // Verify the results
    }

    @Test
    public void testPaintComponent() {
        // Setup
        final Graphics graphics = null;

        // Run the test
        gamePanelUnderTest.paintComponent(graphics);

        // Verify the results
    }

    @Test
    public void testSetImageMap() {
        // Setup
        final BufferedImage imageMap = null;

        // Run the test
        gamePanelUnderTest.setImageMap(imageMap);

        // Verify the results
    }

    @Test
    public void testSetEntities() {
        // Setup
        final ArrayList<IEntity> entities = new ArrayList<>(Arrays.asList());

        // Run the test
        gamePanelUnderTest.setEntities(entities);

        // Verify the results
    }

    @Test
    public void testSetScore() {
        // Setup
        final String score = "score";

        // Run the test
        gamePanelUnderTest.setScore(score);

        // Verify the results
    }
}
