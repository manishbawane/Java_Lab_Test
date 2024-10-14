package HotelManagement;

class Booking {
    private Room room;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;

    public Booking(Room room, String guestName, String checkInDate, String checkOutDate) {
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Room: " + room.getRoomNumber() + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate;
    }
}
