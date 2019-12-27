package ru.skorikov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Objects;
import java.util.Arrays;

/**
 * Class Dolly.
 */
public class Dolly {
    /**
     * Field char.
     */
    private static char staticChar = 'D';
    /**
     * Field final String.
     */
    private static final String FINAL_STRING = "Dolly";
    /**
     * Field string.
     */
    private String str;
    /**
     * Field num.
     */
    private Integer num;
    /**
     * Field boolean.
     */
    private boolean bool;
    /**
     * Field array[].
     */
    private String[] array;
    /**
     * Field ArrayList.
     */
    private ArrayList<Integer> list;
    /**
     * Field HashMap.
     */
    private HashMap<Integer, LinkedList<String>> map;
    /**
     * Inner class Dolly.
     */
    private Dolly innerDolly;
    /**
     * Inner Object.
     */
    private Object innerObject;
    /**
     * Dolly Map.
     */
    private TreeMap<String, ArrayList<Dolly>> dollyMap;
    /**
     * This Diolly.
     */
    private Dolly thisDolly = this;

    /**
     * Get char.
     * @return char.
     */
    public static char getStaticChar() {
        return staticChar;
    }

    /**
     * Set Char.
     * @param staticChar char.
     */
    public static void setStaticChar(char staticChar) {
        Dolly.staticChar = staticChar;
    }

    /**
     * Get final String.
     * @return string.
     */
    public static String getFinalString() {
        return FINAL_STRING;
    }

    /**
     * Get str.
     * @return str.
     */
    public String getStr() {
        return str;
    }

    /**
     * Set str.
     * @param str string.
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * Get num.
     * @return num.
     */
    public Integer getNum() {
        return num;
    }

    /**
     * Set num.
     * @param num num.
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * Boolean.
     * @return is boolean.
     */
    public boolean isBool() {
        return bool;
    }

    /**
     * Set boolean.
     * @param bool boolean.
     */
    public void setBool(boolean bool) {
        this.bool = bool;
    }

    /**
     * Get array.
     * @return array.
     */
    public String[] getArray() {
        return array;
    }

    /**
     * Set array.
     * @param array array.
     */
    public void setArray(String[] array) {
        this.array = array;
    }

    /**
     * Get list.
     * @return list.
     */
    public ArrayList<Integer> getList() {
        return list;
    }

    /**
     * Set list.
     * @param list list.
     */
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    /**
     * Get map.
     * @return map.
     */
    public HashMap<Integer, LinkedList<String>> getMap() {
        return map;
    }

    /**
     * Set Map.
     * @param map map.
     */
    public void setMap(HashMap<Integer, LinkedList<String>> map) {
        this.map = map;
    }

    /**
     * Get inner Dolly.
     * @return Dolly.
     */
    public Dolly getInnerDolly() {
        return innerDolly;
    }

    /**
     * Set inner Dolly.
     * @param innerDolly inner Dolly.
     */
    public void setInnerDolly(Dolly innerDolly) {
        this.innerDolly = innerDolly;
    }

    /**
     * Get inner object.
     * @return object.
     */
    public Object getInnerObject() {
        return innerObject;
    }

    /**
     * Set inner object.
     * @param innerObject inner object.
     */
    public void setInnerObject(Object innerObject) {
        this.innerObject = innerObject;
    }

    /**
     * Get Dolly map.
     * @return map.
     */
    public TreeMap<String, ArrayList<Dolly>> getDollyMap() {
        return dollyMap;
    }

    /**
     * Set Dolly map.
     * @param dollyMap map.
     */
    public void setDollyMap(TreeMap<String, ArrayList<Dolly>> dollyMap) {
        this.dollyMap = dollyMap;
    }

    /**
     * Get this Dolly.
     * @return this Dolly.
     */
    public Dolly getThisDolly() {
        return thisDolly;
    }

    /**
     * Set thisDolly.
     * @param thisDolly this Dolly.
     */
    public void setThisDolly(Dolly thisDolly) {
        this.thisDolly = thisDolly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dolly dolly = (Dolly) o;
        return bool == dolly.bool
                && Objects.equals(str, dolly.str)
                && Objects.equals(num, dolly.num)
                && Arrays.equals(array, dolly.array)
                && Objects.equals(list, dolly.list)
                && Objects.equals(map, dolly.map)
                && Objects.equals(innerDolly, dolly.innerDolly)
                && Objects.equals(innerObject, dolly.innerObject)
                && Objects.equals(dollyMap, dolly.dollyMap)
                && Objects.equals(thisDolly, dolly.thisDolly);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(str, num, bool, list, map, innerDolly, innerObject, dollyMap, thisDolly);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
