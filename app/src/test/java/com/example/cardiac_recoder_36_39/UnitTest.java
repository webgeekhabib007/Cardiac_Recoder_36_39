package com.example.cardiac_recoder_36_39;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.example.cardiac_recoder_36_39.model.CardiacModel;


public class UnitTest {

    @Test
    public void testAddRecord(){
        DataList recordList= new DataList();
        CardiacModel modelClass= new CardiacModel("1-1-2000","10:20","89","67","67","dummy1");
        recordList.addRecord(modelClass);
        assertEquals(1, recordList.array.size());

        CardiacModel modelClass1=new CardiacModel("1-1-2000","10:20","89","67","67","dummy2");
        recordList.addRecord(modelClass1);
        assertEquals(2,recordList.array.size());
        assertTrue(recordList.array.contains(modelClass));
        assertTrue(recordList.array.contains(modelClass1));

    }
    /**
     *
     */
    @Test
    public void addRecordExTest(){
        DataList recordList= new DataList();
        CardiacModel modelClass= new CardiacModel("1-1-2000","10:20","89","67","67","dummy2");
        recordList.addRecord(modelClass);
        assertThrows(IllegalArgumentException.class, () -> recordList.addRecord(modelClass));
    }
    @Test
    public void testDeleteRecord() {
        //int position=0;
        DataList recordList = new DataList();
        CardiacModel record1 = new CardiacModel ("1-1-2000", "10:20", "89", "67", "67", "dummy1");
        recordList.addRecord(record1);
        assertEquals(1, recordList.array.size());
        assertTrue(recordList.array.contains(record1));
        CardiacModel record2 = new CardiacModel("1-1-2000", "10:20", "89", "67", "67", "dummy2");
        recordList.addRecord(record2);
        assertEquals(2, recordList.array.size());
        assertTrue(recordList.array.contains(record2));
        CardiacModel record3 = new CardiacModel("1-1-2000", "10:20", "89", "67", "67", "dummy3");
        recordList.addRecord(record3);
        assertEquals(3, recordList.array.size());
        assertTrue(recordList.array.contains(record3));



        recordList.deleteRecord(0);
        assertEquals(2, recordList.array.size());
        assertFalse(recordList.array.contains(record1));

        recordList.deleteRecord(0);
        assertEquals(1, recordList.array.size());
        assertFalse(recordList.array.contains(record2));

        recordList.deleteRecord(0);
        assertEquals(0, recordList.array.size());
        assertFalse(recordList.array.contains(record3));

        assertThrows(IllegalArgumentException.class, () -> recordList.deleteRecord(0));
    }
    @Test
    public void testCount(){
        DataList recordList=new DataList();
        CardiacModel modelClass1=new CardiacModel("1-1-2000","10:20","89","67","67","dummy");
        recordList.addRecord(modelClass1);
        assertEquals(1,recordList.count());

    }
}
