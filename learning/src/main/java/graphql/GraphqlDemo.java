package graphql;

import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static graphql.Scalars.GraphQLString;

/**
 * GraphQL
 *
 * @author yangll
 * @date 20191010
 */
public class GraphqlDemo {

    public static void main(String[] args) {
        // GraphQL Schema
        GraphQLObjectType queryType = createGraphqlSchema();
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
        // GraphQL服务
        GraphQL build = GraphQL.newGraphQL(schema).build();
        // 请求参数
        ExecutionResult executionResult = build.execute("query { hero { name } }");
        // 处理结果
        System.out.println(executionResult.getData().toString());

    }

    private static GraphQLObjectType createGraphqlSchema() {
        return GraphQLObjectType.newObject()
                .name("Ci")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("product_number").type(GraphQLString).dataFetcher(dataFetcher()))
                .build();
    }

    private static DataFetcher dataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> response = new HashMap<> (2);
            response.put("data", "test");
            return new DataFetcherResult(response.get("data"), new ArrayList<>());
        };
    }

    private static GraphQLSchema runTimeWiring() {
        File schemaFile = new File(GraphqlDemo.class.getClassLoader().getResource("myschema.graphqls").getPath());

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFile);

        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring().build();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
    }


}
