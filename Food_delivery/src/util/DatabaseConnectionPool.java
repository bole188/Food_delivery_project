package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DatabaseConnectionPool {

    private String databaseUrl;
    private String dbUser;
    private String dbPassword;
    private int initialConnections;
    private int maxIdleConnections;
    private int maxTotalConnections;

    private int currentConnections;
    private List<Connection> availableConnections;
    private List<Connection> activeConnections;

    private static DatabaseConnectionPool poolInstance;

    public static DatabaseConnectionPool getInstance() {
        if (poolInstance == null) {
            poolInstance = new DatabaseConnectionPool();
        }
        return poolInstance;
    }

    private DatabaseConnectionPool() {
        loadConfig();
        try {
            availableConnections = new ArrayList<>();
            activeConnections = new ArrayList<>();

            for (int i = 0; i < initialConnections; i++) {
                Connection conn = DriverManager.getConnection(databaseUrl, dbUser, dbPassword);
                availableConnections.add(conn);
            }
            currentConnections = initialConnections;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadConfig() {
        ResourceBundle configBundle = ResourceBundle.getBundle("util.config");
        databaseUrl = configBundle.getString("databaseUrl");
        dbUser = configBundle.getString("dbUser");
        dbPassword = configBundle.getString("dbPassword");
        initialConnections = Integer.parseInt(configBundle.getString("initialConnections"));
        maxIdleConnections = Integer.parseInt(configBundle.getString("maxIdleConnections"));
        maxTotalConnections = Integer.parseInt(configBundle.getString("maxTotalConnections"));
    }

    public synchronized Connection acquireConnection() throws SQLException {
        Connection conn = null;
        if (!availableConnections.isEmpty()) {
            conn = availableConnections.remove(0);
            activeConnections.add(conn);
        } else {
            if (currentConnections < maxTotalConnections) {
                conn = DriverManager.getConnection(databaseUrl, dbUser, dbPassword);
                activeConnections.add(conn);
                currentConnections++;
            } else {
                try {
                    wait();
                    conn = availableConnections.remove(0);
                    activeConnections.add(conn);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return conn;
    }

    public synchronized void releaseConnection(Connection conn) {
        if (conn == null) return;
        if (activeConnections.remove(conn)) {
            availableConnections.add(conn);
            while (availableConnections.size() > maxIdleConnections) {
                int lastIndex = availableConnections.size() - 1;
                Connection toClose = availableConnections.remove(lastIndex);
                try {
                    toClose.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            notify();
        }
    }
}
