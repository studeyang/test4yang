package neo4j;

import org.junit.Before;
import org.junit.Test;
import org.neo4j.driver.v1.StatementResult;

public class DriverQueryTest {

    private DriverQuery driverQuery;

    @Before
    public void before() {
        driverQuery = new DriverQuery();
    }

    @Test
    public void test_query() {
        StatementResult result = driverQuery.query("MATCH (n:Person {name : 'Noah Wyle'})-[r:ACTED_IN]-(m) return m.title");
        while (result.hasNext()) {
            System.out.println(result.next().asMap());
        }
//        driverQuery.close();
    }

}
