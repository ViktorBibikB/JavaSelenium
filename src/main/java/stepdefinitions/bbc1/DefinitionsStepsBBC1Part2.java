package stepdefinitions.bbc1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static helpers.Waiters.waitClickableOfElement;
import static managers.PageFactoryManager.*;

public class DefinitionsStepsBBC1Part2 {

    @And("User clicks Contact Us button into page footer")
    public void userClicksContactUsButtonIntoPageFooter() {
        waitClickableOfElement(5, HOME_PAGE.getContactTheBBCLink());
        HOME_PAGE.clickContactTheBBCLink();
    }

    @And("User clicks Question Tab")
    public void userClicksQuestionTab() {
        CONTACT_THE_BBC_PAGE.clickQuestionTab();
    }

    @And("User clicks How Can I Contact Link")
    public void userClicksHowCanIContactLink() {
        CONTACT_THE_BBC_PAGE.clickHowCanIContactLink();
    }

    @And("User clicks Get More Help Button")
    public void userClicksGetMoreHelpButton() {
        CONTACT_THE_BBC_PAGE.clickGetMoreHelpButton();
    }

    @And("User clicks I Want To List variant in list")
    public void userClicksIWantToListVariantInList() {
        CONTACT_THE_BBC_PAGE.clickIWantToList();
    }

    @And("User clicks I Want Information About in list")
    public void userClicksIWantInformationAboutInList() {
        CONTACT_THE_BBC_PAGE.clickIWantInformationAbout();
    }

    @And("User clicks Continue Button")
    public void userClicksContinueButton() {
        CONTACT_THE_BBC_PAGE.clickContinueButton();
    }

    @When("User sends Text {string} To Enquiry Text area")
    public void userSendsTextToEnquiryTextArea(final String TEXT) {
        CONTACT_THE_BBC_PAGE.sendTextToEnquiryTextarea(TEXT);
    }

    @When("User clicks button Continue in Get More Help Form")
    public void userSendsClicksButtonContinueInGetMoreHelpForm() {
        CONTACT_THE_BBC_PAGE.clickContinueButtonGetMoreHelpForm();
    }

    @Then("The error message {string} should to be appeared")
    public void theErrorMessageError_messageShouldToBeAppeared(final String errorMessageText) {
        Assert.assertEquals(CONTACT_THE_BBC_PAGE.getErrorMessage().getText(), errorMessageText);
    }

    @When("User sends Text {string} To Enquiry Title Input Field")
    public void userSendsTextRequired_textToEnquiryTitleInputField(final String TEXT) {
        CONTACT_THE_BBC_PAGE.sendTextToEnquiryTitleInputField(TEXT);
    }

}
