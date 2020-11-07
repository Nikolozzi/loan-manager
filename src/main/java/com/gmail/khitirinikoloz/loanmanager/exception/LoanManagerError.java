package com.gmail.khitirinikoloz.loanmanager.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class LoanManagerError {

    private String message;
    private String debugMessage;
    private LocalDateTime time;
    private HttpStatus status;

    public LoanManagerError() {
        this.time = LocalDateTime.now();
    }

    public LoanManagerError(HttpStatus status, String message, String debugMessage) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public LoanManagerError(HttpStatus status, Throwable e) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = e.getLocalizedMessage();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
