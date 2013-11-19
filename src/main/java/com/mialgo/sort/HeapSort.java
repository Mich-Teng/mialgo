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
import com.mialgo.util.HeapUnderflowException;
import com.mialgo.util.NonComparableException;


public class HeapSort  {
    /**
     * Using heap to implement heap sort (Object)
     * @param arr source array
     * @param mode sorting mode: ASCENDING OR DESCENDING
     */

    public static void sort(Comparable[] arr,short mode){
        Heap t;
        try{
            if(mode == SortMode.DESCENDING)
                t=new Heap(arr);
            else
                t=new Heap(arr,Heap.MIN_HEAP);
            for( int i = 0; i < arr.length; i++)
                arr[i] = (Comparable)t.pop();
        }catch(NonComparableException e){
            System.err.println("The type is not comparable");
        }
        catch (HeapUnderflowException e){
            System.err.println("Heap is empty. You can't pop a thing");
        }
    }

    /**
     * simple object version of heap sort , default mode ASCENDING
     * @param arr source array
     */
    public static void sort(Comparable[] arr){
        // default is the ASCENDING mode
        sort(arr,SortMode.ASCENDING);
    }
}
