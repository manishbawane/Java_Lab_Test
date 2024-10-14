package VehicleRental;

class Rental {
    private Vehicle vehicle;
    private String renterName;
    private String rentalPeriod;

    public Rental(Vehicle vehicle, String renterName, String rentalPeriod) {
        this.vehicle = vehicle;
        this.renterName = renterName;
        this.rentalPeriod = rentalPeriod;
    }

    @Override
    public String toString() {
        return "Renter: " + renterName + ", Vehicle: " + vehicle.getName() + ", Rental Period: " + rentalPeriod;
    }
}

