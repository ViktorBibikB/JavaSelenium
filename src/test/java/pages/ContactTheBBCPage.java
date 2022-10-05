package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waiters.waitVisibilityOfElement;
import static helpers.WebHelpers.clickWebElementFromListByText;

public class ContactTheBBCPage extends BasePage{

    private static final String TEXT_QUESTION = "Questions";
    private final String ASK_QUESTION = "Find information/ask a question";
    private final String SOMETHING_ELSE = "Something else";

    @FindBy(xpath = "//ul[@id='nav-contact-the-bbc-main-naviga']")
    private WebElement contactsTopMenuElementsList;
    @FindBy(xpath = "//div[contains(@class,'faq-tile-items gel-layout__item')]//a[contains(@href,'contact-bbc')]")
    private WebElement howCanIContactLink;
    @FindBy(xpath = "//div[@id='block-doyouneedhelpcontact2']//a[contains(@href,'enquiryform')]")
    private WebElement getMoreHelpButton;

    @FindBy(xpath = "//div[@class='form-group group rd-group ']")
    private WebElement iWantToList;
    @FindBy(xpath = "//legend[contains(text(),'I want information about...')]/following::div[1]")
    private WebElement iWantInformationAbout;
    @FindBy(xpath = "//div[@class='bottom-bar']/button[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='number-field  form-group container empty']//input[@class='form-group empty']")
    private WebElement enquiryTitleInputField;
    @FindBy(xpath = "//div[@class='textarea-field form-group container']//textarea[@class='form-group empty']")
    private WebElement enquiryTextarea;
    @FindBy(xpath = "//div[@class='bottom-bar']//button[@class='btn btn-next-submit btn-right']")
    private WebElement continueButtonGetMoreHelpForm;
    @FindBy(xpath = "//div[@class='general error']")
    private WebElement errorMessage;

    public WebElement getContactsTopMenuElementsList(){
        return contactsTopMenuElementsList;
    }

    public ContactTheBBCPage clickQuestionTab(){
        clickWebElementFromListByText(getContactsTopMenuElementsList(), TEXT_QUESTION, "li");
        return this;
    }

    public WebElement getHowCanIContactLink() {
        return howCanIContactLink;
    }

    public ContactTheBBCPage clickHowCanIContactLink(){
        getHowCanIContactLink().click();
        return this;
    }

    public WebElement getGetMoreHelpButton() {
        return getMoreHelpButton;
    }

    public ContactTheBBCPage clickGetMoreHelpButton(){
        getGetMoreHelpButton().click();
        return this;
    }

    public WebElement getIWantToList() {
        return iWantToList;
    }

    public ContactTheBBCPage clickIWantToList(){
        clickWebElementFromListByText(getIWantToList(), ASK_QUESTION, "label");
        return this;
    }

    public WebElement getIWantInformationAbout() {
        return iWantInformationAbout;
    }

    public ContactTheBBCPage clickIWantInformationAbout(){
        clickWebElementFromListByText(getIWantInformationAbout(), SOMETHING_ELSE, "label");
        return this;
    }

    public ContactTheBBCPage clickContinueButton(){
        continueButton.click();
        return this;
    }

    public WebElement getEnquiryTitleInputField() {
        return enquiryTitleInputField;
    }

    public ContactTheBBCPage sendTextToEnquiryTitleInputField(String text){
        getEnquiryTitleInputField().sendKeys(text);
        return this;
    }

    public WebElement getEnquiryTextarea() {
        return enquiryTextarea;
    }

    public WebElement getContinueButtonGetMoreHelpForm() {
        return continueButtonGetMoreHelpForm;
    }

    public ContactTheBBCPage sendTextToEnquiryTextarea(String text){
        getEnquiryTextarea().sendKeys(text);
        return this;
    }

    public ContactTheBBCPage clickContinueButtonGetMoreHelpForm(){
        getContinueButtonGetMoreHelpForm().click();
        return this;
    }

    public WebElement getErrorMessage() {
        waitVisibilityOfElement(5, errorMessage);
        return errorMessage;
    }
}
