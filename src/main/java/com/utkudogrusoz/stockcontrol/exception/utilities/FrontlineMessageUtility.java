package com.utkudogrusoz.stockcontrol.exception.utilities;

import com.utkudogrusoz.stockcontrol.enums.LanguageEnum;
import com.utkudogrusoz.stockcontrol.exception.enums.IFrontlineMessageCode;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class FrontlineMessageUtility {
    private static final String RESOURCE_BUNDLE_NAME="FrontlineMessage";
    private static final String SPECIAL_CHARACTER="__";
    public static String getFrontlineMessage(LanguageEnum languageEnum, IFrontlineMessageCode messageCode){
        String messageKey=null;
        try {
            Locale locale=new Locale(languageEnum.name());
            ResourceBundle resourceBundle=ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME,locale);
            messageKey=messageCode.getClass().getSimpleName()+SPECIAL_CHARACTER+messageCode;
            return resourceBundle.getString(messageKey);
        }catch (MissingResourceException missingResourceException){
            System.out.println("Friendly message not found for key: {},"+messageKey);
            return null;
        }
    }
}
