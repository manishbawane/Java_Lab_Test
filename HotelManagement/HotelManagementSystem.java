package HotelManagement;

import java.util.Scanner;

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        hotel.loadRooms(); // Load existing rooms from file
        int choice;

        do {
            System.out.println("\nHotel Management System");
            System.out.println("1. View Rooms");
            System.out.println("2. Add Room");
            System.out.println("3. Book Room");
            System.out.println("4. Free Room");
            System.out.println("5. Load Bookings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Rooms:");
                    for (Room room : hotel.getRooms()) {
                        System.out.println(room);
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter room number: ");
                        String roomNumber = scanner.nextLine();
                        System.out.print("Enter room type: ");
                        String type = scanner.nextLine();
                        hotel.addRoom(roomNumber, type);
                        System.out.println("Room added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter room number to book: ");
                        String roomNumber = scanner.nextLine();
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.nextLine();
                        System.out.print("Enter check-in date (YYYY-MM-DD): ");
                        String checkInDate = scanner.nextLine();
                        System.out.print("Enter check-out date (YYYY-MM-DD): ");
                        String checkOutDate = scanner.nextLine();
                        hotel.bookRoom(roomNumber, guestName, checkInDate, checkOutDate);
                        System.out.println("Room booked successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter room number to free: ");
                        String roomNumber = scanner.nextLine();
                        hotel.freeRoom(roomNumber);
                        System.out.println("Room freed successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    hotel.loadBookings();
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

