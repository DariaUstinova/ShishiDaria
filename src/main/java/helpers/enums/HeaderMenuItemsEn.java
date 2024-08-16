package helpers.enums;

public enum HeaderMenuItemsEn {
    ABOUT("//ul[@class='vertical medium-horizontal menu align-right show-for-medium show-for-large']/li[1]/a[@title='About Us']"),
    ACTIVITIES("//ul[@class='vertical medium-horizontal menu align-right show-for-medium show-for-large']/li[2]/a[@title='Activities']"),
    OUR_TEAM("//ul[@class='vertical medium-horizontal menu align-right show-for-medium show-for-large']/li[3]/a[@title='Our Team']"),

    CONTACT_US("//ul[@class='vertical medium-horizontal menu align-right show-for-medium show-for-large']/li[7]/a[@title='Contact Us']");

    private final String locator;

    HeaderMenuItemsEn(String locator) {
        this.locator = locator;
    }
    public String getLocator(){
        return locator;
    }
}
