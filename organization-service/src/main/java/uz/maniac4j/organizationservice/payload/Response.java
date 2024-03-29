package uz.maniac4j.organizationservice.payload;

import org.springframework.http.HttpEntity;

public interface Response<T> {
    boolean isSuccess();
    String getMessage();
    HttpEntity<?> response();
}
