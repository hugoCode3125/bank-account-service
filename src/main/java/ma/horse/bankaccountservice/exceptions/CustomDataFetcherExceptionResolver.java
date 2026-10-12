package ma.horse.bankaccountservice.exceptions;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CustomDataFetcherExceptionResolver implements DataFetcherExceptionResolver {
    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
        return null;
    }
}
