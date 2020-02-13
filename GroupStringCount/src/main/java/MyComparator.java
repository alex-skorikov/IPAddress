import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;

/**
 * Comparator for sort result map by value size.
 */
class MyComparator implements Comparator<Long> {
    Map<Long, HashSet<String>> map;

    public MyComparator(Map<Long, HashSet<String>> sortedMap) {
        this.map = sortedMap;
    }

    @Override
    public int compare(Long integer, Long t1) {
        if (map.get(integer).size() >= map.get(t1).size()) {
            return -1;
        } else {
            return 1;
        }
    }
}
