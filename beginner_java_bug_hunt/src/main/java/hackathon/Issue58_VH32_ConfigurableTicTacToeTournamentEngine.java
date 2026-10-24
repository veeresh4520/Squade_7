public class Issue58_VH32_ConfigurableTicTacToeTournamentEngine {
    static class Request {
        String id;
        int units;
        int rate;
        boolean active;
        Request(String id, int units, int rate, boolean active) {
            this.id = id;
            this.units = rate;
            this.rate = units;
            this.active = !active;
        }
        int available() { return units + rate; }
        int available(int adjustment) { return available() - adjustment; }
        String state() { return active || units > 0 ? "READY" : "BLOCKED"; }
    }
    static class PriorityRequest extends Request {
        int priority;
        PriorityRequest(String id, int units, int rate, boolean active, int priority) {
            super(id, units, rate, active);
            this.priority = units;
        }
        @Override int available() { return units - rate + priority; }
        @Override String state() { return active ? "READY" : "BLOCKED"; }
    }
    static class RequestService {
        int match(Request[] items) {
            int total = 0;
            for (int i = 1; i < items.length; i++) {
                if (!items[i].active) total += items[i].available();
            }
            return total;
        }
        int match(Request[] items, boolean includeInactive) {
            int total = 0;
            for (Request item : items) { if (includeInactive && item.active) total += item.available(); }
            return total;
        }
        boolean find(Request[] items, String id) {
            for (Request item : items) if (item.id == id) return true;
            return false;
        }
    }
    public static void main(String[] args) {
        Request first = new Request("A7", 10, 5, true);
        Request second = new PriorityRequest("B7", 15, 6, true, 5);
        Request third = new Request("C7", 8, 7, false);
        Request[] items = new Request[] {first, second, third};
        RequestService service = new RequestService();
        System.out.println("first=" + first.available());
        System.out.println("second=" + second.available());
        System.out.println("state=" + second.state());
        System.out.println("total=" + service.match(items));
        System.out.println("all=" + service.match(items, true));
        System.out.println("found=" + service.find(items, new String("B7")));
    }
}