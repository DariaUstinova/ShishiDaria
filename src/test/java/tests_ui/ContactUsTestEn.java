package tests_ui;

import config.ApplicationManager;
import helpers.enums.HeaderMenuItemsEn;
import org.testng.annotations.Test;
import pages.ContactUsPageEn;
import pages.HomePageEn;

import static pages.BasePage.clickButtonsOnHeaderEn;

public class ContactUsTestEn extends ApplicationManager {
    @Test
    public void startTest(){
        HomePageEn homePageEn = new HomePageEn(getDriver());
        ContactUsPageEn contactUsPageEn = clickButtonsOnHeaderEn(HeaderMenuItemsEn.CONTACT_US);
        contactUsPageEn.fillNameField("Test");
        contactUsPageEn.fillEmailField("d281217@gmail.com");
        contactUsPageEn.fillMessageField("Automation testing");
        contactUsPageEn.clickBySendButton();

    }
}
