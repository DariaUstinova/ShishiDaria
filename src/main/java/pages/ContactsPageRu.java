package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactsPageRu extends BasePage{
    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@id='text']")
    WebElement messageField;
    @FindBy(xpath =  "//input[@value='Отправить']")
    WebElement sendBtn;
    @FindBy(xpath = "//span[contains(text(),'Сообщение отправлено')]")
    WebElement messagePositive;
    public ContactsPageRu(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    public ContactsPageRu fillNameField(String name){
        nameField.click();
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }
    public ContactsPageRu fillEmailField(String email){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public ContactsPageRu fillMessageField(String text){
        messageField.click();
        messageField.clear();
        messageField.sendKeys(text);
        return this;
    }
    public ContactsPageRu clickBySendButton(){
        sendBtn.click();
        return new ContactsPageRu(driver); // InCorrect - returns Mail page (create new page?)
        //https://shishi.co.il/mail/success ->RU
        //https://en.shishi.co.il/mail/send ->En (404 error)
    }
    public String getMessage(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(messagePositive));
            return messagePositive.getText();
        } catch (TimeoutException e){
            return e.getMessage();
        }
    }
    public void validationMessage(String text){
        String message = driver.findElement(By.name(text)).getAttribute("validationMessage");
        System.out.println(message);
    }
}
