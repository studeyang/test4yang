package neo4j;

import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcQueryTest {

    private JdbcQuery jdbcQuery;

    @Before
    public void before() throws SQLException {
        jdbcQuery = new JdbcQuery();
    }

    @Test
    public void test_query() throws SQLException {
        ResultSet rs = jdbcQuery.query("MATCH (n:Person {name : 'Noah Wyle'})-[r:ACTED_IN]-(m) return m.title");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

}
