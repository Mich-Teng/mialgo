package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-23 14:55
 * License: GNU/GPL
 *
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class InsertionSort  {
    /**
     * implementation of insertion sort
     * @param arr source array
     * @param mode sorting mode: ASCENDING OR DESCENDING
     *  ***further optimization:
     *  use logerithmic search to accelerate searching
     */
    public static void sort(Comparable[] arr,short mode){
        // to perform the algorithm here
        boolean flag;
        Comparable index;
        for(int i = 1; i < arr.length; i++){
            flag = false;
            index = arr[i];
            for( int j = i-1; j >=0 ; j--){
                flag = (mode == SortMode.ASCENDING)?index.compareTo(arr[j])>0:index.compareTo(arr[j])<0;
                // the comparason should not continue
                if( flag == true ){
                    arr[j+1] = index;
                    break;
                }
                arr[j+1] = arr[j];
            }
            if( flag == false ){
                arr[0] = index;
            }
        }
    }

    /**
     * simple object version of insertion sort , default mode ASCENDING
     * @param arr source array
     */
    public static void sort(Comparable[] arr){
        // default is the ASCENDING mode
        sort(arr,SortMode.ASCENDING);
    }
}
