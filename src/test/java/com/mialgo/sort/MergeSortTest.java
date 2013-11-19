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
 * Time: 2013-11-15 18:06
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class MergeSortTest {
    public final int SIZE = 10000;
    Float[] fList;
    @Before
    public void init() {
        fList = TestDataGenerator.getRandomFloatArray(SIZE);
    }

    @After
    public void destroy() {

    }

    @Test
    public void mergeSort() {
        TestDataGenerator.printArray(fList, "Before sort : ");
        MergeSort.sort(fList, SortMode.ASCENDING);
        TestDataGenerator.printArray( fList, "After sort ASCENDING: " );
        assertTrue(ObjectTools.isSorted(fList, SortMode.ASCENDING));
    }
}
