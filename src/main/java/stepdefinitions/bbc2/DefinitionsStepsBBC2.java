package stepdefinitions.bbc2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


import java.util.Objects;

import static managers.PageFactoryManager.*;

public class DefinitionsStepsBBC2 {

    @And("User clicks Score And Fixtures in Sport tab")
    public void userClicksNewsTab() {
        HOME_PAGE.clickSportTab()
                .clickFootBallTab()
                .clickScoreAndFixtures();
    }

    @And("User send Scottish League name to the Search field")
    public void userSendLeagueNameToTheSearchField() {
        SPORT_PAGE.sendTextToSearchField("Scottish");
    }

    @And("User selects Scottish Championship")
    public void userSelectsChampionShip() {
        SPORT_PAGE.selectChampionship("Scottish Championship");
    }

    @When("User clicks required {string}")
    public void userClicksRequiredMonth(final String MONTH) {
        SPORT_PAGE.clickMonthButton(MONTH);
    }

    @And("User clicks team name {string}")
    public void userClicksGameLink(String teamName) {
        if (Objects.equals(teamName, "Dunfermline")) {
            SPORT_PAGE.clickGameLinkDecember("Dunfermline");
        } else if ("Queen of the South".equals(teamName)) {
            SPORT_PAGE.clickGameLinkNovember("Queen of the South");
        } else if ("Greenock Morton".equals(teamName)) {
            SPORT_PAGE.clickGameLinkOctober("Greenock Morton");
        } else if ("Hamilton Academical".equals(teamName)) {
            SPORT_PAGE.clickGameLinkJanuary("Hamilton Academical");
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Then("should appear {string} in new page.")
    public void theShouldAppearTeams_scoreInNewPage(String score) {
        Assert.assertEquals(GAME_RESULT_PAGE.getResultsText(), score);
    }
}
