public class Issue51_ParkingVehicleObjectCreation {
    static class Summary {
        String name = "";
        int activeCount = 0;
        Summary() {}
        Summary(String name, int activeCount) { this.name = name; this.activeCount = activeCount; }
    }
    public static void main(String[] args) {
        Summary summary = new Summary();
        System.out.println("Vehicle owner: " + summary.name);
        System.out.println("Active Vehicles: " + summary.activeCount);
    }
}