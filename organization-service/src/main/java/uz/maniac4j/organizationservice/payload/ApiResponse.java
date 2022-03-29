package uz.maniac4j.organizationservice.payload;


import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

public class ApiResponse implements Response{
    private String message;
    private boolean success;
    private HttpStatus status;
    private long totalElements;
    private long totalPages;
    private long page;

//    private static final AppAuthor author=new AppAuthor();

    public ApiResponse() {
    }

    public ApiResponse(HttpStatus status) {
        this.status = status;
        this.message = status.getDescription();
        this.success= status.getCode() < 400;
    }

    public ApiResponse(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
        this.success= status.getCode() < 400;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
        if (success) {
            this.status=HttpStatus.OK;
        } else {
            this.status=HttpStatus.Conflict;
        }
    }

    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public ApiResponse(String message, boolean success, HttpStatus status, long totalElements, long totalPages, long page) {
        this.message = message;
        this.success = success;
        this.status = status;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.page = page;
    }
    //    public static AppAuthor getAuthor() {
//        return author;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public HttpEntity<?> response(){
        return ResponseEntity.status(org.springframework.http.HttpStatus.valueOf(this.status.getCode())).body(this);
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public ApiResponse get(){
        return this;
    }
}
