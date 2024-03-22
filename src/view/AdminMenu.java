package view;

import controller.AdminMenuController;
import enums.AdminMenuCommands;
import model.City;
import model.Date;

import java.util.Scanner;
import java.util.regex.Matcher;

public class AdminMenu extends AppMenu {
    private final AdminMenuController controller = new AdminMenuController();
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if (AdminMenuCommands.ShowAirplanes.getMather(input) != null) {
            System.out.println(controller.showAirplanes());
        } else if ((matcher = AdminMenuCommands.AddAirplane.getMather(input)) != null) {
            System.out.println(controller.addAirplane(
                    matcher.group("name"),
                    Integer.parseInt(matcher.group("capacity"))
            ));
        } else if ((matcher = AdminMenuCommands.AddFlight.getMather(input)) != null) {
            System.out.println(controller.addFlight(
                    new City(matcher.group("origin")),
                    new City(matcher.group("destination")),
                    new Date(matcher.group("date")),
                    matcher.group("airplaneName"),
                    Long.parseLong(matcher.group("ticketPrice"))
            ));
        } else if (AdminMenuCommands.ShowAllFlights.getMather(input) != null) {
            System.out.println(controller.showAllFlights());;
        } else  if (AdminMenuCommands.ShowBalance.getMather(input) != null) {
            System.out.println(controller.showBalance());;
        } else  if ((matcher = AdminMenuCommands.ShowFlightOn.getMather(input)) != null) {
            System.out.println(controller.showFlightsOn(new Date(matcher.group("date"))));;
        } else  if (AdminMenuCommands.Back.getMather(input) != null) {
            System.out.println(controller.back());
        } else {
            System.out.println("invalid command!");
        }
    }
}
