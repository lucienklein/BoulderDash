package model.dao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * @author TRISTAN
 * testing class for the mapDAO class
 */
public class MapDAOTest {
    /**
     * the testing method for the map reading state (if it can read it or not)
     * @throws Exception the exception rejected if the map is'nt charged
     */
    @Test
    public void testReadMap() throws Exception {
        // Setup
        final int id = 0;
        final String expectedResult = "";
        // Run the test
        final String result = MapDAO.readMap(id);
        // Verify the results
        assertEquals(expectedResult, result);
    }

    /**
     * lethod to test if the exception is correctly thrown
     * @throws SQLException the exception rejected to see if the sql exception is correctly thrown
     */
    @Test
    public void testReadMap_ThrowsSQLException() throws SQLException {
        // Setup
        final int id = 0;

        // Run the test
        MapDAO.readMap(id);
    }
}
