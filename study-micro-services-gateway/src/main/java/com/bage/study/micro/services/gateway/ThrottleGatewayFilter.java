/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bage.study.micro.services.gateway;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

/**
 * Sample throttling filter. See https://github.com/bbeck/token-bucket
 */
public class ThrottleGatewayFilter implements GatewayFilter {

	private static final Log log = LogFactory.getLog(ThrottleGatewayFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		String token = exchange.getRequest().getHeaders().getFirst("token");
		System.out.println(token);
		String first = exchange.getRequest().getQueryParams().getFirst("first");
		System.out.println(first);
//		TokenBucket tokenBucket = TokenBuckets.builder().withCapacity(capacity)
//				.withFixedIntervalRefillStrategy(refillTokens, refillPeriod, refillUnit)
//				.build();
//
//		// TODO: get a token bucket for a key
//		log.debug("TokenBucket capacity: " + tokenBucket.getCapacity());
//		boolean consumed = tokenBucket.tryConsume();
//		if (consumed) {
//			return chain.filter(exchange);
//		}
		exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
		return exchange.getResponse().setComplete();
	}

}