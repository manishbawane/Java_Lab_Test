package AirlineBooking;

public class TestAirlineBooking {
    public static void main(String[] args) {
        AirlineBookingSystem system = new AirlineBookingSystem();
        system.addFlight("AA101", "New York", "2024-12-01 10:00", 100, 250);
        system.addFlight("BB202", "Los Angeles", "2024-12-02 11:00", 50, 300);
        
        system.displayFlights();
        
        system.bookTicket("AA101", "C001", 2);
        
        system.displayBookings();
    }
}