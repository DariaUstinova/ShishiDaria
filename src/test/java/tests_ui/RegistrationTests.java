package tests_ui;

import config.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateUserPageRu;
import pages.HomePageRu;

import static pages.BasePage.*;

public class RegistrationTests extends ApplicationManager {
    CreateUserPageRu createUserPageRu;
    @BeforeMethod
    public void goToCreateUserPageRu(){
        new HomePageRu(getDriver());
        createUserPageRu = clickBtnRegistrationHeader();
    }
    @Test
    public void startPositiveTest(){
        pause(3);

    }
}
