package model;

import java.util.ArrayList;

public class Airport {
    private final ArrayList<Airplane> airplanes;
    private final ArrayList<Flight> flights;
    private long balance;

    public Airport() {
        this.airplanes = new ArrayList<>();
        this.balance = 0;
        this.flights = new ArrayList<>();
    }

    public ArrayList<Airplane> getAirplanes() {
        return airplanes;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void increaseBalance(long amount) {
        this.balance += amount;
    }

    public long getBalance() {
        return balance;
    }
}
