package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPageEn;
import pages.HomePageEn;

import static pages.BasePage.clickButtonsOnHeaderEn;

public class ContactUsTestEn extends ApplicationManager {
    @Test
    public void startTest(){
        HomePageEn homePageEn = new HomePageEn(getDriver());
        ContactsPageEn contactsPageEn = clickButtonsOnHeaderEn(HeaderMenuItemsEn.CONTACT_US);
        contactsPageEn.fillNameField("Test");
        contactsPageEn.fillEmailField("test@gmail.com");
        contactsPageEn.fillMessageField("Automation testing");
        contactsPageEn.clickBySendButton();
        Assert.assertEquals(contactsPageEn.getErrorMessage(), "404 Page Not Found");
    }
}
