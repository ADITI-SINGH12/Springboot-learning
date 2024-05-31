package com.restAPIStudent.StudentRestAPI.exception;

public class StudentException {
    private int status;
    private String message;
    private long timestamps;

    public StudentException() {
    }

    public StudentException(int status, String message, long timestamps) {
        this.status = status;
        this.message = message;
        this.timestamps = timestamps;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(long timestamps) {
        this.timestamps = timestamps;
    }
}
