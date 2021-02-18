package com.gulincover.gateway.config.gatewayPredicate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Predicate;

//@Component
public class TestRoutePredicateFactory extends AbstractRoutePredicateFactory<TestRoutePredicateFactory.Config> {
    public TestRoutePredicateFactory() {
        super(TestRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return null;
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                Flux<DataBuffer> body = serverWebExchange.getRequest().getBody();

                return false;
            }
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config {
    }
}
