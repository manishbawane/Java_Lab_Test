package HotelManagement;

import java.io.*;
import java.util.*;

class Room {
    private String roomNumber;
    private String type;
    private boolean available;

    public Room(String roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.available = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        this.available = false;
    }

    public void free() {
        this.available = true;
    }

    @Override
    public String toString() {
        return roomNumber + " (" + type + ") - " + (available ? "Available" : "Booked");
    }
}




