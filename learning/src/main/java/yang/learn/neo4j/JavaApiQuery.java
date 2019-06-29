package yang.learn.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.graphdb.traversal.Uniqueness;

import java.io.File;
import java.util.Iterator;

public class JavaApiQuery {

    private static final String DBPATH = "D:/Program Files/Neo4j CE 3.2.0/graphdb";

    private GraphDatabaseService graphDatabaseService;

    public JavaApiQuery() {
        graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(new File(DBPATH));
    }

    public Traverser query(long id, String relationShip) {
        try (Transaction tx = graphDatabaseService.beginTx()) {
            Traverser traverser = graphDatabaseService.traversalDescription()
                    .depthFirst()
                    .uniqueness(Uniqueness.RELATIONSHIP_PATH)
                    .relationships(RelationshipType.withName(relationShip))
                    .evaluator(Evaluators.atDepth(2))
                    .traverse(graphDatabaseService.getNodeById(id));
            Iterator iterable = traverser.iterator();
            while (iterable.hasNext()) {
                System.out.println(iterable.next());
            }
            tx.success();
            return traverser;
        }
    }

}
