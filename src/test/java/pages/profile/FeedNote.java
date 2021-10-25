package pages.profile;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import pages.base.LoggedUserBasePage;

public class FeedNote extends LoggedUserBasePage {
    private final SelenideElement note;
    public static final String NOTE_ACTIONS_LOCATOR = ".//*[@data-l='t,feed-actions-menu']";
    public static final String DELETE_NOTE_BUTTON_LOCATOR = ".//*[text()='Удалить заметку']";

    public FeedNote(SelenideElement nodeParent) {
        this.note = nodeParent;
    }

    public void delete() {
        note.scrollTo();
        note.$x(NOTE_ACTIONS_LOCATOR).hover().click();
        $x(DELETE_NOTE_BUTTON_LOCATOR).shouldBe(Condition.visible).click();
        note.$x(DELETE_NOTE_BUTTON_LOCATOR).click();
    }
}
