package com.tests;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {

    public static AndroidDriver createDriver(String udid, String port, String systemPort) throws Exception {
        DeviceConfig config = DeviceConfig.forDevice(udid);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setUdid(udid);
        options.setAppPackage(config.appPackage);
        options.setAppActivity(config.appActivity);
        options.setNoReset(true);
        options.setSystemPort(Integer.parseInt(systemPort));

        URL url = new URL("http://127.0.0.1:" + port);
        return new AndroidDriver(url, options);
    }
}