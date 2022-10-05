package logiclayer;

import managers.PageFactoryManager;
import pages.*;

import java.util.Map;
import java.util.Objects;

import static helpers.Waiters.waitClickableOfElement;

public class BusinessLogicLayer {

    private final HomePage homePage = PageFactoryManager.getHomePage();
    private final NewsPage newsPage = PageFactoryManager.getNewsPage();
    private final SearchPage searchPage = PageFactoryManager.getSearchPage();
    private final SportPage sportPage = PageFactoryManager.getSportPage();
    private final ContactTheBBCPage contactTheBBCPage = PageFactoryManager.getContactTheBBCPage();
    private final GameResultPage gameResultPage = PageFactoryManager.getGameResultPage();
    private final CoronaVirusPage coronaVirusPage = new CoronaVirusPage();

    private static final String ENQUIRE_FIELD_TEXT = "Some text.";

    public boolean isHeaderTextFromFirstAbstractEmpty() {
        homePage.clickNewsTab();
        return newsPage.isHeaderTextNotEmpty();
    }

    public String[] getTitlesList() {
        homePage.clickNewsTab();
        return newsPage.getAllTitlesHeadersTextInMainNewsBlock();
    }

    public int getTitlesListElementsCount() {
        homePage.clickNewsTab();
        return newsPage.getHeadersListSize();
    }

    public String checkSearchFieldFromNewsPage() {
        homePage.clickNewsTab();
        homePage.sendTextToSearchField(newsPage.getCategoryTextFromFirstNewsBlock());
        return searchPage.getFirstRegionalNewsTitle();
    }

    public String getErrorMessageWhenRequestWithoutTitle() {
        sendQuestionToBBCWithoutTitle();
        return getMainErrorMessage();
    }

    public String getErrorMessageWhenRequestWithoutTextBox() {
        sendQuestionToBBCWithoutTextBox();
        return getMainErrorMessage();
    }

    public String getErrorMessageWhenRequestWithoutText() {
        sendQuestionToBBCWithoutText();
        return getMainErrorMessage();
    }

    public String getTeamsScoreResult(String leagueName, String championshipName, String month, String teamName) {
        selectChampionShipAndMonth(leagueName, championshipName, month);
        if (Objects.equals(month, "DEC")) {
            sportPage.clickGameLinkDecember(teamName);
        } else if ("NOV".equals(month)) {
            sportPage.clickGameLinkNovember(teamName);
        } else if ("OCT".equals(month)) {
            sportPage.clickGameLinkOctober(teamName);
        } else if ("JAN".equals(month)) {
            sportPage.clickGameLinkJanuary(teamName);
        } else {
            throw new IllegalArgumentException();
        }
        return gameResultPage.getResultsText();
    }

    private void selectChampionShipAndMonth(String leagueName, String championshipName, String month) {
        homePage.clickSportTab()
                .clickScoreInFootBallTab();
        setChampionshipAndMonth(leagueName, championshipName, month);
    }

    private void setChampionshipAndMonth(String leagueName, String championshipName, String month) {
        sportPage.sendTextToSearchField(leagueName)
                .selectChampionship(championshipName)
                .clickMonthButton(month);
    }


    private void sendQuestionToBBCWithoutText() {
        clickContactTheBBCLink()
                .fillFirstPartContactForm()
                .getMoreHelpQuestionTab()
                .clickContinueButton();
    }

    private void sendQuestionToBBCWithoutTextBox() {
        clickContactTheBBCLink()
                .fillFirstPartContactForm()
                .getMoreHelpQuestionTab();
        sendTextToEnquiryTitleInputFieldBox();
    }

    private void sendQuestionToBBCWithoutTitle() {
        clickContactTheBBCLink()
                .fillFirstPartContactForm()
                .getMoreHelpQuestionTab();
        sendTextToEnquiryTextarea();
    }

    private ContactTheBBCPage getMoreHelpQuestionTab() {
        contactTheBBCPage.clickIWantToList()
                .clickIWantInformationAbout()
                .clickContinueButton();
        return new ContactTheBBCPage();
    }

    private void sendTextToEnquiryTextarea() {
        contactTheBBCPage.sendTextToEnquiryTextarea(ENQUIRE_FIELD_TEXT)
                .clickContinueButtonGetMoreHelpForm();
    }

    private void sendTextToEnquiryTitleInputFieldBox() {
        contactTheBBCPage.sendTextToEnquiryTitleInputField(ENQUIRE_FIELD_TEXT)
                .clickContinueButtonGetMoreHelpForm();
    }

    private String getMainErrorMessage() {
        return contactTheBBCPage.getErrorMessage().getText();
    }

    private BusinessLogicLayer fillFirstPartContactForm() {
        contactTheBBCPage.clickQuestionTab()
                .clickHowCanIContactLink()
                .clickGetMoreHelpButton();
        return this;
    }

    private BusinessLogicLayer clickContactTheBBCLink() {
        waitClickableOfElement(5, homePage.getContactTheBBCLink());
        homePage.clickContactTheBBCLink();
        return this;
    }

    private BusinessLogicLayer moveToCoronavirusStories() {
        homePage.clickNewsTab()
                .clickCoronaVirusTab()
                .clickCoronavirusStories()
                .clickQuestionsToBBC();
        return this;
    }

    private CoronaVirusPage fillForm(Map<String, String> data){
        CoronaVirusPage.Form submitForm = new CoronaVirusPage.Form();
        submitForm.FillForm(data);
        return new CoronaVirusPage();
    }

    public String fillQuestionFormOnTheCoronavirusPage(Map<String, String> data){
        moveToCoronavirusStories()
                .fillForm(data)
                .clickCheckBox()
                .clickButtonSubmit();
        return coronaVirusPage.getEmailErrorMessageText();
    }
}
