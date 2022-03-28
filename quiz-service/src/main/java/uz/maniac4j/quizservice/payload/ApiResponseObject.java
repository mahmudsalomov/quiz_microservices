package uz.maniac4j.quizservice.payload;


public class ApiResponseObject<T>extends ApiResponse {
    private T object;

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

    public Object getObject() {
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
}
