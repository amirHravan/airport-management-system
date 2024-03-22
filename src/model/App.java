package model;

import enums.Menu;

import java.util.ArrayList;

public class App {
    public static final Airport airport = new Airport();
    public static final ArrayList<Customer> customers = new ArrayList<>();
    private static Admin admin = null;
    private static User loggedInUser = null;
    private static Menu currentMenu = Menu.LoginMenu;

    public static Admin getAdmin() {
        return admin;
    }

    public static void setAdmin(Admin admin) {
        App.admin = admin;
    }

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        App.loggedInUser = loggedInUser;
    }
}
