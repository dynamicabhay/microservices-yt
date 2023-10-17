package com.apiGateway.service.ApiGateway.filter;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

	public static List<String> openApiRoutes = List.of(
			"/eureka",
			"/Eureka"
			);
	
	public  Predicate<ServerHttpRequest> isSecured =
			request -> openApiRoutes
						.stream()
						.noneMatch(uri -> request.getURI().getPath().contains(uri));
			
}
