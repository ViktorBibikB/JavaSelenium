package pages;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@id='orb-nav-links']")
    public WebElement topMenuTabsList;
    @FindBy(xpath = "//div[@id='orb-nav-links']//li[@class='orb-nav-newsdotcom']")
    public WebElement newsTab;
    @FindBy(xpath = "//div[@id='orb-nav-links']//li[@class='orb-nav-sport']")
    public WebElement sportTab;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    public WebElement searchField;
    @FindBy(xpath = "//div[@id='orb-contentinfo']//a[contains(@href,'contact')]")
    public WebElement contactTheBBCLink;


    public void openHomePage( String URL) {
        DriverSingleton.getDriver().get(URL);
    }

    public WebElement getTopMenuTabsList() {
        return topMenuTabsList;
    }

    public WebElement getSportTab() {
        return sportTab;
    }

    public void clickTabFromTopMenuList(String element_text) {
        List<WebElement> listWebElements = getTopMenuTabsList().findElements(By.tagName("li"));

        for (WebElement e : listWebElements) {
            if (e.getText().contains(element_text))
                e.click();
        }
    }

    public void clickNewsTab() {
        newsTab.click();
    }

    public SportPage clickSportTab() {
        getSportTab().click();
        return new SportPage();
    }

    public void sendTextToSearchField(String text){
        searchField.clear();
        searchField.sendKeys(text, Keys.ENTER);
    }

    public WebElement getContactTheBBCLink(){
        return contactTheBBCLink;
    }

    public void clickContactTheBBCLink(){
        contactTheBBCLink.click();
    }
}
