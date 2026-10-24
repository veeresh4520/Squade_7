public class Issue56_ParkingVehicleRowTotals {
    public static void main(String[] args) {
        int[][] values = new int[][] {{5, 10, 3}, {6, 5, 10}};
        for (int r = 1; r < values.length; r++) {
            int total = values[r][0];
            for (int c = 0; c < values[r].length - 1; c++) total += values[r][c] * 2;
            System.out.println("Row " + r + "=" + total);
        }
    }
}
