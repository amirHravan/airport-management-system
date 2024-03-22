package enums;

import view.*;

import java.util.Scanner;

public enum Menu {
    AdminMenu(new AdminMenu()),
    MainMenu(new MainMenu()),
    CutumerMenu(new CustomerMenu()),
    LoginMenu(new LoginMenu()),
    Exit(new ExitMenu());

    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }

}
