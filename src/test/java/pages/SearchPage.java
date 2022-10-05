package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'ssrcss-1un9fz5-WrapWithWidth')]//ul[@role='list']")
    private WebElement regionalNewsList;

    public WebElement getRegionalNewsList(){
        return regionalNewsList;
    }

    public String getFirstRegionalNewsTitle() {
        List<WebElement> newsList = getRegionalNewsList().findElements(By.tagName("a"));
        int size = newsList.size();
        String elementText = null;
        for (int i = 0; i <= size - 1; i++) {
            if (i == 0)
                elementText = newsList.get(i).getText();
        }
        return elementText;
    }
}
