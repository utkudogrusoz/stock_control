package com.utkudogrusoz.stockcontrol.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public class InternalApiResponse<T> {
    FrontlineMessage frontlineMessage;
    T payload;
    boolean hasError;
    List<String> errorMessage;
    HttpStatus httpStatus;

    public InternalApiResponse() {
    }

    public InternalApiResponse(FrontlineMessage frontlineMessage, T payload, boolean hasError, List<String> errorMessage, HttpStatus httpStatus) {
        this.frontlineMessage = frontlineMessage;
        this.payload = payload;
        this.hasError = hasError;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public FrontlineMessage getFrontlineMessage() {
        return frontlineMessage;
    }

    public void setFrontlineMessage(FrontlineMessage frontlineMessage) {
        this.frontlineMessage = frontlineMessage;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public List<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public static InternalApiResponseBuilder builder(){
        return new InternalApiResponseBuilder();
    }

    public static class InternalApiResponseBuilder<T>{
        FrontlineMessage frontlineMessage;
        T payload;
        boolean hasError;
        List<String> errorMessage;
        HttpStatus httpStatus;

        public InternalApiResponseBuilder() {
        }


        public FrontlineMessage getFrontlineMessage() {
            return frontlineMessage;
        }
        public InternalApiResponseBuilder<T> frontlineMessage(FrontlineMessage frontlineMessage){
            this.frontlineMessage=frontlineMessage;
            return this;
        }
        public InternalApiResponseBuilder<T> payload(T payload){
            this.payload=payload;
            return this;
        }
        public InternalApiResponseBuilder<T> hasError(boolean hasError){
            this.hasError=hasError;
            return this;
        }
        public InternalApiResponseBuilder<T> errorMessage(List<String> errorMessage){
            this.errorMessage=errorMessage;
            return this;
        }
        public InternalApiResponseBuilder<T> httpStatus(HttpStatus httpStatus){
            this.httpStatus=httpStatus;
            return this;
        }

        public T getPayload() {
            return payload;
        }

        public boolean isHasError() {
            return hasError;
        }

        public List<String> getErrorMessage() {
            return errorMessage;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }

        public InternalApiResponse<T> build() {
            return new InternalApiResponse<T>(frontlineMessage, payload, hasError, errorMessage,httpStatus);
        }
    }
}
