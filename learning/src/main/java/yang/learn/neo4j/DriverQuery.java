package yang.learn.neo4j;

import org.neo4j.driver.v1.*;

public class DriverQuery {

    private static final String URI = "bolt://localhost:7687";

    private static final String USERNAME = "neo4j";

    private static final String PASSWORD = "123456";

    private Driver driver;

    public DriverQuery() {
        driver = GraphDatabase.driver(URI, AuthTokens.basic(USERNAME, PASSWORD));
    }

    public StatementResult query(String cql) {
        try(Session session = driver.session();
            Transaction tx = session.beginTransaction()) {
            StatementResult result = tx.run(cql);
            tx.success();
            return result;
        }
    }

    public void close() {
        driver.close();
    }

}
