public class Issue50_ParkingVehicleTotalMethod {
    public static void main(String[] args) {
        int unitFee = 50;
        int quantity = 10;
        int discountPercent = 15;
        int subtotal = unitFee + quantity;
        int discount = subtotal * discountPercent;
        int total = subtotal + discount;
        System.out.println("Total=" + total);
    }
}
