package RestaurantManagementSystem;

import java.util.Scanner;

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        restaurant.loadMenu(); // Load existing menu items from file
        int choice;

        do {
            System.out.println("\nRestaurant Management System");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Place an Order");
            System.out.println("4. Load Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Menu:");
                    for (MenuItem item : restaurant.getMenu()) {
                        System.out.println(item);
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter menu item name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter menu item price: ");
                        double price = scanner.nextDouble();
                        restaurant.addMenuItem(name, price);
                        System.out.println("Menu item added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    Order order = new Order();
                    boolean ordering = true;
                    while (ordering) {
                        System.out.print("Enter menu item name to add to order (or type 'done' to finish): ");
                        String itemName = scanner.nextLine();
                        if (itemName.equalsIgnoreCase("done")) {
                            ordering = false;
                        } else {
                            boolean found = false;
                            for (MenuItem item : restaurant.getMenu()) {
                                if (item.getName().equalsIgnoreCase(itemName)) {
                                    order.addItem(item);
                                    found = true;
                                    System.out.println(itemName + " added to order.");
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Item not found in menu.");
                            }
                        }
                    }
                    restaurant.placeOrder(order);
                    System.out.println("Order placed successfully!");
                    break;
                case 4:
                    restaurant.loadOrders();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
