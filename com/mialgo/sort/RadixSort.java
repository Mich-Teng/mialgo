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
 * This is very practical sorting method when you want to sort the date or some integer like data
 * It is based on CountingSort
 *
 */
public class RadixSort {

    public void sort(int[] arr, short mode, int digit){
        int[] count = new int[10];
        int denom = 1;
        int[] ret = arr.clone();
        for( int i = 0 ; i < digit; i++ ){
            // perform counting sort for each digit
            int[] tmp_arr = new int[arr.length];
            // get the jth digit in tmp_arr
            for( int j = 0; j < arr.length ; j++ )
                tmp_arr[j] = (arr[j]/denom)%10;
            // initialize count array
            for( int j = 0 ; j < count.length; j++ )
                count[j] = 0;
            // get the count value
            if( mode == Sort.ASCENDING ){
                for( int j = 0 ; j < arr.length; j++ ){
                    count[tmp_arr[j]-0] ++ ;
                }
            }
            else{
                for( int j = 0; j < arr.length; j++ ){
                    count[ 9 - tmp_arr[j] ] ++;
                }
            }
            // accumulate the count array
            for( int j = 1 ; j < count.length; j++ )
                count[j] += count[j-1];
            // output the arr according to its order and mode
            for( int j = arr.length-1 ; j >= 0 ; j-- ){
                if( mode == Sort.ASCENDING ){
                    arr[count[tmp_arr[j]] -1] = ret[j];
                    count[tmp_arr[j] ] -- ;
                }
                else{
                    arr[count[9 - tmp_arr[j]]-1] = ret[j];
                    count[ 9 - tmp_arr[j]]--;
                }
            }
            denom*=10;
            ret = arr.clone();
        }
    }
}
