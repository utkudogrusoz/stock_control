package com.utkudogrusoz.stockcontrol.exception.utilities;

import com.utkudogrusoz.stockcontrol.enums.FrontlineMessageCodes;
import com.utkudogrusoz.stockcontrol.exception.exceptions.ProductNotCreatedException;
import com.utkudogrusoz.stockcontrol.exception.exceptions.ProductNotFoundException;
import com.utkudogrusoz.stockcontrol.response.FrontlineMessage;
import com.utkudogrusoz.stockcontrol.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception){
      return InternalApiResponse.<String>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility.getFrontlineMessage(exception.getLanguageEnum(), FrontlineMessageCodes.ERROR))
                        .description(FrontlineMessageUtility.getFrontlineMessage(exception.getLanguageEnum(),exception.getFrontlineMessageCode()))
                .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage()))
                .build();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public InternalApiResponse<String> handleProductNotFoundException(ProductNotCreatedException exception){
        return InternalApiResponse.<String>builder()
                .frontlineMessage(FrontlineMessage.builder()
                        .title(FrontlineMessageUtility.getFrontlineMessage(exception.getLanguageEnum(), FrontlineMessageCodes.ERROR))
                        .description(FrontlineMessageUtility.getFrontlineMessage(exception.getLanguageEnum(),exception.getFrontlineMessageCode()))
                        .build())
                .httpStatus(HttpStatus.NOT_FOUND)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage()))
                .build();
    }
}
