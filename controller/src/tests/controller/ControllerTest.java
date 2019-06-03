package controller;

import model.IModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author TRISTAN
 * testing class for the controller
 */
public class ControllerTest {

    @Mock
    private IModel model;

    private Controller controllerUnderTest;

    @Before
    public void setUp() {
        initMocks(this);
        controllerUnderTest = new Controller(model);
    }

    /**
     * the testing class for the start method
     * @throws Exception the exception rejected
     */
    @Test
    public void testStart() throws Exception {
        // Setup

        // Run the test
        controllerUnderTest.start();
        // Verify the results

    }

    /**
     *
     * @throws Exception the exception rejected for the testStart sql exception
     * means it tests if the sql exception is sent
     */
    @Test(expected = SQLException.class)
    public void testStart_ThrowsSQLException() throws Exception {
        // Setup

        // Run the test
        controllerUnderTest.start();
    }


    @Test
    public void testOrderPerform() {
        // Setup
        final IUserOrder userOrder = null;

        // Run the test
        controllerUnderTest.orderPerform(userOrder);

        // Verify the results
    }


    @Test
    public void testHit() {
        // Setup

        // Run the test
        controllerUnderTest.hit();

        // Verify the results
    }
}
