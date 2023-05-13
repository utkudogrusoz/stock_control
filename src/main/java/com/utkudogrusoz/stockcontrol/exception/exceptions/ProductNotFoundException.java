package com.utkudogrusoz.stockcontrol.exception.exceptions;

import com.utkudogrusoz.stockcontrol.enums.LanguageEnum;
import com.utkudogrusoz.stockcontrol.exception.enums.IFrontlineMessageCode;
import com.utkudogrusoz.stockcontrol.exception.utilities.FrontlineMessageUtility;

public class ProductNotFoundException extends RuntimeException{
    private final LanguageEnum languageEnum;
    private final IFrontlineMessageCode frontlineMessageCode;

    public ProductNotFoundException(LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotFoundException(String message, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(FrontlineMessageUtility.getFrontlineMessage(languageEnum,frontlineMessageCode));
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotFoundException(String message, Throwable cause, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(message, cause);
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotFoundException(Throwable cause, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(cause);
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }
}
