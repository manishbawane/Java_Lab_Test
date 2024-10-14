package VehicleRental;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class VehicleRental {
    private List<Vehicle> inventory;
    private List<Rental> rentals;

    public VehicleRental() {
        this.inventory = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addVehicle(String name, String type) {
        Vehicle vehicle = new Vehicle(name, type);
        inventory.add(vehicle);
        saveVehicleToFile(vehicle);
    }

    public void rentVehicle(String vehicleName, String renterName, String rentalPeriod) throws Exception {
        Vehicle vehicle = findVehicle(vehicleName);
        if (vehicle == null) {
            throw new Exception("Vehicle not found.");
        }
        if (!vehicle.isAvailable()) {
            throw new Exception("Vehicle is currently rented.");
        }
        Rental rental = new Rental(vehicle, renterName, rentalPeriod);
        rentals.add(rental);
        vehicle.rent();
        saveRentalToFile(rental);
    }

    public void returnVehicle(String vehicleName) throws Exception {
        Vehicle vehicle = findVehicle(vehicleName);
        if (vehicle == null) {
            throw new Exception("Vehicle not found.");
        }
        if (vehicle.isAvailable()) {
            throw new Exception("Vehicle is not rented.");
        }
        vehicle.returnVehicle();
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    private Vehicle findVehicle(String name) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getName().equalsIgnoreCase(name)) {
                return vehicle;
            }
        }
        return null;
    }

    private void saveVehicleToFile(Vehicle vehicle) {
        try (FileWriter writer = new FileWriter("vehicles.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(vehicle.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving vehicle to file: " + e.getMessage());
        }
    }

    private void saveRentalToFile(Rental rental) {
        try (FileWriter writer = new FileWriter("rentals.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(rental.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving rental to file: " + e.getMessage());
        }
    }

    public void loadInventory() {
        try (BufferedReader br = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" \\(");
                String name = parts[0];
                String type = parts[1].split("\\)")[0];
                addVehicle(name, type);
            }
        } catch (IOException e) {
            System.out.println("Error reading inventory from file: " + e.getMessage());
        }
    }

    public void loadRentals() {
        try (BufferedReader br = new BufferedReader(new FileReader("rentals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading rentals from file: " + e.getMessage());
        }
    }
}
