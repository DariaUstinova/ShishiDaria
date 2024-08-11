package tests_ui;

import config.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePageRu;

public class LoginTestsRu extends ApplicationManager {

    @Test
    public void startPositiveTest(){
        HomePageRu homePageRu = new HomePageRu(getDriver());
    }
}
