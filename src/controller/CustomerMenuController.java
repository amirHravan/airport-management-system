package controller;

import enums.Menu;
import model.*;

import java.util.ArrayList;

public class CustomerMenuController {
    private ArrayList<FlightPair> flightPairs;
    private ArrayList<Flight> flights;

    public Result getAvailableDirectTickets(City origin, City destination) {
        ArrayList<Flight> result = filterByOriginAndDestination(App.airport.getFlights(), origin, destination);
        this.flights = result;
        if (result.isEmpty()) {
            return new Result(false, "There is no direct flight from " + origin.toString() + " to " + destination.toString());
        } else {
            return new Result(true, Flight.stringifyFlightList(result));
        }
    }

    public Result getNonDirectAvailableTickets(City origin, City destination) {
        String output = stringifyFlightPairList(getNonDirectFlightsMap(origin, destination));
        return new Result(true, output);
    }

    private ArrayList<FlightPair> getNonDirectFlightsMap(City origin, City destination) {
        ArrayList<FlightPair> result = new ArrayList<>();
        ArrayList<Flight> originFilteredFlights = filterByOrigin(App.airport.getFlights(), origin);
        ArrayList<Flight> destinationFilteredFlights = filterByDestination(App.airport.getFlights(), destination);
        for (Flight originFilteredFlight : originFilteredFlights) {
            for (Flight destinationFilteredFlight : destinationFilteredFlights) {
                if (originFilteredFlight.getDestination().equals(destinationFilteredFlight.getOrigin()) && originFilteredFlight.getDate().compareTo(destinationFilteredFlight.getDate()) < 0) {
                    result.add(new FlightPair(originFilteredFlight, destinationFilteredFlight));
                }
            }
        }
        flightPairs = result;
        return result;
    }

    private String stringifyFlightPairList(ArrayList<FlightPair> flightPairList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < flightPairList.size(); i++) {
            FlightPair flightPair = flightPairList.get(i);
            stringBuilder.append(i + 1).append("-").append(flightPair.getFirst().toString()).append(" | ").append(flightPair.getSecond().toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public Result buyNonDirectFlightByIndex(Customer customer, int index) {
        FlightPair flightPair = flightPairs.get(index);
        Result firstResult = this.buyFlight(customer, flightPair.getFirst());
        Result secondResult = this.buyFlight(customer, flightPair.getSecond());
        return firstResult;
    }

    private Result buyFlight(Customer customer, Flight flight) {
        if (!flight.getAirplane().hasAvailableSeat()) {
            return new Result(false, "no empty seat");
        }
        if (!customer.canPurchaseTicket(flight)) {
            return new Result(false, "you don't have enough money");
        }

        customer.purchaseTicket(flight);
        flight.getAirplane().decrementAvailableSeats();
        App.airport.increaseBalance(flight.getPrice().getAmount());

        return new Result(true, "purchase successful");
    }

    public Result buyDirectFlightByIndex(Customer customer, int index) {
        Flight flight = this.flights.get(index);
        return this.buyFlight(customer, flight);
    }


    public Result showBoughtTickets(Customer customer) {
        if (!customer.hasAnyTicket()) {
            return new Result(false, "you don't have any tickets");
        }
        return new Result(true, Flight.stringifyFlightList(customer.getPurchasedFlights()));
    }

    public Result cancelTicket(Customer customer, int index) {
        Flight flight = customer.getPurchasedFlights().get(index);
        customer.cancelTicket(flight);
        App.airport.increaseBalance(flight.getPrice().getAmount() * -1);
        return new Result(true, "cancel successful");
    }

    public Result showBalance() {
        Customer customer = (Customer) App.getLoggedInUser();
        return new Result(true, String.valueOf(customer.getBalance()));
    }

    public Result chargeAccount(long amount) {
        if (amount == 0) {
            return new Result(false, "invalid amount");
        }
        ((Customer) App.getLoggedInUser()).increaseBalance(amount);
        return new Result(true, "account charged successfully");
    }

    public Result back() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "main menu");
    }

    private ArrayList<Flight> filterByOriginAndDestination(ArrayList<Flight> flights, City origin, City destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    private ArrayList<Flight> filterByOrigin(ArrayList<Flight> flights, City origin) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin)) {
                result.add(flight);
            }
        }
        return result;
    }


    private ArrayList<Flight> filterByDestination(ArrayList<Flight> flights, City destination) {
        ArrayList<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equals(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

}
