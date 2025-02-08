package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    private static DatabaseConnectionPool dbConnectionPool = DatabaseConnectionPool.getInstance();

    public static PreparedStatement initializePreparedStatement(Connection connection, String query, boolean returnGeneratedKeys, Object... parameters) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);

        for (int index = 0; index < parameters.length; index++) {
            preparedStatement.setObject(index + 1, parameters[index]);
        }

        return preparedStatement;
    }

    public static Connection acquireConnection() throws SQLException {
        return dbConnectionPool.acquireConnection();
    }

    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            dbConnectionPool.releaseConnection(connection);
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        closeResultSet(resultSet);
        closeStatement(statement);
        releaseConnection(connection);
    }

    public static void closeAll(Statement statement, Connection connection) {
        closeStatement(statement);
        releaseConnection(connection);
    }
}
