package pages.music.tracks;

import static com.codeborne.selenide.Selenide.actions;
import com.codeborne.selenide.SelenideElement;

public class BaseMusicTrack {
    protected SelenideElement track;

    public BaseMusicTrack(SelenideElement track) {
        this.track = track;
    }

    public String getText() {
        return track.getText();
    }

    public void hover() {
        actions().moveToElement(track).build().perform();
    }
}
