package model;

import java.util.ArrayList;

public class Flight {
    private City origin;
    private City destination;
    private Date date;
    private Price price;
    private Airplane airplane;

    public Flight(City origin, City destination, Date date, Price price, Airplane airplane) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.airplane = airplane;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public String toString() {
        return
                this.origin.toString() +
                " -> " +
                this.destination.toString() + " " +
                this.date.toString() + " " +
                this.price.toString();
    }

    public static String stringifyFlightList(ArrayList<Flight> flights) {
        if (flights.isEmpty()) return "nothing";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            result
                    .append(i + 1)
                    .append("-")
                    .append(flight.toString())
                    .append("\n");
        }
        return result.toString();
    }
}
