package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CustomerMenuCommands {
    PurchaseTicket("purchase ticket\\s+(?<origin>[\\w\\d]+)\\s+(?<destination>[\\w\\d]+)"),
    ChargeAccount("charge account\\s+(?<amount>\\d+)"),
    CancelTicket("cancel ticket"),
    ShowBalance("show balance"),
    Back("back");

    private final String pattern;

    CustomerMenuCommands(String pattern) {
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
