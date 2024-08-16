package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPageEn extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@id='text']")
    WebElement messageField;
    @FindBy(xpath =  "//input[@value='Send']")
    WebElement sendBtn;
    @FindBy(xpath = "//div[@id='container']/h1")
    WebElement errorMessage;


    public ContactsPageEn(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public ContactsPageEn fillNameField(String name){
        nameField.click();
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }
    public ContactsPageEn fillEmailField(String email){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public ContactsPageEn fillMessageField(String text){
        messageField.click();
        messageField.clear();
        messageField.sendKeys(text);
        return this;
    }
    public ContactsPageEn clickBySendButton(){
        sendBtn.click();
        return new ContactsPageEn(driver); // InCorrect - returns Mail page (create new page?)
        //https://shishi.co.il/mail/success ->RU
        //https://en.shishi.co.il/mail/send ->En (404 error)
    }
    public String getErrorMessage(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (TimeoutException e){
            return e.getMessage();
        }
    }
}
