package com.utkudogrusoz.stockcontrol.enums;

import com.utkudogrusoz.stockcontrol.exception.enums.IFrontlineMessageCode;

public enum FrontlineMessageCodes implements IFrontlineMessageCode {
    OK(1000),
    ERROR(1001),
    SUCCESS(1002),
    PRODUCT_NOT_CREATED_EXCEPTION(1500),
    PRODUCT_CREATED(1501),
    PRODUCT_NOT_FOUND_EXCEPTION(1500);

    private final int value;

    FrontlineMessageCodes(int value) {
        this.value = value;
    }

    ;

    @Override
    public int getFrontlineMessageCode() {
        return value;
    }
}
