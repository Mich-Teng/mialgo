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


public class InsertionSort extends SortingAlgorithm {
    /**
     * implementation of insertion sort
     * @param arr source array
     * @param mode sorting mode: ASCENDING OR DESCENDING
     *  ***further optimization:
     *  use logerithmic search to accelerate searching
     */
    @Override
    public void sort(Comparable<? extends Object>[] arr,short mode){
        if( checkValid(arr) == false )
            return ;
        // to perform the algorithm here
        boolean flag;
        Comparable index;
        for(int i = 1; i < arr.length; i++){
            flag = false;
            index = arr[i];
            for( int j = i-1; j >=0 ; j--){
                flag = (mode == Sort.ASCENDING)?index.compareTo(arr[j])>0:index.compareTo(arr[j])<0;
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
}
