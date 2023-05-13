package com.utkudogrusoz.stockcontrol.exception.exceptions;

import com.utkudogrusoz.stockcontrol.enums.FrontlineMessageCodes;
import com.utkudogrusoz.stockcontrol.enums.LanguageEnum;
import com.utkudogrusoz.stockcontrol.exception.enums.IFrontlineMessageCode;
import com.utkudogrusoz.stockcontrol.exception.utilities.FrontlineMessageUtility;

public class ProductNotCreatedException extends RuntimeException{
    private final LanguageEnum languageEnum;
    private final IFrontlineMessageCode frontlineMessageCode;

    public ProductNotCreatedException(LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotCreatedException(String message, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(FrontlineMessageUtility.getFrontlineMessage(languageEnum,frontlineMessageCode));
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotCreatedException(String message, Throwable cause, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(message, cause);
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
        System.out.println("ProductNotCreatedExceitpon -> message: {} developer message: {}"+FrontlineMessageUtility.getFrontlineMessage(languageEnum, frontlineMessageCode)+message);
    }

    public ProductNotCreatedException(Throwable cause, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(cause);
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public ProductNotCreatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, LanguageEnum languageEnum, IFrontlineMessageCode frontlineMessageCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.languageEnum = languageEnum;
        this.frontlineMessageCode = frontlineMessageCode;
    }

    public LanguageEnum getLanguageEnum() {
        return languageEnum;
    }

    public IFrontlineMessageCode getFrontlineMessageCode() {
        return frontlineMessageCode;
    }
}
