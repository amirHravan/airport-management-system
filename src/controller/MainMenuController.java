package controller;

import enums.Menu;
import model.Admin;
import model.App;
import model.Customer;
import model.Result;

public class MainMenuController {

    public Result logout() {
        App.setCurrentMenu(Menu.LoginMenu);
        return new Result(true, "login menu");
    }
    public Result navigateToAdminMenu() {
        if (!App.getLoggedInUser().getClass().equals(Admin.class)) {
            return new Result(false, "you don't have access to this menu");
        }
        App.setCurrentMenu(Menu.AdminMenu);
        return new Result(true, "admin menu");
    }

    public Result navigateToCustomerMenu() {
        if (!App.getLoggedInUser().getClass().equals(Customer.class)) {
            return new Result(false, "you don't have access to this menu");
        }
        App.setCurrentMenu(Menu.CutumerMenu);
        return new Result(true, "customer menu");
    }
}
