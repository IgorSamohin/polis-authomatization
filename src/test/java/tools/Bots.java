package tools;

public class Bots {
    private final String login = "technopolisbot";
    private final String password = "technopolis16";

    private Bots() {
    }

    public static Bots getBot() {
        return new Bots();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
