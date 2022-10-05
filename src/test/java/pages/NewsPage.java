package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.Waiters.waitAppearanceOfElementIgnoreExceptionAndClick;
import static helpers.Waiters.waitForPageLoadComplete;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[@class='gel-wrap gs-u-pt+']//div[contains(@class,'nw-c-top-stories--international')]")
    private WebElement mainNewsBlock;
    @FindBy(xpath = "//ul[@class='gs-o-list-inline gs-o-list-inline--divided gel-brevier gs-u-mt-']")
    private WebElement mainNewsBlockSubList;
    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']")
    private WebElement newsPageCategoriesTab;
    @FindBy(xpath = "//button[@class='tp-close tp-active']")
    private WebElement closePopUpButton;
    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//a[@href='/news/coronavirus']")
    private WebElement coronaVirusTab;

    public WebElement getCoronaVirusTab() {
        return coronaVirusTab;
    }

    public WebElement getClosePopUpButton() {
        return closePopUpButton;
    }

    public WebElement getMainNewsBlock() {
        return mainNewsBlock;
    }

    public WebElement getNewsPageCategoriesTab() {
        return newsPageCategoriesTab;
    }

    public String getCategoryTextFromFirstNewsBlock() {
        waitForPageLoadComplete(5);
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
        waitForPageLoadComplete(5);
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
        waitForPageLoadComplete(5);
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

    public int getHeadersListSize() {

        return getAllTitlesHeadersTextInMainNewsBlock().length;
    }

    public boolean isHeaderTextNotEmpty() {
        return getFirstNewsBlockTitleFromTopStories().isEmpty();
    }

    public int getHeaderTextLength() {
        if (isHeaderTextNotEmpty())
            return 0;
        else
            return getFirstNewsBlockTitleFromTopStories().length();
    }

    public CoronaVirusPage clickCoronaVirusTab() {
        waitAppearanceOfElementIgnoreExceptionAndClick(4, getClosePopUpButton());
        getCoronaVirusTab().click();
        return new CoronaVirusPage();
    }

}
