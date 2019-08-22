package neo4j;

import java.sql.*;

public class JdbcQuery {

    private static final String URL = "jdbc:neo4j://172.23.22.172:7474";

    private static final String USERNAME = "neo4j";

    private static final String PASSWORD = "123456";

    private Connection connection;

    public JdbcQuery() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public ResultSet query(String cql) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            return statement.executeQuery(cql);
        }
    }

    public void close() throws SQLException {
        connection.close();
    }

}
