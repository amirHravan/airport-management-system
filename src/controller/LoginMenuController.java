package controller;

import enums.Menu;
import model.*;

public class LoginMenuController {

    public Result register(String username, String password) {
        if (!isUsernameUnique(username)){
            return new Result(false, "a user exists with this username");
        }
        App.customers.add(new Customer(username, password));
        return new Result(true, "register successful");
    }

    public Result registerAsAdmin(String username, String password) {
        if (App.getAdmin() != null) {
            return new Result(false, "admin user already created");
        }
        if (!isUsernameUnique(username)){
            return new Result(false, "a user exists with this username");
        }
        App.setAdmin(new Admin(username, password));
        return new Result(true, "admin user created successfully");
    }

    public Result login(String username, String password) {
        User user = getCustomerByUsername(username);
        if (user == null) {
            if (App.getAdmin() != null && App.getAdmin().getUsername().equals(username)) {
                user = App.getAdmin();
            }
        }
        if (user == null) {
            return new Result(false, "no user exists with this username");
        }

        if (!user.getPassword().equals(password)) {
            return new Result(false, "incorrect password");
        }

        App.setLoggedInUser(user);
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "login successful");
    }

    public void exit() {
        App.setCurrentMenu(Menu.Exit);
    }

    private boolean isUsernameUnique(String username) {
        if (getCustomerByUsername(username) != null){
            return false;
        }
        if (App.getAdmin() != null && App.getAdmin().getUsername().equals(username)) {
            return false;
        }
        return true;
    }

    private Customer getCustomerByUsername(String username) {
        for (Customer customer : App.customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }
}
