package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.WebHelpers.clickWebElementFromListByText;

public class SportPage extends BasePage {

    @FindBy(xpath = "//div[@class='gel-wrap sp-c-sport-navigation__wrapper']")
    private WebElement topNavigationToolsBar;
    @FindBy(xpath = "//ul[@id='sp-nav-secondary']")
    private WebElement footballTabElements;
    @FindBy(id = "downshift-0-input")
    private WebElement searchFiled;
    @FindBy(xpath = "//ul[@id='search-results-list']")
    private WebElement searchResultList;
    @FindBy(id = "sp-timeline-past-dates")
    private WebElement previousMonthList;
    @FindBy(xpath = "//span[@role='region']/div[1]")
    private WebElement championshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipSunday')]")
    private WebElement decemberChampionshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipFriday')]")
    private WebElement novemberChampionshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipTuesday')]")
    private WebElement octoberChampionshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipSunday')]")
    private WebElement januaryChampionshipsList;

    public WebElement getTopNavigationToolsBar() {
        return topNavigationToolsBar;
    }

    public WebElement getFootballTabElements() {
        return footballTabElements;
    }

    public WebElement getSearchFiled() {
        return searchFiled;
    }

    public WebElement getSearchResultList() {
        return searchResultList;
    }

    public WebElement getPreviousMonthList() {
        return previousMonthList;
    }

    public WebElement getChampionshipsList() {
        return championshipsList;
    }

    public WebElement getDecemberChampionshipsList() {
        return decemberChampionshipsList;
    }

    public WebElement getNovemberChampionshipsList() {
        return novemberChampionshipsList;
    }

    public WebElement getOctoberChampionshipsList() {
        return octoberChampionshipsList;
    }

    public WebElement getJanuaryChampionshipsList() {
        return januaryChampionshipsList;
    }

    public void clickFootBallTab() {
        clickWebElementFromListByText(getTopNavigationToolsBar(), "Football", "li");
    }

    public void clickScoreAndFixtures() {
        clickWebElementFromListByText(getFootballTabElements(), "Scores & Fixtures", "li");
    }

    public SportPage sendTextToSearchField(String text) {
        getSearchFiled().clear();
        getSearchFiled().sendKeys(text);
        return new SportPage();
    }

    public SportPage selectChampionship(String text) {
        clickWebElementFromListByText(getSearchResultList(), text, "li");
        return new SportPage();
    }

    public SportPage clickMonthButton(String text) {
        clickWebElementFromListByText(getPreviousMonthList(), text, "li");
        return new SportPage();
    }

    public String getElementText() {
        List<WebElement> elementList = getDecemberChampionshipsList().findElements(By.tagName("div"));
        String[] stringList = new String[elementList.size()];
        String resultedText = null;
        for (int i = 0; i <= elementList.size(); i++) {
            if (i == 1) {
                stringList[i] = elementList.get(i).getText();
                resultedText = stringList[i];
            }
        }
        return resultedText;
    }

    public void clickGameLinkDecember(String teamName) {
        clickWebElementFromListByText(getDecemberChampionshipsList(), teamName, "li");
    }

    public void clickGameLinkNovember(String teamName) {
        clickWebElementFromListByText(getNovemberChampionshipsList(), teamName, "li");
    }

    public void clickGameLinkOctober(String teamName) {
        clickWebElementFromListByText(getOctoberChampionshipsList(), teamName, "li");
    }

    public void clickGameLinkJanuary(String teamName) {
        clickWebElementFromListByText(getJanuaryChampionshipsList(), teamName, "li");
    }

    public void clickScoreInFootBallTab() {
        clickFootBallTab();
        clickScoreAndFixtures();
    }
}
