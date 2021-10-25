package pages.profile;

import static com.codeborne.selenide.Selenide.$x;
import pages.base.LoggedUserBasePage;

public class UserProfilePage extends LoggedUserBasePage {
    public static final String USER_STATUS_LOCATOR = "//*[@data-l='mtLocation,MAIN,state,userPage']";

    public static final String STATUS_FEED_NOTE_LOCATOR
            = "//*[@class='feed-w' and child::*//div[@class='feed_status']]";

    public UserProfilePage() {
    }

    public ProfileStatus getStatus() {
        return new ProfileStatus($x(USER_STATUS_LOCATOR));
    }

    public FeedNote getStatusNoteInFeed() {
        return new FeedNote($x(STATUS_FEED_NOTE_LOCATOR));
    }
}
