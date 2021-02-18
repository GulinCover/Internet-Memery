package com.gulincover.gateway.config.gatewayPredicate;

import com.gulincover.gateway.service.AuthenticationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GlobalFilterConfig implements GlobalFilter, Ordered {
    @Autowired
    private AuthenticationCodeService authenticationCodeService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        List<String> gulinCoverAuthenticationCode = headers.get("GulinCoverAuthenticationCode");
        if (gulinCoverAuthenticationCode != null) {
            if (authenticationCodeService.isValid(gulinCoverAuthenticationCode.get(0)))
                return chain.filter(exchange);
            else {
                ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> {
                    httpHeaders.set("GulinCoverAuthenticationCode", authenticationCodeService.anonymousAccess());
                }).build();
                return chain.filter(exchange.mutate().request(request).build());
            }
        } else {
            ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> {
                httpHeaders.add("GulinCoverAuthenticationCode", authenticationCodeService.anonymousAccess());
            }).build();
            return chain.filter(exchange.mutate().request(request).build());
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
