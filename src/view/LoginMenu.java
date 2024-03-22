package view;

import controller.LoginMenuController;
import enums.LoginMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu extends AppMenu {
    private final LoginMenuController controller = new LoginMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = LoginMenuCommands.Login.getMather(input)) != null) {
            System.out.println(controller.login(matcher.group("username"), matcher.group("password")));
        } else if ((matcher = LoginMenuCommands.Register.getMather(input)) != null) {
            System.out.println(controller.register(matcher.group("username"), matcher.group("password")));
        } else if ((matcher = LoginMenuCommands.RegisterAsAdmin.getMather(input)) != null) {
            System.out.println(controller.registerAsAdmin(matcher.group("username"), matcher.group("password")));
        } else if ((matcher = LoginMenuCommands.Exit.getMather(input)) != null) {
            controller.exit();
        } else {
            System.out.println("invalid command!");
        }
    }

}
