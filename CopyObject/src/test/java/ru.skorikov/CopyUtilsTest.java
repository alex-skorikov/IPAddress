package ru.skorikov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Test CopyUtils copy Object.
 */
public class CopyUtilsTest {
    /**
     * Test copy object.
     * @throws ReflectiveOperationException exception.
     */
    @Test
    public void thewCopyObjectwhenReturnCopy() throws ReflectiveOperationException {

        CopyUtils utils = new CopyUtils();
        Dolly dolly = new Dolly();
        Dolly clone = utils.deepCopy(dolly);

        Assert.assertFalse(dolly == clone);
        Assert.assertEquals(dolly, clone);

        dolly.setStr("Dolly");
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        dolly.setNum(25);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        dolly.setBool(true);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        String[] array = new String[]{"Dolly array"};
        dolly.setArray(array);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(125);
        dolly.setList(list);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        HashMap<Integer, LinkedList<String>> dollyHashMap = new HashMap<>();
        LinkedList<String> mapList = new LinkedList<>();
        mapList.add("dollyHashMap list");
        dollyHashMap.put(1, mapList);
        dolly.setMap(dollyHashMap);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        Dolly innerDolly = new Dolly();
        innerDolly.setStr("Inner Dolly");
        dolly.setInnerDolly(innerDolly);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        Object innerObject = new Object();
        dolly.setInnerObject(innerObject);
        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);

        TreeMap<String, ArrayList<Dolly>> dollyTreeMap = new TreeMap<>();
        ArrayList<Dolly> treeMapList = new ArrayList<>();
        Dolly dollyTreeMapList = new Dolly();
        dollyTreeMapList.setStr("Dolly for TreeMap List");
        treeMapList.add(dollyTreeMapList);
        dollyTreeMap.put("Dolly TreeMap", treeMapList);
        dolly.setDollyMap(dollyTreeMap);

        Assert.assertNotEquals(dolly, clone);
        clone = utils.deepCopy(dolly);
        Assert.assertEquals(dolly, clone);
    }

    /**
     * Test class Dolly 2.
     * @throws ReflectiveOperationException exception.
     */
    @Test
    public void copyDolly2Test() throws ReflectiveOperationException {
        CopyUtils utils = new CopyUtils();
        Dolly2 dolly2 = new Dolly2();

        Dolly2 clone = utils.deepCopy(dolly2);
        Dolly2.InnerDolly2 innerClone = clone.new InnerDolly2();
        innerClone.setName("new Inner name");

        Assert.assertEquals(dolly2, clone);
    }
}