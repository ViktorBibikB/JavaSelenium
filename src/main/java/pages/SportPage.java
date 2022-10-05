package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.WebHelpers.clickWebElementFromListByText;

public class SportPage extends BasePage{

    @FindBy(xpath = "//div[@class='gel-wrap sp-c-sport-navigation__wrapper']")
    public WebElement topNavigationToolsBar;
    @FindBy(xpath = "//ul[@id='sp-nav-secondary']")
    public WebElement footballTabElements;
    @FindBy(id = "downshift-0-input")
    public WebElement searchFiled;
    @FindBy(xpath = "//ul[@id='search-results-list']")
    public WebElement searchResultList;
    @FindBy(id = "sp-timeline-past-dates")
    public WebElement previousMonthList;
    @FindBy(xpath = "//span[@role='region']/div[1]")
    public WebElement championshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipSunday')]")
    public WebElement decemberChampionshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipFriday')]")
    public WebElement novemberChampionshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipTuesday')]")
    public WebElement octoberChampionshipsList;
    @FindBy(xpath = "//ul[contains(@data-reactid,'Scottish ChampionshipSunday')]")
    public WebElement januaryChampionshipsList;

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

    public SportPage clickFootBallTab() {
        clickWebElementFromListByText(getTopNavigationToolsBar(), "Football", "li");
        return this;
    }

    public SportPage clickScoreAndFixtures() {
        clickWebElementFromListByText(getFootballTabElements(), "Scores & Fixtures", "li");
        return this;
    }

    public void sendTextToSearchField(String text) {
        getSearchFiled().clear();
        getSearchFiled().sendKeys(text);
    }

    public void selectChampionship(String text) {
        clickWebElementFromListByText(getSearchResultList(), text, "li");
    }

    public void clickMonthButton(String text) {
        clickWebElementFromListByText(getPreviousMonthList(), text, "li");
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

    public void clickGameLinkDecember(String teamName){
        clickWebElementFromListByText(getDecemberChampionshipsList(), teamName, "li");
    }

    public void clickGameLinkNovember(String teamName){
        clickWebElementFromListByText(getNovemberChampionshipsList(), teamName, "li");
    }

    public void clickGameLinkOctober(String teamName){
        clickWebElementFromListByText(getOctoberChampionshipsList(), teamName, "li");
    }

    public void clickGameLinkJanuary(String teamName){
        clickWebElementFromListByText(getJanuaryChampionshipsList(), teamName, "li");
    }

    public SportPage clickScoreInFootBallTab(){
        clickFootBallTab();
        clickScoreAndFixtures();
        return this;
    }
}
