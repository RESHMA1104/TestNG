package com.tests;

import java.util.HashMap;
import java.util.Map;

public class DeviceConfig {

    public final String appPackage;
    public final String appActivity;

    public DeviceConfig(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }

    private static final Map<String, DeviceConfig> CONFIG_BY_UDID = new HashMap<>();

    static {
        CONFIG_BY_UDID.put("96483105520006T", new DeviceConfig(
                "com.vivo.calculator",
                "com.vivo.calculator.Calculator"
        ));

        CONFIG_BY_UDID.put("10BECZ0BR000549", new DeviceConfig(
                "com.android.bbkcalculator",
                "com.android.bbkcalculator.Calculator"
        ));
    }

    public static DeviceConfig forDevice(String udid) {
        DeviceConfig config = CONFIG_BY_UDID.get(udid);
        if (config == null) {
            throw new IllegalArgumentException("No app config for device: " + udid
                    + ". Add an entry in DeviceConfig.CONFIG_BY_UDID.");
        }
        return config;
    }
}