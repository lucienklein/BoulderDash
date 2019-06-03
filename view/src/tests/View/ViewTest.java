package View;

import controller.IOrderPerformer;
import model.IEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import view.View;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.MockitoAnnotations.initMocks;
/**
 * @author Tristan
 * test class for the view
 */
public class ViewTest {

    @Mock
    private IOrderPerformer mockOrderPerformer;

    private View viewUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        viewUnderTest = new View(mockOrderPerformer);
    }

    @Test
    public void testDisplayMessage() {
        // Setup
        final String message = "message";

        // Run the test
        viewUnderTest.displayMessage(message);

        // Verify the results
    }

    @Test
    public void testDrawMap() {
        // Setup
        final BufferedImage image = null;

        // Run the test
        viewUnderTest.drawMap(image);

        // Verify the results
    }

    @Test
    public void testDrawEntities() {
        // Setup
        final ArrayList<IEntity> entities = new ArrayList<>(Arrays.asList());

        // Run the test
        viewUnderTest.drawEntities(entities);

        // Verify the results
    }

    @Test
    public void testCreateWindow() {
        // Setup
        final int width = 0;
        final int height = 0;

        // Run the test
        viewUnderTest.createWindow(width, height);

        // Verify the results
    }

    @Test
    public void testCloseWindow() {
        // Setup

        // Run the test
        viewUnderTest.closeWindow();

        // Verify the results
    }

    @Test
    public void testDrawScore() {
        // Setup
        final String score = "score";

        // Run the test
        viewUnderTest.drawScore(score);

        // Verify the results
    }
}
