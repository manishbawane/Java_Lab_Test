package AirlineBooking;

import java.io.*;
import java.util.*;

class Flight {
    private String flightId;
    private String destination;
    private String departureTime;
    private int availableSeats;
    private double ticketPrice;

    public Flight(String flightId, String destination, String departureTime, int availableSeats, double ticketPrice) {
        this.flightId = flightId;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public String getFlightId() {
        return flightId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "Flight ID: " + flightId + ", Destination: " + destination + ", Departure: " + departureTime + ", Available Seats: " + availableSeats + ", Ticket Price: $" + ticketPrice;
    }
}

class Customer {
    private String customerId;
    private String customerName;
    private String contactNumber;

    public Customer(String customerId, String customerName, String contactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + customerName + ", Contact: " + contactNumber;
    }
}

class Booking {
    private int bookingId;
    private String flightId;
    private String customerId;
    private int numTickets;

    public Booking(int bookingId, String flightId, String customerId, int numTickets) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.customerId = customerId;
        this.numTickets = numTickets;
    }

    public double totalCost(double ticketPrice) {
        return numTickets * ticketPrice;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Flight ID: " + flightId + ", Customer ID: " + customerId + ", Tickets: " + numTickets;
    }
}

class AirlineBookingSystem {
    private Map<String, Flight> flights = new HashMap<>();
    private Map<String, Customer> customers = new HashMap<>();
    private Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;

    public void loadData() {
        // Load data from files (this can be implemented)
    }

    public void saveData() {
        // Save data to files (this can be implemented)
    }

    public void addFlight(String flightId, String destination, String departureTime, int availableSeats, double ticketPrice) {
        Flight flight = new Flight(flightId, destination, departureTime, availableSeats, ticketPrice);
        flights.put(flightId, flight);
        saveData();
    }

    public void updateFlight(String flightId, Integer availableSeats, Double ticketPrice) {
        Flight flight = flights.get(flightId);
        if (flight != null) {
            if (availableSeats != null) {
                flight.setAvailableSeats(availableSeats);
            }
            if (ticketPrice != null) {
                // Update the ticket price if needed (additional logic would be required)
            }
            saveData();
        } else {
            System.out.println("Flight not found.");
        }
    }

    public void cancelFlight(String flightId) {
        if (flights.remove(flightId) != null) {
            saveData();
        } else {
            System.out.println("Flight not found.");
        }
    }

    public void bookTicket(String flightId, String customerId, int numTickets) {
        Flight flight = flights.get(flightId);
        if (flight != null) {
            if (flight.getAvailableSeats() >= numTickets) {
                Booking booking = new Booking(bookingCounter++, flightId, customerId, numTickets);
                bookings.put(bookingCounter - 1, booking);
                flight.setAvailableSeats(flight.getAvailableSeats() - numTickets);
                System.out.println("Booking successful! Total cost: $" + booking.totalCost(flight.getTicketPrice()));
                saveData();
            } else {
                System.out.println("Not enough available seats.");
            }
        } else {
            System.out.println("Flight not found.");
        }
    }

    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights.values()) {
            System.out.println(flight);
        }
    }

    public void displayBookings() {
        System.out.println("Booking History:");
        for (Booking booking : bookings.values()) {
            System.out.println(booking);
        }
    }
}



