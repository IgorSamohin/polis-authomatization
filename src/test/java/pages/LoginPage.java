package pages;

import pages.base.BasePage;

public class LoginPage extends BasePage {
    public UserMainPage login(String login, String password){

        return new UserMainPage();
    }
}
