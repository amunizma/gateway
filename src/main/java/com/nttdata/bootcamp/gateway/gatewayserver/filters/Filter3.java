package com.nttdata.bootcamp.gateway.gatewayserver.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;

import reactor.core.publisher.Mono;

@Component
public class Filter3 implements GlobalFilter, Ordered{
	
	 Logger logger = LoggerFactory.getLogger(Filter3.class);

	@Override
	public int getOrder() {

		return 3;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("third pre filter");
		return chain.filter(exchange).then(Mono.fromRunnable(() ->
			logger.info("third post filter")
		));
	}
	
	
	

}
