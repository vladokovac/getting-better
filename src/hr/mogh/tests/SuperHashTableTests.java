package hr.mogh.tests;

import hr.mogh.datastructures.hashtable.SuperHashTable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contains tests written to ensure SuperHashTable works as intended.
 * Created by vlado on 20.10.2015.
 */
public class SuperHashTableTests {

    private SuperHashTable<String, String> superHashTable;
    private static final int TABLE_SIZE = 20;

    @Before
    public void setup() {
        superHashTable = new SuperHashTable<>(TABLE_SIZE);
    }

    @After
    public void tearDown() {
        superHashTable = null;
    }

    @Test
    public void getTest_missingKey() {
        String value = superHashTable.get("TestKey");
        Assert.assertNull(value);
    }

    @Test
    public void putTest_cleanTable() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        String value = superHashTable.put(tableKey, tableValue);
        Assert.assertNull(value);
        value = superHashTable.get(tableKey);
        Assert.assertEquals(tableValue, value);
    }

    @Test
    public void putTest_updateSize() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        int sizeBefore = superHashTable.size();
        superHashTable.put(tableKey, tableValue);
        int sizeAfter = superHashTable.size();
        Assert.assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void putTest_updateValue() {
        String tableKey = "TestKey";
        String tableValueBefore = "TestValue1";
        String tableValueAfter = "TestValue2";
        String value = superHashTable.put(tableKey, tableValueBefore);
        Assert.assertNull(value);
        value = superHashTable.put(tableKey, tableValueAfter);
        Assert.assertNotNull(value);
        Assert.assertEquals(tableValueBefore, value);

    }

    @Test
    public void putTest_collision() {
        String tableKey1 = "TestKey";
        String tableKey2 = "eTstKey";
        String testValue1 = "TestValue1";
        String testValue2 = "TestValue2";
        superHashTable.put(tableKey1, testValue1);
        superHashTable.put(tableKey2, testValue2);
        String value = superHashTable.get(tableKey1);
        Assert.assertNotNull(value);
        Assert.assertEquals(testValue1, value);
        value = superHashTable.get(tableKey2);
        Assert.assertNotNull(value);
        Assert.assertEquals(testValue2, value);
    }

    @Test
    public void removeTest_emptyTable() {
        String value = superHashTable.remove("TestKey");
        Assert.assertNull(value);
    }

    @Test
    public void removeTest_keyExists() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        String value = superHashTable.put(tableKey, tableValue);
        Assert.assertNull(value);
        value = superHashTable.remove(tableKey);
        Assert.assertEquals(tableValue, value);
    }

    @Test
    public void removeTest_updatesSize() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        superHashTable.put(tableKey, tableValue);
        int sizeBefore = superHashTable.size();
        superHashTable.remove(tableKey);
        int sizeAfter = superHashTable.size();
        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void removeTest_noSuchKeyExists() {
        String tableKey1 = "TestKey";
        String tableKey2 = "eTstKey";
        String tableValue = "TestValue";
        superHashTable.put(tableKey1, tableValue);
        int sizeBefore = superHashTable.size();
        String value = superHashTable.remove(tableKey2);
        int sizeAfter = superHashTable.size();
        Assert.assertNull(value);
        Assert.assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void clearMapTest() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        superHashTable.put(tableKey, tableValue);
        int sizeBefore = superHashTable.size();
        superHashTable.clear();
        int sizeAfter = superHashTable.size();
        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }

    @Test
    public void containsKeyTest_keyExists() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        superHashTable.put(tableKey, tableValue);
        Assert.assertTrue(superHashTable.containsKey(tableKey));
    }

    @Test
    public void containsKeyTest_noSuchKeyExists() {
        String tableKey1 = "TestKey";
        String tableKey2 = "eTstKey";
        String tableValue = "TestValue";
        superHashTable.put(tableKey1, tableValue);
        Assert.assertFalse(superHashTable.containsKey(tableKey2));
    }

    @Test
    public void containsValueTest_valueExists() {
        String tableKey = "TestKey";
        String tableValue = "TestValue";
        superHashTable.put(tableKey, tableValue);
        Assert.assertTrue(superHashTable.containsValue(tableValue));
    }

    @Test
    public void containsValueTest_noSuchValueExists() {
        String tableKey = "TestKey";
        String tableValue1 = "TestValue1";
        String tableValue2 = "TestValue2";
        superHashTable.put(tableKey, tableValue1);
        Assert.assertFalse(superHashTable.containsValue(tableValue2));
    }

    @Test
    public void putAllTest_emptyTable() {
        String tableKey1 = "TestKey1";
        String tableValue1 = "TestValue1";
        String tableKey2 = "TestKey2";
        String tableValue2 = "TestValue2";
        Map<String, String> testMap = new HashMap<>();
        testMap.put(tableKey1, tableValue1);
        testMap.put(tableKey2, tableValue2);
        superHashTable.putAll(testMap);
        Assert.assertEquals(tableValue1, superHashTable.get(tableKey1));
        Assert.assertEquals(tableValue2, superHashTable.get(tableKey2));
    }

    @Test
    public void keySetTest_tableWithEntries() {
        String tableKey1 = "TestKey1";
        String tableValue1 = "TestValue1";
        String tableKey2 = "TestKey2";
        String tableValue2 = "TestValue2";
        superHashTable.put(tableKey1, tableValue1);
        superHashTable.put(tableKey2, tableValue2);
        Set<String> keySet = superHashTable.keySet();
        Assert.assertEquals(2, keySet.size());
        Assert.assertTrue(keySet.contains(tableKey1));
        Assert.assertTrue(keySet.contains(tableKey2));
    }

    @Test
    public void keySetTest_emptyTable() {
        Set<String> keySet = superHashTable.keySet();
        Assert.assertEquals(0, keySet.size());
    }

    @Test
    public void valuesTest_tableWithEntries() {
        String tableKey1 = "TestKey1";
        String tableValue1 = "TestValue1";
        String tableKey2 = "TestKey2";
        String tableValue2 = "TestValue2";
        superHashTable.put(tableKey1, tableValue1);
        superHashTable.put(tableKey2, tableValue2);
        Collection<String> valueCollection = superHashTable.values();
        Assert.assertEquals(2, valueCollection.size());
        Assert.assertTrue(valueCollection.contains(tableValue1));
        Assert.assertTrue(valueCollection.contains(tableValue2));
    }

    @Test
    public void valuesTest_emptyTable() {
        Collection<String> valueCollection = superHashTable.values();
        Assert.assertEquals(0, valueCollection.size());
    }
}
