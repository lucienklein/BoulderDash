package model;

import model.Entities.Diamond;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author TRISTAN
 * class to test the diamond instantiation
 */
public class DiamondTest {
    private Diamond test;

    /**
     * the method to setup the object instantiation (we create a new testing object)
     * @throws Exception the excpetion thrown if the object isn't correctly instantiated
     */
    @Before
    public void setUp() throws Exception {
        test = new Diamond();
   }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * the method to verify if the diamond ID is the one we set up in the diamond class
     * @throws Exception the exception related to the fact that the ID is different that the one it should be
     */
    @Test
    public void getID() throws Exception {
final int expected = 4;
assertEquals(expected, test.getID());
    }

    @Test
    public void testIsFallable() {
        // Setup

        // Run the test
        final boolean result = test.isFallable();

        // Verify the results
        assertTrue(result);
    }
}