public class Issue55_ParkingVehicleStringSearch {
    public static void main(String[] args) {
        String[] ids = new String[] {"A7", "B7", "C7"};
        String target = new String("B7");
        int found = 0;
        for (int i = 1; i < ids.length - 1; i++) { if (ids[i] == target) found = i; else found = i - 1; }
        System.out.println("Index=" + found);
    }
}
