package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage{

    @FindBy(xpath = "//div[@class='gel-wrap gs-u-pt+']//div[contains(@class,'nw-c-top-stories--international')]")
    public WebElement mainNewsBlock;
    @FindBy(xpath = "//ul[@class='gs-o-list-inline gs-o-list-inline--divided gel-brevier gs-u-mt-']")
    public WebElement mainNewsBlockSubList;

    public WebElement getMainNewsBlock() {
        return mainNewsBlock;
    }

    public String getCategoryTextFromFirstNewsBlock() {
        List<WebElement> newsList = getMainNewsBlock().findElements(By.tagName("li"));
        int size = newsList.size();
        String[] stringArray = new String[size];
        String elementText = null;
        for (int i = 0; i <= size - 1; i++) {
            if (i == 1) {
                    stringArray[i] = newsList.get(i).getText();
                    elementText = stringArray[i];
                }
        }
        return elementText;
    }

    public String getFirstNewsBlockTitleFromTopStories() {
        List<WebElement> newsList = getMainNewsBlock().findElements(By.tagName("h3"));
        int size = newsList.size();
        String elementText = null;
        for (int i = 0; i <= size - 1; i++) {
            if (i == 0)
                elementText = newsList.get(i).getText();
        }
        return elementText;
    }

    public String[] getAllTitlesHeadersTextInMainNewsBlock() {
        List<WebElement> newsList = getMainNewsBlock().findElements(By.tagName("h3"));
        String[] a = new String[newsList.size()];
        int titleNumber = 0;
        for (WebElement e : newsList) {
            if (e.isEnabled()) {
                a[titleNumber] = e.getText();
                titleNumber++;
            }
        }
        return a;
    }

    public int getHeadersListSize(){
        return getAllTitlesHeadersTextInMainNewsBlock().length;
    }

    public boolean isHeaderTextNotEmpty(){
        return getFirstNewsBlockTitleFromTopStories().isEmpty();
    }

    public int getHeaderTextLength(){
        if(isHeaderTextNotEmpty())
            return 0;
        else
            return getFirstNewsBlockTitleFromTopStories().length();
    }
}
