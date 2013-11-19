package com.mialgo.sort;

import com.mialgo.tools.ObjectTools;
import com.mialgo.tools.TestDataGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-11-15 16:58
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class QuickSortTest {
    public final int SIZE = 100000;
    Float[] fList;
    Float[] fListNull = null;
    Float[] fListEmpty = new Float[0];

    Integer[] iList;

    @Before
    public void init(){
        fList = TestDataGenerator.getRandomFloatArray(SIZE);
    }

    @After
    public void destroy(){

    }

    @Test
    public void QuickSort(){
        // normal case
        TestDataGenerator.printArray(fList, "Before sort : ");
        QuickSort.sort(fList, SortMode.ASCENDING);
        TestDataGenerator.printArray( fList, "After sort ASCENDING: " );
        assertTrue(ObjectTools.isSorted(fList, SortMode.ASCENDING));

        // empty list
        QuickSort.sort(fListEmpty);
        assertTrue(fListEmpty.length == 0);
        // null pointer
        QuickSort.sort(fListNull,SortMode.ASCENDING);
        // there is no exception
        assertTrue( fListNull == null );
    }


    public void partition() {
        // normal case
        TestDataGenerator.printArray(fList, "Before sort : ");
        QuickSort.partition(fList,3,9, SortMode.ASCENDING);
        TestDataGenerator.printArray( fList, "After sort ASCENDING: " );
        assertTrue(ObjectTools.isSorted(fList, SortMode.ASCENDING));

        // empty list
        QuickSort.sort(fListEmpty);
        assertTrue(fListEmpty.length == 0);
        // null pointer
        QuickSort.sort(fListNull,SortMode.ASCENDING);
        // there is no exception
        assertTrue( fListNull == null );
    }

}
