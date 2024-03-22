package controller;

import enums.Menu;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminMenuController {

    public Result addAirplane(String name, int capacity) {
        if (getAirplaneByName(name) != null) {
            return new Result(false, "an airplane exists with this name");
        }
        if (capacity <= 10) {
            return new Result(false, "invalid capacity");
        }
        App.airport.getAirplanes().add(new Airplane(name, capacity));
        return new Result(true, "plane created successfully");
    }

    public Result addFlight(City origin, City destination, Date date, String planeName, long priceAmount) {
        Airplane airplane = getAirplaneByName(planeName);
        if (airplane == null) {
            return new Result(false, "no airplane exists with this name");
        }
        for (Flight flight : App.airport.getFlights()) {
            if (flight.getAirplane().equals(airplane)) {
                if (flight.getDate().equals(date)) {
                    return new Result(false, "This aircraft already has a flight on this date");
                }
            }
        }
        App.airport.getFlights().add(new Flight(
                origin,
                destination,
                date,
                new Price(priceAmount),
                airplane
        ));
        return new Result(true, "flight created successfully");
    }

    public Result showBalance() {
        return new Result(true, String.valueOf(App.airport.getBalance()));
    }

    public Result showAllFlights() {
        return new Result(true, Flight.stringifyFlightList(App.airport.getFlights()));
    }

    public Result showFlightsOn(Date date) {
        ArrayList<Flight> targetFlights = new ArrayList<>();
        for (int i = 0; i < App.airport.getFlights().size(); i++) {
            Flight flight = App.airport.getFlights().get(i);
            if (flight.getDate().equals(date)) {
                targetFlights.add(flight);
            }
        }
        return new Result(true, Flight.stringifyFlightList(targetFlights));
    }

    public Result showAirplanes() {
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> flightCountMap = new HashMap<>();
        for (Flight flight : App.airport.getFlights()) {
            String airplaneName = flight.getAirplane().getName();
            flightCountMap.putIfAbsent(airplaneName, 1);
            flightCountMap.put(airplaneName, flightCountMap.get(airplaneName) + 1);
        }
        for (int i = 0; i < App.airport.getAirplanes().size(); i++) {
            Airplane airplane = App.airport.getAirplanes().get(i);
            result
                    .append(i+1)
                    .append("-")
                    .append(airplane.getName())
                    .append(" : ")
                    .append(flightCountMap.getOrDefault(airplane.getName(), 0))
                    .append("\n");
        }
        if (result.isEmpty()) {
            result.append("no airplanes!");
        }
        return new Result(true, result.toString());
    }

    public Result back() {
        App.setCurrentMenu(Menu.MainMenu);
        return new Result(true, "main menu");
    }

    private Airplane getAirplaneByName(String name) {
        for (Airplane airplane : App.airport.getAirplanes()) {
            if (airplane.getName().equals(name)) {
                return airplane;
            }
        }
        return null;
    }
}
