package tests;

import logiclayer.BusinessLogicLayer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import driver.DriverSingleton;

public class BaseTest {
    private WebDriver driver;
    public BusinessLogicLayer businessLogicLayer;
    private static final String BBC_URL = "https://www.bbc.com/";

    @BeforeClass
    public void profileSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = DriverSingleton.getDriver();
        businessLogicLayer = getBusinessLogicLayer();
    }

    @BeforeMethod
    public void testsSetUp() {
        driver.get(BBC_URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public BusinessLogicLayer getBusinessLogicLayer(){
        return new BusinessLogicLayer();
    }

}
