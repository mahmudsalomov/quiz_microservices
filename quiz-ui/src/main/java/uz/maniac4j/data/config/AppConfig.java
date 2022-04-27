package uz.maniac4j.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.utils.AppConstants;

@Configuration
public class AppConfig {

    @Autowired
    private AppConstants constants;

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        var httpRequestFactory=new HttpComponentsClientHttpRequestFactory();


        httpRequestFactory.setConnectTimeout(3000);
        return new RestTemplate(httpRequestFactory);
    }




}
