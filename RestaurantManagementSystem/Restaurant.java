package RestaurantManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Restaurant {
    private List<MenuItem> menu;
    private List<Order> orders;

    public Restaurant() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(String name, double price) {
        MenuItem item = new MenuItem(name, price);
        menu.add(item);
        saveMenuToFile(item);
    }

    public void placeOrder(Order order) {
        orders.add(order);
        saveOrderToFile(order);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    private void saveMenuToFile(MenuItem item) {
        try (FileWriter writer = new FileWriter("menu.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(item.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving menu to file: " + e.getMessage());
        }
    }

    private void saveOrderToFile(Order order) {
        try (FileWriter writer = new FileWriter("orders.txt", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(order.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving order to file: " + e.getMessage());
        }
    }

    public void loadMenu() {
        try (BufferedReader br = new BufferedReader(new FileReader("menu.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" - \\$");
                if (parts.length == 2) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    addMenuItem(name, price);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading menu from file: " + e.getMessage());
        }
    }

    public void loadOrders() {
        try (BufferedReader br = new BufferedReader(new FileReader("orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading orders from file: " + e.getMessage());
        }
    }
}