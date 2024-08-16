package pages;

import helpers.enums.HeaderMenuItemsEn;
import helpers.enums.HeaderMenuItemsRu;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.enums.HeaderMenuItemsEn.*;


public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    @FindBy(xpath = "//a[text()='Вход']")
   static WebElement btnLoginHeader;
    @FindBy(xpath = "//a[text()='Регистрация']")
   static WebElement btnRegistrationHeader;

    @FindBy(xpath = "//i[@class='fa fa-facebook']/..")
    WebElement btnFacebookHeader;

    public static LoginUserPageRu clickBtnLoginHeader(){
        btnLoginHeader.click();
        return new LoginUserPageRu(driver);
    }
    public static CreateUserPageRu clickBtnRegistrationHeader(){
        btnRegistrationHeader.click();
        return new CreateUserPageRu(driver);
    }

    public static <T extends BasePage> T clickButtonsOnHeaderEn(HeaderMenuItemsEn headerMenuItemsEn) {
        try {
             WebElement elementHeaderMenuItem = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(headerMenuItemsEn.getLocator())));
            elementHeaderMenuItem.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        switch (headerMenuItemsEn) {
            case ACTIVITIES:
                return (T) new EventsPageEn(driver);
            case ABOUT:
                return (T) new AboutPageEn(driver);
//            case OUR_TEAM:
//                return (T) new OurTeamEn(driver);
            case CONTACT_US:
                return (T) new ContactsPageEn(driver);
            default:
                throw new IllegalArgumentException("invalid parametr headerMenuItemsEn");
        }
    }
    public static <T extends BasePage> T clickButtonsOnHeaderRu(HeaderMenuItemsRu headerMenuItemsRu) {
        try {
            WebElement elementHeaderMenuItem = new WebDriverWait(driver,  Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(headerMenuItemsRu.getLocator())));
            elementHeaderMenuItem.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        switch (headerMenuItemsRu) {
            case EVENTS:
                return (T) new EventsPageRu(driver);
                case PHOTO:
                return (T) new PhotoPageRu(driver);
            case VIDEO:
                return (T) new VideoPageRu(driver);
            case ABOUT_US:
                return (T) new AboutUsPageRu(driver);
            case CONTACTS:
                return (T) new ContactsPageRu(driver);
            default:
                throw new IllegalArgumentException("invalid parametr headerMenuItemsRu");
        }
    }


    public static void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String get404ErrorText() {
        pause(3000);
//        return driver.findElement(By.xpath("//div[@id='container']/h1")).getText();
        return driver.findElement(By.xpath("//div[@id='body']/p")).getText();
    }
    public boolean isAlertPresent(String message){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        if(alert!=null&&alert.getText().contains(message)){
            pause(2000);
            alert.accept();
            return true;
        }
        return false;
    }
}
