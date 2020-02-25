package converter.storages;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage fo save formula.
 */
public class MyStorage implements IStorage {
    /**
     * Map storage.
     */
    private Map<String, HashMap<String, Double>> storage;

    /**
     * Constructor.
     */
    public MyStorage() {
        storage = new HashMap<>();
    }

    @Override
    public void saveData(String str) {
        String[] arr = str.split(" ");
        Double first = Double.parseDouble(arr[3]);
        Double second = Double.parseDouble(arr[0]);
        Double relation;
        Double relation2;
        if (first != 0 && second != 0) {
            relation = first / second;
            relation2 = second / first;

            storage.computeIfAbsent(arr[1], ign -> new HashMap<>()).put(arr[4], relation);
            storage.computeIfAbsent(arr[4], ign -> new HashMap<>()).put(arr[1], relation2);

            Double finalRelation = relation;
            storage.computeIfPresent(arr[1], (k, v) -> {
                v.put(arr[4], finalRelation);
                return v.isEmpty() ? null : v;
            });

            Double finalRelation1 = relation2;
            storage.computeIfPresent(arr[4], (k, v) -> {
                v.put(arr[1], finalRelation1);
                return v.isEmpty() ? null : v;
            });
        }

    }

    @Override
    public String getData(String str) {
        String strOut;
        String[] arr = str.split(" ");
        Double dt = Double.parseDouble(arr[0]);
        Double out;
        String keyIn = arr[1];
        String keyOut = arr[4];

        out = searchRelation(1.0, keyIn, keyOut, keyIn, storage);
        if (out == 0.0) {
            out = searchRelation(1.0, keyOut, keyIn, keyOut, storage);
            if (out == 0.0) {
                strOut = "Conversion not possible.";
            } else {
                out = dt / out;
                arr[3] = String.valueOf(out);
                strOut = createStringOut(arr);
            }
        } else {
            out = dt * out;
            arr[3] = String.valueOf(out);
            strOut = createStringOut(arr);
        }
        return strOut;
    }

    /**
     * Search relation.
     * @param d start double rezult.
     * @param keyIn key for start search.
     * @param keyOut key for out search.
     * @param ciclic key cyclic link selection key.
     * @param map storage.
     * @return double relation.
     */
    private double searchRelation(Double d, String keyIn, String keyOut, String ciclic, Map<String, HashMap<String, Double>> map) {

        if (!map.containsKey(keyIn)) {
            return 0.0;
        }
        if (map.get(keyIn).get(keyOut) != null) {
            return map.get(keyIn).get(keyOut);
        }
        for (String str :  map.get(keyIn).keySet()) {
            if (str.equals(ciclic)) {
                d = 0.0;
            } else {
                return  d * map.get(keyIn).get(str) * searchRelation(d, str, keyOut, keyIn, map);
            }
        }

        return d;
    }

    /**
     * Create out string.
     * @param arr String[] array.
     * @return String for out.
     */
    private String createStringOut(String[] arr) {
        Double d1 = Double.parseDouble(arr[0]);
        Double d3 = Double.parseDouble(arr[3]);
        if (d1 % 1 == 0) {
            arr[0] = String.valueOf(d1.intValue());
        }
        if (d3 % 1 == 0) {
            arr[3] = String.valueOf(d3.intValue());
        }
        return String.join(" ", arr);
    }
}
