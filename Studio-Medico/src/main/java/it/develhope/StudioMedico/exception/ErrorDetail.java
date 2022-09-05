package it.develhope.StudioMedico.exception;

public class ErrorDetail {

    private Integer status;
    private String message;

    public ErrorDetail() {
    }

    public ErrorDetail(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}




