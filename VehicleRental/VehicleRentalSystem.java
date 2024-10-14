package VehicleRental;

import java.util.Scanner;

public class VehicleRentalSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VehicleRental rentalService = new VehicleRental();
		rentalService.loadInventory(); // Load existing vehicles from file
		int choice;

		do {
			System.out.println("\nVehicle Rental System");
			System.out.println("1. View Inventory");
			System.out.println("2. Add Vehicle");
			System.out.println("3. Rent Vehicle");
			System.out.println("4. Return Vehicle");
			System.out.println("5. Load Rentals");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.println("Inventory:");
				for (Vehicle vehicle : rentalService.getInventory()) {
					System.out.println(vehicle);
				}
				break;
			case 2:
				try {
					System.out.print("Enter vehicle name: ");
					String name = scanner.nextLine();
					System.out.print("Enter vehicle type: ");
					String type = scanner.nextLine();
					rentalService.addVehicle(name, type);
					System.out.println("Vehicle added successfully!");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.print("Enter vehicle name to rent: ");
					String vehicleName = scanner.nextLine();
					System.out.print("Enter renter name: ");
					String renterName = scanner.nextLine();
					System.out.print("Enter rental period: ");
					String rentalPeriod = scanner.nextLine();
					rentalService.rentVehicle(vehicleName, renterName, rentalPeriod);
					System.out.println("Vehicle rented successfully!");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.print("Enter vehicle name to return: ");
					String vehicleName = scanner.nextLine();
					rentalService.returnVehicle(vehicleName);
					System.out.println("Vehicle returned successfully!");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 5:
				rentalService.loadRentals();
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
