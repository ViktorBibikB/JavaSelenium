package stepdefinitions.bbc1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static helpers.Waiters.waitClickableOfElement;
import static managers.PageFactoryManager.*;

public class DefinitionsStepsBBC1Part1 {

    @And("User opens Homepage page")
    public void userOpensHomePagePage() {
        HOME_PAGE.openHomePage("https://www.bbc.com/");
    }

    @And("User clicks News tab")
    public void userClicksNewsTab() {
        HOME_PAGE.clickNewsTab();
    }

    @And("User checks that Header Text From First Abstract is not empty")
    public void userChecksThatHeaderTextFromFirstAbstractOnTheNewsPageEqualsToNews_title() {
        Assert.assertTrue(NEWS_PAGE.getHeaderTextLength() >= 1);
    }

    @Then("User checks that Header List size from top News block equals at least {int}")
    public void userChecksThatHeaderListSizeFromTopNewsBlockEqualsAtLeastHeader_list(final int abstract_count) {
        Assert.assertTrue(NEWS_PAGE.getHeadersListSize() >= abstract_count);
    }

    @And("User sends first article category name to search field")
    public void userSendsFirstArticleCategoryNameToSearchField() {
        HOME_PAGE.sendTextToSearchField(NEWS_PAGE.getCategoryTextFromFirstNewsBlock());
    }

    @Then("User checks that first article title equals to {string}")
    public void userChecksThatFirstArticleTitleEqualsToCategory_title(final String category_title) {
        Assert.assertEquals(SEARCH_PAGE.getFirstRegionalNewsTitle(), category_title);
    }
}
