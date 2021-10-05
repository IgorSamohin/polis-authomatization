package pages;

import org.openqa.selenium.By;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    private final static By LOGIN_FIELD_LOCATOR = By.xpath("//*[@data-l='t,login' and @type='text']");
    private final static By PASSWORD_FIELD_LOCATOR = By.xpath("//*[@data-l='t,password' and @type='password']");
    private final static By LOGIN_BUTTON_LOCATOR = By.xpath("//*[@data-l='t,sign_in' and @type='submit']");

    public UserMainPage login(String login, String password){
        //todo
        return new UserMainPage();
    }
}
