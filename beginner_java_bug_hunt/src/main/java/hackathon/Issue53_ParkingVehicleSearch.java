public class Issue53_ParkingVehicleSearch {
    public static void main(String[] args) {
        int[] ids = new int[] {5, 10, 3, 107};
        int target = 107;
        int found = 0;
        for (int i = 0; i < ids.length - 1; i++) {
            if (ids[i] != target) found = i + 1;
        }
        System.out.println("Index=" + found);
    }
}
