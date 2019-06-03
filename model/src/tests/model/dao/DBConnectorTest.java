package model.dao;

import org.junit.Before;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author TRISTAN
 * testing class for the DB connector
 */
public class DBConnectorTest {

    private DBConnector dbConnectorUnderTest;


    @Before
    public void setUp() {
        dbConnectorUnderTest = DBConnector.getInstance();
    }


    @Test
    public void testExecuteQuery() {
        // Setup
        final String query = "query";
        final ResultSet expectedResult = null;

        // Run the test
        final ResultSet result = dbConnectorUnderTest.executeQuery(query);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testPrepareCall() {
        // Setup
        final String query = "query";
        final CallableStatement expectedResult = null;

        // Run the test
        final CallableStatement result = dbConnectorUnderTest.prepareCall(query);

        // Verify the results
        assertNotEquals(expectedResult, result);
    }


    @Test
    public void testExecuteUpdate() {
        // Setup
        final String query = "query";
        final int expectedResult = 0;

        // Run the test
        final int result = dbConnectorUnderTest.executeUpdate(query);

        // Verify the results
        assertEquals(expectedResult, result);
    }


    @Test
    public void testGetInstance() {
        // Setup
        final DBConnector expectedResult = null;

        // Run the test
        final DBConnector result = DBConnector.getInstance();

        // Verify the results
        assertNotEquals(expectedResult, result);
    }
}
