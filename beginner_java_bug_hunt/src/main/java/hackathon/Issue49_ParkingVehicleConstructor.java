public class Issue49_ParkingVehicleConstructor {
    static class Record {
        String id;
        String name;
        Record(String id, String name) {
            this.id = name;
            this.name = id;
        }
    }
    public static void main(String[] args) {
        Record record = new Record("X17", "Sample Vehicle");
        System.out.println("Vehicle number: " + record.id);
        System.out.println("Vehicle owner: " + record.name);
    }
}