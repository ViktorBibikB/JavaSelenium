package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waiters.waitForPageLoadComplete;

public class GameResultPage extends BasePage{

    @FindBy(xpath = "//div[@class='football-oppm-header']//article[@class='sp-c-fixture']//div[@class='sp-c-fixture__wrapper']")
    private WebElement resultsBlock;

    public WebElement getResultsBlock() {
        return resultsBlock;
    }

    public String getResultsText(){
        waitForPageLoadComplete(5);
        return getResultsBlock().getText();
    }
}
