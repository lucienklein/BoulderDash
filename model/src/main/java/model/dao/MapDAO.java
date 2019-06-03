package model.dao;

import java.sql.*;

/**
 * @author Tristan
 * The class to call the map stored in the DB
 */
public abstract class MapDAO extends AbstractDAO {

    /*
     Constructor
     */
    public MapDAO() {}

    /**
     * Reads the map from the DB
     * @param id the id of the map
     * @return the map code
     * @throws SQLException
     * It will read a stored procedure (we don't want sql queries in our code)
     */
    public static String readMap(int id) throws SQLException {

        final CallableStatement callStatementMapCode = prepareCall("{call callMap(?)}");
        String mapCode = "";
        callStatementMapCode.setInt(1, id);
        if (callStatementMapCode.execute()) {
            final ResultSet result = callStatementMapCode.getResultSet();
            if (result.first()) {
                mapCode = result.getString(1);
            }
            result.close();
        }
        return mapCode;
    }
}
