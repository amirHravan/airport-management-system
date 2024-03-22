package model;

import java.util.ArrayList;

public class Customer extends User {
    private long balance;
    private final ArrayList<Flight> purchasedFlights;

    public Customer(String username, String password) {
        super(username, password);
        this.balance = 0;
        this.purchasedFlights = new ArrayList<>();
    }

    public void cancelTicket(Flight flight) {
        this.purchasedFlights.remove(flight);
        this.increaseBalance(flight.getPrice().getAmount());
    }
    public boolean canPurchaseTicket(Flight flight) {
        return this.balance >= flight.getPrice().getAmount();
    }
    public void purchaseTicket(Flight flight) {
        this.increaseBalance(flight.getPrice().getAmount()*-1);
        this.purchasedFlights.add(flight);
    }

    public boolean hasAnyTicket() {
        return !this.purchasedFlights.isEmpty();
    }

    public long getBalance() {
        return balance;
    }

    public void increaseBalance(long amount) {
        this.balance += amount;
    }

    public ArrayList<Flight> getPurchasedFlights() {
        return purchasedFlights;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
