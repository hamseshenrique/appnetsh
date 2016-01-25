package br.com.netshoes.dto;

/**
 * Created by hamseshenrique on 21/01/16.
 */
public class RetornoDTO {

    private String message;
    private String exception;
    private Boolean isSuccess;
    private Value value;

    public RetornoDTO(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
