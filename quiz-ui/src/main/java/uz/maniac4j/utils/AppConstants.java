package uz.maniac4j.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {
    @Value("${base.url}")
    public String BASE_URL;

    @Value("${gateway.api.key.name}")
    public String keyName;

    @Value("${gateway.api.key}")
    public String key;

    public String BASE_URL_ORGANIZATION(){
        return BASE_URL+"/organization";
    }

    public String BASE_URL_QUIZ(){
        return BASE_URL+"/quiz";
    }

    public String BASE_URL_PARTICIPANT(){
        return BASE_URL+"/participant";
    }

    public HttpEntity<String> getHeader(){
        final HttpHeaders headers = new HttpHeaders();
        headers.set(keyName,key);
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        return entity;
    }
}
