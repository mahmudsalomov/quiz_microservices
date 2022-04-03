package uz.maniac4j.participantservice.payload;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public class ApiResponseObject<T>extends ApiResponse<T> {
    private T object;


    public ApiResponseObject(T object) {
        this.object = object;
    }

    public ApiResponseObject(String message, boolean success, T object) {
        super(message, success);
        this.object = object;
    }

    public ApiResponseObject(HttpStatus status, T object) {
        super(status);
        this.object = object;
    }

    public ApiResponseObject(String message, HttpStatus status, T object) {
        super(message,status);
        this.object = object;
    }

    public ApiResponseObject(String message, boolean success, HttpStatus status, T object) {
        super(message, success,status);
        this.object = object;
    }

    public ApiResponseObject(String message, boolean success, HttpStatus status, long totalElements, long totalPages, long page, T object) {
        super(message, success, status, totalElements, totalPages, page);
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ApiResponseObject{" +
                "message='" + getMessage() + '\'' +
                ", success=" + isSuccess() +
                ", status=" + getStatus() +
                ", object=" + object +
                '}';
    }
    @Override
    public HttpEntity<?> response() {
        return ResponseEntity.status(org.springframework.http.HttpStatus.valueOf(getStatus().getCode())).body(this);
    }

    @Override
    public ApiResponseObject<T> get() {
        return this;
    }
}
