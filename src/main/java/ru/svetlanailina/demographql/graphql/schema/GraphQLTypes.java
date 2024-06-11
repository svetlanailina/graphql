package ru.svetlanailina.demographql.graphql.schema;

import graphql.schema.GraphQLObjectType;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;
import static graphql.Scalars.*;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;

public class GraphQLTypes {
    public static final GraphQLObjectType UserType = newObject()
            .name("User")
            .field(newFieldDefinition()
                    .name("id")
                    .type(GraphQLString))
            .field(newFieldDefinition()
                    .name("name")
                    .type(GraphQLString))
            .field(newFieldDefinition()
                    .name("age")
                    .type(GraphQLInt))
            .build();
}
