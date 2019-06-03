package model.dao;

import java.sql.*;

/**
 * @author Tristan
 * the class for the Database Connector
 */
final class DBConnector {

    /*
     The instance
     */
    private static DBConnector instance;

    /*
     The login.
     */
    private static String user = "root";

    /*
     The password.
     */
    private static String password = "";

    /*
     The url.
     */
    private static String url = "jdbc:mysql://localhost/boulderdash?useSSL=false&serverTimezone=UTC";

    /*
     The connection.
     */
    private Connection connection;

    /*
     The statement.
     */
    private Statement statement;

    /*
     Instantiates a new DB connector
     */
    private DBConnector() {
        this.open();
    }

    /**
     * gets the instance of the database connector
     * @return  the instance
     */
    public static DBConnector getInstance() {
        if (instance == null) {
            setInstance(new DBConnector());
        }
        return instance;
    }

    /**
     * Sets up the instance
     * @param instance theinstance
     */
    private static void setInstance(final DBConnector instance) {
        DBConnector.instance = instance;
    }

    /**
     * Open the connection
     * @return the connection state (true or false)
     */
    private boolean open() {
        try {
            this.connection = DriverManager.getConnection(DBConnector.url, DBConnector.user,
                    DBConnector.password);
            this.statement = this.connection.createStatement();
            return true;
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Execute query
     * @param query the query
     * @return the result
     */
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prepare the query call
     * @param query the query
     * @return the statement
     */
    public CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute update
     * @param query the query
     * @return the int
     */
    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Gets the DB connection
     * @return the connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Sets the connection
     * @param connection the connection
     */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets the statement
     * @return the statement
     */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * Sets the statement
     * @param statement the statement
     */
    public void setStatement(final Statement statement) {
        this.statement = statement;
    }

}
