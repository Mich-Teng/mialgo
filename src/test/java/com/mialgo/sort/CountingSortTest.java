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
 * Time: 2013-11-15 18:17
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class CountingSortTest {
    public final int SIZE = 10000;
    Integer[] iList;
    @Before
    public void init(){
        iList = TestDataGenerator.getRandomIntArray(SIZE, 1000);
    }

    @After
    public void destroy(){

    }

    @Test
    public void radixSort(){
        TestDataGenerator.printArray(iList, "Before sort : ");
        int[] iArray = ObjectTools.unpack(iList);
        CountingSort.sort(iArray, SortMode.ASCENDING,0,1000);
        TestDataGenerator.printArray( ObjectTools.pack(iArray), "After sort ASCENDING: " );
        assertTrue(ObjectTools.isSorted(ObjectTools.pack(iArray), SortMode.ASCENDING));
    }
}
