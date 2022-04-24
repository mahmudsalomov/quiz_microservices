package uz.maniac4j.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {
    @Value("${base.url}")
    public static String BASE_URL;

    public static String BASE_URL_ORGANIZATION(){
        return BASE_URL+"/organization";
    }

    public static String BASE_URL_QUIZ(){
        return BASE_URL+"/quiz";
    }

    public static String BASE_URL_PARTICIPANT(){
        return BASE_URL+"/participant";
    }
}
