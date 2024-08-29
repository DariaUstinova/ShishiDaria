package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPageEn;
import pages.HomePageEn;

import static pages.BasePage.clickButtonsOnHeaderEn;

public class ContactUsTestEn extends ApplicationManager {
    @Test
    public void contactPositive(){
        Allure.description("ContactUs test positive. All fields are filled");
        HomePageEn homePageEn = new HomePageEn(getDriver());
        ContactsPageEn contactsPageEn = clickButtonsOnHeaderEn(HeaderMenuItemsEn.CONTACT_US);
        contactsPageEn.fillNameField("Test");
        Allure.description("Name field is filled with 'Test'");
        contactsPageEn.fillEmailField("test@gmail.com");
        Allure.description("Email field  'test@gmail.com' ");
        contactsPageEn.fillMessageField("Automation testing");
        Allure.description("Message field  'Automation testing' ");
        contactsPageEn.clickBySendButton();
        Allure.description("Send button is clicked");
        Assert.assertEquals(contactsPageEn.getErrorMessage(), "404 Page Not Found");
    }
}
