package stepdefinitions;

import driver.DriverSingleton;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {

    @Before
    public void testsSetUp() {
        WebDriverManager.chromedriver().setup();
        DriverSingleton.getDriver();
    }

    @AfterAll
    public static void afterAll() {
        DriverSingleton.getDriver().quit();
    }
}
