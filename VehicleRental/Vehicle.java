package VehicleRental;

import java.io.*;
import java.util.*;

class Vehicle {
    private String name;
    private String type;
    private boolean available;

    public Vehicle(String name, String type) {
        this.name = name;
        this.type = type;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        this.available = false;
    }

    public void returnVehicle() {
        this.available = true;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - " + (available ? "Available" : "Rented");
    }
}




