package HotelManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addRoom(String roomNumber, String type) {
        Room room = new Room(roomNumber, type);
        rooms.add(room);
        saveRoomToFile(room);
    }

    public void bookRoom(String roomNumber, String guestName, String checkInDate, String checkOutDate) throws Exception {
        Room room = findRoom(roomNumber);
        if (room == null) {
            throw new Exception("Room not found.");
        }
        if (!room.isAvailable()) {
            throw new Exception("Room is already booked.");
        }
        Booking booking = new Booking(room, guestName, checkInDate, checkOutDate);
        bookings.add(booking);
        room.book();
        saveBookingToFile(booking);
    }

    public void freeRoom(String roomNumber) throws Exception {
        Room room = findRoom(roomNumber);
        if (room == null) {
            throw new Exception("Room not found.");
        }
        if (room.isAvailable()) {
            throw new Exception("Room is not booked.");
        }
        room.free();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    private Room findRoom(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    private void saveRoomToFile(Room room) {
        try (FileWriter writer = new FileWriter("rooms.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(room.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving room to file: " + e.getMessage());
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

    public void loadRooms() {
        try (BufferedReader br = new BufferedReader(new FileReader("rooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" \\(");
                String roomNumber = parts[0];
                String type = parts[1].split("\\)")[0];
                addRoom(roomNumber, type);
            }
        } catch (IOException e) {
            System.out.println("Error reading rooms from file: " + e.getMessage());
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
