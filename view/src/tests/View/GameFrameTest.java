package View;

import model.IEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import view.GameFrame;
import view.IEventPerformer;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Tristan
 * test class for the gameframe
 */
public class GameFrameTest {

    @Mock
    private IEventPerformer mockEventPerformer;

    private GameFrame gameFrameUnderTest;

    /**
     * setup method where we instantiate an testing object
     */
    @Before
    public void setUp() {
        initMocks(this);
        gameFrameUnderTest = new GameFrame("title", mockEventPerformer, 0, 0);
    }

    /**
     * we test if the key is typed or not
     */
    @Test
    public void testKeyTyped() {
        // Setup
        final KeyEvent keyEvent = null;

        // Run the test
        gameFrameUnderTest.keyTyped(keyEvent);

        // Verify the results
    }

    /**
     * we test if the key is pressed or not
     */
    @Test
    public void testKeyPressed() {
        // Setup
        final KeyEvent keyEvent = null;

        // Run the test
        gameFrameUnderTest.keyPressed(keyEvent);

        // Verify the results
        verify(mockEventPerformer).eventPerform(null);
    }

    /**
     * we test if the key is released
     */
    @Test
    public void testKeyReleased() {
        // Setup
        final KeyEvent keyEvent = null;

        // Run the test
        gameFrameUnderTest.keyReleased(keyEvent);

        // Verify the results
    }

    /**
     * we test if the image is the map
     */
    @Test
    public void testSetImageMap() {
        // Setup
        final BufferedImage image = null;

        // Run the test
        gameFrameUnderTest.setImageMap(image);

        // Verify the results
    }

    @Test
    public void testSetEntities() {
        // Setup
        final ArrayList<IEntity> entities = new ArrayList<>(Arrays.asList());

        // Run the test
        gameFrameUnderTest.setEntities(entities);

        // Verify the results
    }

    @Test
    public void testSetScore() {
        // Setup
        final String score = "score";

        // Run the test
        gameFrameUnderTest.setScore(score);

        // Verify the results
    }
}
