package CinemaBooking;

import java.util.*;

class Booking {
    private String name;
    private int row;
    private int column;

    public Booking(String name, int row, int column) {
        this.name = name;
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Seat: [" + row + ", " + column + "]";
    }
}

