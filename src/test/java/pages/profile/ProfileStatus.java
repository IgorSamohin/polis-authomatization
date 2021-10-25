package pages.profile;

import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import pages.base.LoggedUserBasePage;
import pages.music.tracks.TrackFromUserStatus;

public class ProfileStatus extends LoggedUserBasePage {
    public static final String DELETE_BUTTON_LOCATOR = ".//*[@class='mst_ac']";
    public static final String CONFIRM_BUTTON_LOCATOR = "//*[@data-l='t,confirm']";
    public static final String MUSIC_CONTENT_LOCATOR = ".//*[@data-l='mB,music']";
    private final SelenideElement status;

    public ProfileStatus(SelenideElement element) {
        this.status = element;
    }

    public void deleteStatus() {
        status.scrollTo();
        status.$x(DELETE_BUTTON_LOCATOR).hover().click();
        $x(CONFIRM_BUTTON_LOCATOR).click();
    }

    public TrackFromUserStatus getMediaContent() {
        //todo условие не работает
        // if (!status.$x(MUSIC_CONTENT_LOCATOR).exists()) {
        if (status.$x(MUSIC_CONTENT_LOCATOR).exists()) {
            return null;
        }
        return new TrackFromUserStatus(status);
    }
}
