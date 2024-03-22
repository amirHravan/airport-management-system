package view;

import controller.MainMenuController;
import enums.LoginMenuCommands;
import enums.MainMenuCommands;
import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu extends AppMenu {
    private final MainMenuController controller = new MainMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        if (MainMenuCommands.Logout.getMather(input) != null) {
            System.out.println(controller.logout());
        } else if (MainMenuCommands.AdminMenu.getMather(input) != null) {
            System.out.println(controller.navigateToAdminMenu());
        } else if (MainMenuCommands.CustomerMenu.getMather(input) != null) {
            System.out.println(controller.navigateToCustomerMenu());
        } else {
            System.out.println("invalid command!");
        }
    }
}
