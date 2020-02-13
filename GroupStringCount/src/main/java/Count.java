import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Class Count.
 */
public class Count {
    /**
     * Map substring and key.
     */
    private Map<String, Long> inner = new HashMap<>();
    /**
     * Map - key and string group.
     */
    private Map<Long, HashSet<String>> out = new HashMap<>();
    /**
     * Key for map.
     */
    private Long hash = 0l;
    /**
     * Temp key.
     */
    private Long keyTemp;
    /**
     * Comparator.
     */
    private MyComparator comparator = new MyComparator(out);
    /**
     * Sorted map by value size.
     */
    private TreeMap<Long, HashSet<String>> sorted_map = new TreeMap<Long, HashSet<String>>(comparator);

    /**
     * Get sorted map.
     *
     * @return map.
     */
    public TreeMap<Long, HashSet<String>> getSorted_map() {
        return sorted_map;
    }

    /**
     * Get out map.
     *
     * @return map.
     */
    public Map<Long, HashSet<String>> getOut() {
        return out;
    }

    /**
     * Search key.
     *
     * @param arr array.
     * @return key.
     */
    void searchKey(String[] arr) {
        keyTemp = null;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("") && inner.keySet().contains(arr[i])) {
                keyTemp = inner.get(arr[i]);
                break;
            }
        }
    }

    /**
     * Add new string-key.
     *
     * @param arr array.
     */
    void addNewStringArray(String[] arr) {
        if (keyTemp == null) {
            keyTemp = hash++;
        }
        for (int i = 0; i < arr.length; i++) {
            inner.put(arr[i], keyTemp);
        }
    }

    /**
     * Add string to out map.
     */
    void addStringToOut(String str) {
        out.computeIfPresent(keyTemp, (k, c) -> {
            c.add(str);
            return c.isEmpty() ? null : c;
        });
        out.computeIfAbsent(keyTemp, ign -> new HashSet<>()).add(str);
    }
}
