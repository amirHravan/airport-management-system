package model;

public class Airplane {
    private String name;
    private final int capacity;
    private int availableSeats;

    public Airplane(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public void decrementAvailableSeats() {
        this.availableSeats--;
    }

    public boolean hasAvailableSeat() {
        return this.availableSeats > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

}
