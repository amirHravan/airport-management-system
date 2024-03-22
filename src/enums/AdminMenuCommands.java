package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AdminMenuCommands {
    AddAirplane("add airplane (?<name>[\\w]+)\\s+(?<capacity>[\\d]+)"),
    AddFlight("add flight\\s+(?<origin>[\\w]+)\\s+(?<destination>[\\w]+)\\s+(?<date>\\d{4}-\\d{2}-\\d{2})\\s+(?<airplaneName>[\\w]+)\\s+(?<ticketPrice>[\\d]+)"),
    ShowAllFlights("show all flights"),
    ShowFlightOn("show flights on (?<date>\\d{4}-\\d{2}-\\d{2})"),
    ShowAirplanes("show airplanes"),
    ShowBalance("show balance"),
    Back("back");
    private final String pattern;

    AdminMenuCommands(String pattern) {
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
