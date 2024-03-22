package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommands {
    Register("register\\s+(?<username>[\\w]+)\\s+(?<password>[\\w\\d]+)"),
    RegisterAsAdmin("register as admin\\s+(?<username>[\\w]+)\\s+(?<password>[\\w\\d]+)"),
    Login("login\\s+(?<username>[\\w]+)\\s+(?<password>[\\w\\d]+)"),
    ChangePassword("change password\\s+(?<username>[\\w]+)\\s+(?<oldPassword>[\\w\\d]+)\\s+(?<newPassword>[\\w\\d]+)"),
    RemoveAccount("remove account\\s+(?<username>[\\w]+)\\s+(?<password>[\\w\\d]+)"),
    Exit("exit");
    private final String pattern;

    LoginMenuCommands(String pattern) {
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
