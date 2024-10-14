package CinemaBooking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Cinema {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private boolean[][] seats = new boolean[ROWS][COLUMNS];
    private List<Booking> bookings = new ArrayList<>();

    public void showAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (seats[i][j]) {
                    System.out.print("[X] "); // Booked
                } else {
                    System.out.print("[O] "); // Available
                }
            }
            System.out.println();
        }
    }

    public void bookTicket(String name, int row, int column) throws Exception {
        if (row < 0 || row >= ROWS || column < 0 || column >= COLUMNS) {
            throw new IllegalArgumentException("Invalid seat number.");
        }

        if (seats[row][column]) {
            throw new Exception("This seat is already booked.");
        } else {
            seats[row][column] = true;
            Booking booking = new Booking(name, row, column);
            bookings.add(booking);
            saveBookingToFile(booking);
            System.out.println("Ticket booked successfully for seat [" + row + ", " + column + "]!");
        }
    }

    private void saveBookingToFile(Booking booking) {
        try (FileWriter writer = new FileWriter("bookings.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(booking.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving booking to file: " + e.getMessage());
        }
    }

    public void loadBookings() {
        try (BufferedReader br = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings from file: " + e.getMessage());
        }
    }
}
