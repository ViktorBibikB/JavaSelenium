package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GameResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='football-oppm-header']//article[@class='sp-c-fixture']//div[@class='sp-c-fixture__wrapper']")
    public WebElement resultsBlock;

    public WebElement getResultsBlock() {
        return resultsBlock;
    }

    public String getResultsText(){
        return getResultsBlock().getText();
    }
}
