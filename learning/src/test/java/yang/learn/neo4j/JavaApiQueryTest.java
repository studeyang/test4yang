package yang.learn.neo4j;

import org.junit.Before;
import org.junit.Test;

public class JavaApiQueryTest {

    private JavaApiQuery javaApiQuery;

    @Before
    public void before() {
        javaApiQuery = new JavaApiQuery();
    }

    @Test
    public void test_query() {
        javaApiQuery.query(21, "ACTED_IN");
    }

}
