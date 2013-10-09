package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-10-09 11:56
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


/**
 * Implementation of Counting Sort, which is suitable for the integer sort
 * but compare with quick sort, it needs extra space and a larger constant time item
 * so you should carefully to use this algorithm although its time complexity is O(N)
 * the most frequent use of it is as the base algorithm of radix sort
 */
public class CountingSort {
    /**
     *
     * @param arr source array
     * @param mode  sorting mode
     * @param num  the number of elements
     */
    public void sort(int[] arr,short mode,int max, int min){
        int[] count = new int[max-min+1];
        int[] ret = arr.clone();
        // initialize it into 0
        for( int i = 0 ; i < count.length; i++ )
            count[i] = 0;
        // get the count value
        if( mode == Sort.ASCENDING ){
            for( int i = 0 ; i < arr.length; i++ ){
                count[arr[i]-min] ++ ;
            }
        }
        else{
            for( int i = 0; i < arr.length; i++ ){
                count[ max - arr[i] ] ++;
            }
        }
        // accumulate the count array
        for( int i = 1 ; i < count.length; i++ )
            count[i] += count[i-1];
        // output the arr according to its order and mode
        // The decreasing mode is in order to make the algorithm sequential stable(maintain the order of sequence
        // based on the sequencing
        for( int i = arr.length-1 ; i >= 0 ; i-- ){
            if( mode == Sort.ASCENDING ){
                arr[count[ret[i]-min] - 1] = ret[i];
                count[ret[i]- min] --;
            }
            else{
                arr[count[max-ret[i]] - 1] = ret[i];
                count[max-ret[i]] -- ;
            }
        }
    }
}
