package com.apiGateway.service.ApiGateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Service;

import com.apiGateway.service.ApiGateway.jwtUtils.JwtUtil;

@Service
public class RequestValidationFilter extends AbstractGatewayFilterFactory<RequestValidationFilter.Config> {

	@Autowired
	public RouteValidator validator;
	
	@Autowired
	public JwtUtil jwtHelper;
	
	public RequestValidationFilter() {
		super(Config.class);
	}
	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange,chain) -> {
			
			if(validator.isSecured.test(exchange.getRequest())) {
				System.out.println("request is : " + exchange.getRequest());
				
				if(exchange.getRequest().getHeaders().get("Authorization")==null) {
					throw new RuntimeException("Authorization header not found !!");
				}
				
				String authHeader = exchange.getRequest().getHeaders().get("Authorization").get(0);
				if(authHeader != null && authHeader.startsWith("Bearer")) {
				String token = authHeader.substring(7);
				try {
					if(jwtHelper.validateToken(token)) {
						
					};
				}catch(Exception e) {
					throw new RuntimeException("validation failed !!");
				}
				}else {
					throw new RuntimeException("Authorization header is null or Bearer not present");
				}
				
				
			}
		return chain.filter(exchange);
		}
		);
	}
	
	public static class Config {

    }

	

}
