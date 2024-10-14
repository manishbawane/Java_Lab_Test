package CinemaBooking;

import java.util.Scanner;

public class CinemaBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        int choice;

        do {
            System.out.println("\nCinema Booking System");
            System.out.println("1. Show Available Seats");
            System.out.println("2. Book a Ticket");
            System.out.println("3. Load Bookings from File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cinema.showAvailableSeats();
                    break;
                case 2:
                    try {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter row (0 to 4): ");
                        int row = scanner.nextInt();
                        System.out.print("Enter column (0 to 4): ");
                        int column = scanner.nextInt();
                        cinema.bookTicket(name, row, column);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    cinema.loadBookings();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

