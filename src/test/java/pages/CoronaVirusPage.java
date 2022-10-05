package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CoronaVirusPage extends BasePage{

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide-secondary']//a[@href='/news/have_your_say']")
    private WebElement coronavirusStories;
    @FindBy(xpath = "//a[@href='/news/52143212']")
    private WebElement questionsToBBC;
    @FindBy(xpath = "//textarea[contains(@placeholder,'What questions')]")
    private static WebElement textBox;
    @FindBy(xpath = "//div[@class='input-threeup-leading ']//input[@placeholder='Name']")
    private static WebElement nameField;
    @FindBy(xpath = "//div[contains(@class,'following input-threeup-leading')]//input[@placeholder='Email address']")
    private static WebElement emailField;
    @FindBy(xpath = "//div[contains(@class,'input-threeup-following ')]//input[@placeholder='Contact number']")
    private static WebElement contactNumberField;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement checkBox;
    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//div[contains(@class,'input-threeup-following input-threeup-leading ')]//div[@class='input-error-message']")
    private WebElement emailErrorMessage;

    public WebElement getCoronavirusStories() {
        return coronavirusStories;
    }

    public WebElement getQuestionsToBBC() {
        return questionsToBBC;
    }

    public static WebElement getTextBox() {
        return textBox;
    }

    public static WebElement getNameField() {
        return nameField;
    }

    public static WebElement getEmailField() {
        return emailField;
    }

    public static WebElement getContactNumberField() {
        return contactNumberField;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getButtonSubmit() {
        return buttonSubmit;
    }

    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

    public CoronaVirusPage clickCoronavirusStories(){
        getCoronavirusStories().click();
        return this;
    }

    public CoronaVirusPage clickQuestionsToBBC(){
        getQuestionsToBBC().click();
        return this;
    }

    public CoronaVirusPage clickCheckBox(){
            getCheckBox().click();
        return this;
    }

    public CoronaVirusPage clickButtonSubmit(){
        getButtonSubmit().click();
        return this;
    }

    public String getEmailErrorMessageText(){
        return getEmailErrorMessage().getText();
    }

    public static class Form{
        public void FillForm(Map<String, String> data){
            getTextBox().sendKeys(data.get("text"));
            getNameField().sendKeys(data.get("name"));
            getEmailField().sendKeys(data.get("email"));
            getContactNumberField().sendKeys(data.get("number"));
        }
    }
}
