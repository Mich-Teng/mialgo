package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-29 15:36
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */

import com.mialgo.util.Heap;
import com.mialgo.util.NonComparableException;
import com.sun.deploy.util.ArrayUtil;

public class HeapSort extends SortingAlgorithm {
    @Override
    public void sort(int[] arr, short mode){
        int length = arr.length;
        Integer[] tmp = new Integer[length];
        for( int i = 0; i < length; i++)
            tmp[i] = Integer.valueOf(arr[i]);
        sort(tmp,mode);
        for(int i = 0; i < length ; i++)
            arr[i] = tmp[i];
    }

    @Override
    public void sort(Comparable<? extends Object>[] arr,short mode){
        Heap t;
        try{
            if(mode == Sort.DESCENDING)
                t=new Heap(arr);
            else
                t=new Heap(arr,Heap.MIN_HEAP);
            for( int i = 0; i < arr.length; i++)
                arr[i] = (Comparable)t.pop();
        }catch(NonComparableException e){
            System.err.println("The type is not comparable");
        }
    }


}
