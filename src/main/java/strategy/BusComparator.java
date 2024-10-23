package strategy;

import java.util.Comparator;

public class BusComparator {

    public static class SortNumber implements Comparator<Bus> {
        @Override
        public int compare(Bus b1, Bus b2) {
            return Integer.compare(b1.getNumber(), b2.getNumber());
        }
    }

    public static class SortNumberIgnoreOdd implements Comparator<Bus> {
        @Override
        public int compare(Bus b1, Bus b2) {
            if (b1.getNumber() % 2 != 0)
                return 0;
            return Integer.compare(b1.getNumber(), b2.getNumber());
        }
    }

    public static class SortModel implements Comparator<Bus> {
        public int compare(Bus b1, Bus b2) {
            return b1.getModel().compareToIgnoreCase(b2.getModel());
        }
    }

    public static class SortMileage implements Comparator<Bus> {
        public int compare(Bus b1, Bus b2) { return Integer.compare(b1.getMileage(), b2.getMileage()); }
    }
}
