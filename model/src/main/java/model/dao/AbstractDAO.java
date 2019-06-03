package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;

/**
 * @author Tristan
 * The class with the methods for the DAO pattern
 */
public abstract class AbstractDAO {

    /**
     * Execute query.
     *
     * @param query the query
     * @return the result set
     */
    protected static ResultSet executeQuery(final String query) {
        return DBConnector.getInstance().executeQuery(query);
    }

    /**
     * Execute update.
     * @param query the query
     * @return int
     */
    protected static int executeUpdate(final String query) {
        return DBConnector.getInstance().executeUpdate(query);
    }

    /**
     * Prepare the query call
     *
     * @param query the query
     * @return the callable statement
     */
    protected static CallableStatement prepareCall(final String query) {
        return DBConnector.getInstance().prepareCall(query);
    }
}
