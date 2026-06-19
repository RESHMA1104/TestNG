package com.tests;

import java.util.HashMap;
import java.util.Map;

public class CalculatorLocators {

    public final String digit1;
    public final String plus;
    public final String digit2;
    public final String equal;
    public final String resultField;

    public CalculatorLocators(String digit1, String plus, String digit2, String equal, String resultField) {
        this.digit1 = digit1;
        this.plus = plus;
        this.digit2 = digit2;
        this.equal = equal;
        this.resultField = resultField;
    }

    private static final Map<String, CalculatorLocators> LOCATORS_BY_UDID = new HashMap<>();

    static {
    	
        LOCATORS_BY_UDID.put("96483105520006T", new CalculatorLocators(
                "com.vivo.calculator:id/digit1",
                "com.vivo.calculator:id/plus",
                "com.vivo.calculator:id/digit2",
                "com.vivo.calculator:id/equal",
                "com.vivo.calculator:id/input_edit"
        ));

        LOCATORS_BY_UDID.put("10BECZ0BR000549", new CalculatorLocators(
                "com.android.bbkcalculator:id/digit_1",
                "com.android.bbkcalculator:id/op_add",
                "com.android.bbkcalculator:id/digit_2",
                "com.android.bbkcalculator:id/eq",
                "com.android.bbkcalculator:id/result"
        ));
    }

    public static CalculatorLocators forDevice(String udid) {
        CalculatorLocators locators = LOCATORS_BY_UDID.get(udid);
        if (locators == null) {
            throw new IllegalArgumentException("No locators configured for device: " + udid
                    + ". Add an entry in CalculatorLocators.LOCATORS_BY_UDID.");
        }
        return locators;
    }
}