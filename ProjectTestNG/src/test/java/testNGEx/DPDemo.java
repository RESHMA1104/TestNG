package testNGEx;

import org.testng.annotations.DataProvider;

public class DPDemo {

    @DataProvider(name = "testData")
    public Object[][] dp() {
        return new Object[][] {
            {"Selenium"},
            {"TestNG"},
            {"SeleniumTestNG"}
        };
    }
}