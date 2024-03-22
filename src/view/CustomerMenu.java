package view;

import controller.CustomerMenuController;
import enums.CustomerMenuCommands;
import model.App;
import model.City;
import model.Customer;
import model.Result;

import java.util.Scanner;
import java.util.regex.Matcher;

public class CustomerMenu extends AppMenu {
    private final CustomerMenuController controller = new CustomerMenuController();
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = CustomerMenuCommands.PurchaseTicket.getMather(input)) != null) {
            Result result = controller.getAvailableDirectTickets(
                    new City(matcher.group("origin")),
                    new City(matcher.group("destination"))
            );
            System.out.println(result);
            if (!result.isSuccessful()) {
                System.out.println((controller.getNonDirectAvailableTickets(
                        new City(matcher.group("origin")),
                        new City(matcher.group("destination"))
                )));
            }

            String innerInput;
            Result innerResult;
            do {
                innerInput = scanner.nextLine();
                if (!innerInput.equals("end")) {
                    if (result.isSuccessful()) {
                        innerResult = controller.buyDirectFlightByIndex(
                                (Customer) App.getLoggedInUser(),
                                Integer.parseInt(innerInput) - 1
                        );
                    } else {
                        innerResult = controller.buyNonDirectFlightByIndex(
                                (Customer) App.getLoggedInUser(),
                                Integer.parseInt(innerInput) - 1
                        );
                    }
                    System.out.println(innerResult);
                    if (innerResult.isSuccessful()) {
                        break;
                    }
                }
            } while (!innerInput.equals("end"));

        } else if (CustomerMenuCommands.CancelTicket.getMather(input) != null) {
            System.out.println(controller.showBoughtTickets((Customer) App.getLoggedInUser()));
            String innerInput;
            do {
                innerInput = scanner.nextLine();
                if (!innerInput.equals("end")){
                    Result result = controller.cancelTicket((Customer) App.getLoggedInUser(), Integer.parseInt(innerInput));
                    System.out.println(result);
                    if (result.isSuccessful()) {
                        break;
                    }
                }
            } while (!innerInput.equals("end"));
        } else if ((matcher = CustomerMenuCommands.ChargeAccount.getMather(input)) != null) {
            System.out.println(controller.chargeAccount(Integer.parseInt(matcher.group("amount"))));
        } else if (CustomerMenuCommands.Back.getMather(input) != null) {
            System.out.println(controller.back());
        } else if (CustomerMenuCommands.ShowBalance.getMather(input) != null) {
            System.out.println(controller.showBalance());
        } else {
            System.out.println("invalid command!");
        }
    }
}
