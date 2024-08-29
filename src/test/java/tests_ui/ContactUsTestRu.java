package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsRu;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactsPageRu;
import pages.HomePageRu;

public class ContactUsTestRu extends ApplicationManager {
    @Test
    public void contactPositive() {
        Allure.description("ContactUs test positive Ru. All fields are filled");
        HomePageRu homePageRu = new HomePageRu(getDriver());
        ContactsPageRu contactsPageRu = BasePage.clickButtonsOnHeaderRu(HeaderMenuItemsRu.CONTACTS);

        contactsPageRu.fillNameField("Test");
        Allure.description("Name field is filled with 'Test'");
        contactsPageRu.fillEmailField("test@gmail.com");
        Allure.description("Email field  'test@gmail.com' ");
        contactsPageRu.fillMessageField("Automation testing");
        Allure.description("Message field  'Automation testing' ");
        contactsPageRu.clickBySendButton();
        Allure.description("Send button is clicked");
        Assert.assertEquals(contactsPageRu.getMessage(), "СООБЩЕНИЕ ОТПРАВЛЕНО");
    }
    @Test
    public void contactEmptyNameField() {
        HomePageRu homePageRu = new HomePageRu(getDriver());
        ContactsPageRu contactsPageRu = BasePage.clickButtonsOnHeaderRu(HeaderMenuItemsRu.CONTACTS);

        contactsPageRu.fillNameField("");
        contactsPageRu.fillEmailField("test@gmail.com");
        contactsPageRu.fillMessageField("Automation testing");
        contactsPageRu.clickBySendButton();
        contactsPageRu.validationMessage("name");
//        Assert.assertTrue(contactsPageRu.isAlertPresent("Please fill out this field"));

    }
    @Test
    public void contactEmptyEmailField() {
        HomePageRu homePageRu = new HomePageRu(getDriver());
        ContactsPageRu contactsPageRu = BasePage.clickButtonsOnHeaderRu(HeaderMenuItemsRu.CONTACTS);

        contactsPageRu.fillNameField("Test");
        contactsPageRu.fillEmailField("");
        contactsPageRu.fillMessageField("Automation testing");
        contactsPageRu.clickBySendButton();
        contactsPageRu.validationMessage("email");
//        String message = driver.findElement(By.name("email")).getAttribute("validationMessage");
//        Assert.assertTrue(contactsPageRu.isAlertPresent("Please fill out this field"));
    }
    @Test
    public void contactEmptyMessageField() {
        HomePageRu homePageRu = new HomePageRu(getDriver());
        ContactsPageRu contactsPageRu = BasePage.clickButtonsOnHeaderRu(HeaderMenuItemsRu.CONTACTS);

        contactsPageRu.fillNameField("Test");
        contactsPageRu.fillEmailField("test@gmail.com");
        contactsPageRu.fillMessageField("");
        contactsPageRu.clickBySendButton();
        Assert.assertEquals(contactsPageRu.getMessage(), "СООБЩЕНИЕ ОТПРАВЛЕНО");
        //Test passes but must appear an error message
//        contactsPageRu.validationMessage("text");
    }
    @Test
    public void contactWrongEmailField() {
        HomePageRu homePageRu = new HomePageRu(getDriver());
        ContactsPageRu contactsPageRu = BasePage.clickButtonsOnHeaderRu(HeaderMenuItemsRu.CONTACTS);

        contactsPageRu.fillNameField("Test");
        contactsPageRu.fillEmailField("testgmail.com");
        contactsPageRu.fillMessageField("Automation testing");
        contactsPageRu.clickBySendButton();
       Assert.assertEquals(contactsPageRu.getMessage(), "СООБЩЕНИЕ ОТПРАВЛЕНО");
//        //Test passes but must appear an error message
    }
}
