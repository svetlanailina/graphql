package ru.svetlanailina.demographql.graphql.schema;

import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.svetlanailina.demographql.graphql.resolvers.UserResolver;

import static graphql.Scalars.GraphQLString;
/*
Провайдер схемы: Класс GraphQLProvider создает схему GraphQL и связывает запросы с резолверами.
 */

@Component
public class GraphQLProvider {
    private final UserResolver userResolver;

    public GraphQLProvider(UserResolver userResolver) {
        this.userResolver = userResolver;
    }

    @Bean
    public GraphQLSchema schema() {
        return GraphQLSchema.newSchema()
                .query(GraphQLObjectType.newObject()
                        .name("Query")
                        .field(field -> field
                                .name("user")
                                .type(GraphQLTypes.UserType)
                                .argument(arg -> arg.name("id").type(GraphQLString))
                                .dataFetcher(env -> userResolver.getUser(env.getArgument("id")))
                        )
                        .build())
                .build();
    }
}
