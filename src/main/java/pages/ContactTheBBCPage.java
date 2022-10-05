package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebHelpers.clickWebElementFromListByText;

public class ContactTheBBCPage extends BasePage{

    private static final String TEXT_QUESTION = "Questions";
    private final String ASK_QUESTION = "Find information/ask a question";
    private final String SOMETHING_ELSE = "Something else";

    @FindBy(xpath = "//ul[@id='nav-contact-the-bbc-main-naviga']")
    public WebElement contactsTopMenuElementsList;
    @FindBy(xpath = "//div[contains(@class,'faq-tile-items gel-layout__item')]//a[contains(@href,'contact-bbc')]")
    public WebElement howCanIContactLink;
    @FindBy(xpath = "//div[@id='block-doyouneedhelpcontact2']//a[contains(@href,'enquiryform')]")
    public WebElement getMoreHelpButton;

    @FindBy(xpath = "//div[@class='form-group group rd-group ']")
    public WebElement iWantToList;
    @FindBy(xpath = "//legend[contains(text(),'I want information about...')]/following::div[1]")
    public WebElement iWantInformationAbout;
    @FindBy(xpath = "//div[@class='bottom-bar']/button[@type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='number-field  form-group container empty']//input[@class='form-group empty']")
    public WebElement enquiryTitleInputField;
    @FindBy(xpath = "//div[@class='textarea-field form-group container']//textarea[@class='form-group empty']")
    public WebElement enquiryTextarea;
    @FindBy(xpath = "//div[@class='bottom-bar']//button[@class='btn btn-next-submit btn-right']")
    public WebElement continueButtonGetMoreHelpForm;
    @FindBy(xpath = "//div[@class='general error']")
    public WebElement errorMessage;

    public WebElement getContactsTopMenuElementsList(){
        return contactsTopMenuElementsList;
    }

    public void clickQuestionTab(){
        clickWebElementFromListByText(getContactsTopMenuElementsList(), TEXT_QUESTION, "li");
    }

    public WebElement getHowCanIContactLink() {
        return howCanIContactLink;
    }

    public void clickHowCanIContactLink(){
        getHowCanIContactLink().click();
    }

    public WebElement getGetMoreHelpButton() {
        return getMoreHelpButton;
    }

    public void clickGetMoreHelpButton(){
        getGetMoreHelpButton().click();
    }

    public WebElement getIWantToList() {
        return iWantToList;
    }

    public void clickIWantToList(){
        clickWebElementFromListByText(getIWantToList(), ASK_QUESTION, "label");
    }

    public WebElement getIWantInformationAbout() {
        return iWantInformationAbout;
    }

    public void clickIWantInformationAbout(){
        clickWebElementFromListByText(getIWantInformationAbout(), SOMETHING_ELSE, "label");
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public WebElement getEnquiryTitleInputField() {
        return enquiryTitleInputField;
    }

    public void sendTextToEnquiryTitleInputField(String text){
        getEnquiryTitleInputField().sendKeys(text);
    }

    public WebElement getEnquiryTextarea() {
        return enquiryTextarea;
    }

    public WebElement getContinueButtonGetMoreHelpForm() {
        return continueButtonGetMoreHelpForm;
    }

    public void sendTextToEnquiryTextarea(String text){
        getEnquiryTextarea().sendKeys(text);
    }

    public void clickContinueButtonGetMoreHelpForm(){
        getContinueButtonGetMoreHelpForm().click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
