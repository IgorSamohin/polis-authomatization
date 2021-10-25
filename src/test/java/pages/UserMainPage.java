package pages;

import static com.codeborne.selenide.Selenide.*;
import pages.base.LoggedUserBasePage;
import pages.profile.UserProfilePage;

public class UserMainPage extends LoggedUserBasePage {
    public static final String USER_PROFILE_LOCATOR = "//*[@data-l='t,userPage']";

    public UserMainPage() {

    }

    public UserProfilePage clickOnUserProfilePage() {
        $x(USER_PROFILE_LOCATOR).click();
        return new UserProfilePage();
    }
}

