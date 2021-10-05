package pages.Music;

import org.openqa.selenium.By;
import pages.base.LoggedUserBasePage;

import static com.codeborne.selenide.Selenide.$;

public class MusicMainPage extends LoggedUserBasePage {
    private final By GO_TO_MY_MUSIC = By.xpath("//*[@id='music_layer']/main/div/nav/wm-nav/a[1]");

    public MyMusicPage clickOnMyMusic(){
        $(GO_TO_MY_MUSIC).click();

        return new MyMusicPage();
    }
}
