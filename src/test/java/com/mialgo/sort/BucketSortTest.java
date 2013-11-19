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
 * Time: 2013-11-15 17:12
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class BucketSortTest {
    public final int SIZE = 10000;
    Double[] dList;
    @Before
    public void init(){
        dList = TestDataGenerator.getRandomDoubleArray(SIZE);
    }

    @After
    public void destroy(){

    }

    @Test
    public void bucketSort(){
        TestDataGenerator.printArray(dList, "Before sort : ");
        double[] dArray = ObjectTools.unpack(dList);
        BucketSort.sort(dArray, SortMode.ASCENDING);
        TestDataGenerator.printArray(ObjectTools.pack(dArray), "After sort : ");
        assertTrue(ObjectTools.isSorted(ObjectTools.pack(dArray), SortMode.ASCENDING));
    }
}
