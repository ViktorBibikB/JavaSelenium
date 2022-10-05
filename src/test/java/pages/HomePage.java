package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@id='orb-nav-links']")
    private WebElement topMenuTabsList;
    @FindBy(xpath = "//div[@id='orb-nav-links']//li[@class='orb-nav-newsdotcom']")
    private WebElement newsTab;
    @FindBy(xpath = "//div[@id='orb-nav-links']//li[@class='orb-nav-sport']")
    private WebElement sportTab;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@id='orb-contentinfo']//a[contains(@href,'contact')]")
    private WebElement contactTheBBCLink;

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

    public NewsPage clickNewsTab() {
        newsTab.click();
        return new NewsPage();
    }

    public SportPage clickSportTab() {
        getSportTab().click();
        return new SportPage();
    }

    public HomePage sendTextToSearchField(String text){
        searchField.clear();
        searchField.sendKeys(text, Keys.ENTER);
        return this;
    }

    public WebElement getContactTheBBCLink(){
        return contactTheBBCLink;
    }

    public void clickContactTheBBCLink(){
        contactTheBBCLink.click();
    }
}
