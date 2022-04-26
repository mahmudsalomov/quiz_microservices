package uz.maniac4j.gatewayserver;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/api/organization/**")
//                        .uri("lb://ORGANIZATION-SERVICE"))
//                .route(p -> p
//                        .path("/api/participant/**")
//                        .uri("lb://PARTICIPANT-SERVICE"))
//
//                .route(p -> p
//                        .path("/api/quiz/**")
//                        .uri("lb://QUIZ-SERVICE"))
//
//                .build();
//    }


//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("quiz-service", r -> r.path("/api/quiz/**")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("myCircuitBreaker").setFallbackUri("forward:/quizFallback"))
//                                .rewritePath("/api/quiz/**", "/quizFallback"))
//                        .uri("lb://QUIZ-SERVICE"))
//
////                .route("circuitbreaker_route", r -> r.path("/consumingServiceEndpoint")
////                        .filters(f -> f.circuitBreaker(c -> c.setName("myCircuitBreaker").setFallbackUri("forward:/inCaseOfFailureUseThis"))
////                                .rewritePath("/consumingServiceEndpoint", "/backingServiceEndpoint"))
////                        .uri("lb://backing-service:8088"))
////
////                .route("circuitbreaker_route", r -> r.path("/consumingServiceEndpoint")
////                        .filters(f -> f.circuitBreaker(c -> c.setName("myCircuitBreaker").setFallbackUri("forward:/inCaseOfFailureUseThis"))
////                                .rewritePath("/consumingServiceEndpoint", "/backingServiceEndpoint"))
////                        .uri("lb://backing-service:8088"))
//
//                .build();
//
//    }
}
