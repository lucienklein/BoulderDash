package View;

import controller.IOrderPerformer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import view.EventPerformer;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Tristan
 * test class for the eventperformer
 */
public class EventPerformerTest {
    /**
     * orderperformer attribute
     */
    @Mock
    private IOrderPerformer mockOrderPerformer;
    /**
     * eventperformer attribute
     */
    private EventPerformer eventPerformerUnderTest;

    /**
     * method to create a new orderperformer
     * @throws Exception exception sent if the order performer isn't correctly created
     */
    @Before
    public void setUp() throws Exception{
        initMocks(this);
        eventPerformerUnderTest = new EventPerformer(mockOrderPerformer);
    }


    /**
     * eventperform testing method
     */
    @Test
    public void testEventPerform() {
        // Setup
        final KeyEvent keyCode = null;

        // Run the test
        eventPerformerUnderTest.eventPerform(keyCode);

        // Verify the results
        verify(mockOrderPerformer).orderPerform(null);
    }
}
