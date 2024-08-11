package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ContactUsPageEn extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@id='text']")
    WebElement messageField;
    @FindBy(xpath =  "//input[@value='Send']")
    WebElement sendBtn;


    public ContactUsPageEn (WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public ContactUsPageEn fillNameField(String name){
        nameField.click();
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }
    public ContactUsPageEn fillEmailField(String email){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public ContactUsPageEn fillMessageField(String text){
        messageField.click();
        messageField.clear();
        messageField.sendKeys(text);
        return this;
    }
    public ContactUsPageEn clickBySendButton(){
        sendBtn.click();
        return new ContactUsPageEn(driver); // InCorrect - returns Mail page (create new page?)
        //https://shishi.co.il/mail/success ->RU
        //https://en.shishi.co.il/mail/send ->En (404 error)
    }
}
