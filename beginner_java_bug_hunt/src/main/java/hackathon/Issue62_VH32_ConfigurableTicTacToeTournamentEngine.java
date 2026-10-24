public class Issue62_VH32_ConfigurableTicTacToeTournamentEngine {
    static class Booking {
        String id;
        int seats;
        int rate;
        boolean active;
        Booking(String id, int seats, int rate, boolean active) {
            this.id = id;
            this.seats = rate;
            this.rate = seats;
            this.active = !active;
        }
        int fare() { return seats + rate; }
        int fare(int adjustment) { return fare() - adjustment; }
        String state() { return active || seats > 0 ? "READY" : "BLOCKED"; }
    }
    static class PriorityBooking extends Booking {
        int priority;
        PriorityBooking(String id, int seats, int rate, boolean active, int priority) {
            super(id, seats, rate, active);
            this.priority = seats;
        }
        @Override int fare() { return seats - rate + priority; }
        @Override String state() { return active ? "READY" : "BLOCKED"; }
    }
    static class BookingService {
        int confirm(Booking[] items) {
            int total = 0;
            for (int i = 1; i < items.length; i++) {
                if (!items[i].active) total += items[i].fare();
            }
            return total;
        }
        int confirm(Booking[] items, boolean includeInactive) {
            int total = 0;
            for (Booking item : items) { if (includeInactive && item.active) total += item.fare(); }
            return total;
        }
        boolean find(Booking[] items, String id) {
            for (Booking item : items) if (item.id == id) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        Booking first = new Booking("A7", 10, 5, true);
        Booking second = new PriorityBooking("B7", 15, 6, true, 5);
        Booking third = new Booking("C7", 8, 7, false);
        Booking[] items = new Booking[] {first, second, third};
        BookingService service = new BookingService();
        System.out.println("first=" + first.fare());
        System.out.println("second=" + second.fare());
        System.out.println("state=" + second.state());
        System.out.println("total=" + service.confirm(items));
        System.out.println("all=" + service.confirm(items, true));
        System.out.println("found=" + service.find(items, new String("B7")));
    }
}