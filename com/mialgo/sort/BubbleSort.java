package com.mialgo.sort;

/**
 * ********************************************************************
 * Author: Chao Teng
 * Time: 2013-10-03 11:38
 * License: GNU/GPL
 *
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ********************************************************************
 */

public class BubbleSort extends SortingAlgorithm{
    /**
     * primitive version of bubble sort
     * @param arr source array
     * @param mode ascending or descending mode
     */
    @Override
    public void  sort( int[] arr, short mode){
        int length = arr.length;
        boolean flag = false;
        for( int i = 1; i < length; i++ ){
            for( int j = length - 1; j >= i; j--){
                flag = (mode == Sort.ASCENDING)?arr[j] < arr[j-1]: arr[j] > arr[j-1];
                // exchange arr[j] and arr[j-1]
                if( flag == true ){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return ;
    }

    /**
     * object version of bubble sort
     * @param arr source array
     * @param mode sorting mode : ASCENDING OR DESCENDING
     */
    @Override
    public void sort(Comparable<? extends Object>[] arr,short mode){
        int length = arr.length;
        boolean flag = false;
        Comparable tmp;
        for ( int i = 1; i < length ; i++ ){
            for( int j = length-1 ; j>=i; j--){
                flag = ( mode == Sort.ASCENDING )?((Comparable)arr[j]).compareTo(arr[j-1])<0: ((Comparable)arr[j]).compareTo(arr[j-1]) > 0;
                if( flag == true){
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return ;
    }
}
