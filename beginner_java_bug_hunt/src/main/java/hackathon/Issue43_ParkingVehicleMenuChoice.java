public class Issue43_ParkingVehicleMenuChoice {
    public static void main(String[] args) {
        int option = 2;
        int balance = 50;
        int amount = 10;
        String action;
        if (option == 1) { balance += amount; action = "Added"; }
        else if (option == 2) { balance += amount; action = "Cancelled"; }
        else if (option == 3) { balance -= amount; action = "Returned"; }
        else { action = "Invalid option"; }
        System.out.println(action + ": " + balance);
    }
}
