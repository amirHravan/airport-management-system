package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MainMenuCommands {
    AdminMenu("admin menu"),
    CustomerMenu("customer menu"),
    Logout("logout");

    private final String pattern;

    MainMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMather(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);

        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
