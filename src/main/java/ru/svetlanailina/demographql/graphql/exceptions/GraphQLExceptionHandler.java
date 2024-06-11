package ru.svetlanailina.demographql.graphql.exceptions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;

import java.util.NoSuchElementException;

public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof NoSuchElementException) {
            return GraphqlErrorBuilder.newError(env)
                    .message(ex.getMessage())
                    .build();
        } else {
            return GraphqlErrorBuilder.newError(env)
                    .message("Internal server error: " + ex.getMessage())
                    .build();
        }
    }
}
