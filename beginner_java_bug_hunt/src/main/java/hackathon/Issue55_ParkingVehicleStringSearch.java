public class Issue55_ParkingVehicleStringSearch {
    public static void main(String[] args) {
        String storedId = new String("ID-7");
        String requestedId = new String("ID-7");
        if (storedId == requestedId) System.out.println("Vehicle ID found");
        else System.out.println("Vehicle ID not found");
    }
}