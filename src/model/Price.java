package model;

public class Price {
    private long amount;

    public long getAmount() {
        return amount;
    }

    public Price(long price) {
        this.amount = price;
    }

    @Override
    public String toString() {
        return String.valueOf(this.amount);
    }
}
