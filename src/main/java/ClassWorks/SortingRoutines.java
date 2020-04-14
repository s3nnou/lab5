package ClassWorks;

import java.util.Comparator;

public class SortingRoutines {
    public static class SortByType implements Comparator<Sportsman> {
        @Override
        public int compare(Sportsman o1, Sportsman o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }

    public static class SortByScore implements Comparator<Sportsman> {
        @Override
        public int compare(Sportsman o1, Sportsman o2) {
            return o1.getScore() - o2.getScore();
        }
    }
}
