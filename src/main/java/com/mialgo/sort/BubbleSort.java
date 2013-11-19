package com.mialgo.sort;

import static com.mialgo.tools.ObjectTools.exchange;

/**
 * ********************************************************************
 * Author: Chao Teng
 * Time: 2013-10-03 11:38
 * License: GNU/GPL
 *
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ********************************************************************
 */

public class BubbleSort {
    /**
     * full object version of bubble sort
     * @param arr source array
     * @param mode sorting mode : ASCENDING OR DESCENDING
     */
    public static void sort(Comparable[] arr,short mode){
        int length = arr.length;
        boolean flag = false;
        for ( int i = 1; i < length ; i++ ){
            for( int j = length-1 ; j>=i; j--){
                flag = ( mode == SortMode.ASCENDING )?arr[j].compareTo(arr[j-1])<0 : arr[j].compareTo(arr[j-1]) > 0;
                if( flag == true)
                    exchange(arr,j,j-1);
            }
        }
    }

    /**
     * simple object version of bubble sort , default mode ASCENDING
     * @param arr source array
     */
    public static void sort(Comparable[] arr){
        // default is the ASCENDING mode
        sort(arr,SortMode.ASCENDING);
    }

}
