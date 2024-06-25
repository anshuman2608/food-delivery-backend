package com.example.eatWell.dto.response;


import lombok.Builder;
import lombok.Getter;

@Builder
//@ApiModel(description = "Represents an Response Wrapper Object")
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

    //@ApiModelProperty(notes = "HTTP Status Code of the response")
    @Getter(lazy = true)
    private final int statusCode = buildStatusCode();
    private int buildStatusCode() {
        return Integer.parseInt(this.status.split(" ")[0]);
    }
}
