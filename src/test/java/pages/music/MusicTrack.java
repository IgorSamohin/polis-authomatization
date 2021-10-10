package pages.music;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.actions;

public class MusicTrack {
    private static final By ADD_MUSIC_TO_MY_MUSIC = By.xpath("//*[@name='controls']//*[@data-l='t,add']");
    private static final By REMOVE_MUSIC_FROM_MY_MUSIC = By.xpath("//*[@name='controls']//*[@data-tsid='remove_track']");

    private WebElement track;

    public MusicTrack(WebElement track) {
        this.track = track;
    }

    public void addTrackToFavorite() {
        actions().moveToElement(track).build().perform();
        track.findElement(ADD_MUSIC_TO_MY_MUSIC).click();
    }

    public void removeTrackFromFavorite() {
        actions().moveToElement(track).build().perform();
        track.findElement(REMOVE_MUSIC_FROM_MY_MUSIC).click();
    }

    public String getText() {
        return track.getText();
    }
}
