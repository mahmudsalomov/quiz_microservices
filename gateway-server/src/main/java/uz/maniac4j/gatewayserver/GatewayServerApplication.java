package uz.maniac4j.gatewayserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import uz.maniac4j.gatewayserver.config.RedisHashComponent;
import uz.maniac4j.gatewayserver.dto.ApiKey;
import uz.maniac4j.gatewayserver.uti.AppConstants;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
public class GatewayServerApplication {


    @Autowired
    private RedisHashComponent redisHashComponent;

    @PostConstruct
    public void initKeysToRedis() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("343C-ED0B-4137-B27E", Stream.of(AppConstants.ORGANIZATION_SERVICE_KEY,
                AppConstants.PARTICIPANT_SERVICE_KEY,AppConstants.QUIZ_SERVICE_KEY).collect(Collectors.toList())));
//        apiKeys.add(new ApiKey("FA48-EF0C-427E-8CCF", Stream.of(AppConstants.COURSE_SERVICE_KEY)
//                .collect(Collectors.toList())));
        List<Object> lists = redisHashComponent.hValues(AppConstants.RECORD_KEY);
        if (lists.isEmpty()) {
            apiKeys.forEach(k -> redisHashComponent.hSet(AppConstants.RECORD_KEY, k.getKey(), k));
        }
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/organization/**")
                        .filters(f->f.stripPrefix(2))
                        .uri("lb://ORGANIZATION-SERVICE"))
                .route(p -> p
                        .path("/api/participant/**")
                        .filters(f->f.stripPrefix(2))
                        .uri("lb://PARTICIPANT-SERVICE"))

                .route(p -> p
                        .path("/api/quiz/**")
                        .filters(f->f.stripPrefix(2))
                        .uri("lb://QUIZ-SERVICE"))

                .build();

//        return builder.routes()
//                .route(AppConstants.STUDENT_SERVICE_KEY,
//                        r -> r.path("/api/student-service/**")
//                                .filters(f -> f.stripPrefix(2)).uri("http://localhost:8081"))
//                .route(AppConstants.COURSE_SERVICE_KEY,
//                        r -> r.path("/api/course-service/**")
//                                .filters(f -> f.stripPrefix(2)).uri("http://localhost:8082"))
//                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


}
