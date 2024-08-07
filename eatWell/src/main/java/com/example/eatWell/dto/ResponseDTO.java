package com.example.eatWell.dto;




import lombok.Builder;
import lombok.Getter;
import lombok.Builder;

@Builder

public class ResponseDTO<T> {
    private String status;

    private String error;

    @Builder.Default
    private String message = "Success!";

    private T body;

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public T getBody() {
        return body;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBody(T body) {
        this.body = body;
    }


    @Getter(lazy = true)
    private final int statusCode = buildStatusCode();
    private int buildStatusCode() {
        return Integer.parseInt(this.status.split(" ")[0]);
    }
}


