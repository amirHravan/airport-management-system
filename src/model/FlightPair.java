package model;

public class FlightPair {
    private final Flight first;
    private final Flight second;

    public FlightPair(Flight first, Flight second) {
        this.first = first;
        this.second = second;
    }

    public Flight getFirst() {
        return first;
    }

    public Flight getSecond() {
        return second;
    }
}
