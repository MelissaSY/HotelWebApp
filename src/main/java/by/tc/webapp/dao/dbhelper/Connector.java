package by.tc.webapp.dao.dbhelper;

import by.tc.webapp.dao.dbhelper.exception.ConnectorException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static final Connection connection;

    static {
        try {
            connection = createConnection();
        } catch (ConnectorException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection createConnection() throws ConnectorException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("\"jdbc:mysql://localhost/hotel\", \"root\", \"password\")");
        } catch (SQLException e) {
            throw new ConnectorException(e.getMessage());
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }
}
