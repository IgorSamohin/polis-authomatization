package tests;

import org.junit.jupiter.api.BeforeEach;
import pages.UserMainPage;

public class MusicTestBase extends TestBase {
    @BeforeEach
    public void beforeMusic() {
        new UserMainPage()
                .clickOnMusicMainPage();
    }
}
