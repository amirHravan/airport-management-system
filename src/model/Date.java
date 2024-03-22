package model;

import java.util.Objects;

public class Date {
    private final int year;
    private final int month;
    private final int day;

    // yyyy-mm-dd
    public Date(String formatDate) {
        String[] args = formatDate.split("-");
        this.year = Integer.parseInt(args[0]);
        this.month = Integer.parseInt(args[1]);
        this.day = Integer.parseInt(args[2]);
    }

    public int compareTo(Date that) {
        return (this.year-that.year)*365 + (this.month-that.month)*30 + (this.day-that.day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(year, date.year) && Objects.equals(month, date.month) && Objects.equals(day, date.day);
    }

    @Override
    public String toString() {
        return this.year+"-"+this.month+"-"+this.day;
    }
}
