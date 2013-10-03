package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-23 14:45
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */

/**
 *  the interface of all the sorting algorithm implemented
 *  The new added algorithm should implement following interface
 */
abstract class SortingAlgorithm {
    Comparable[] arr;
    short mode = Sort.ASCENDING;
    /**
     * the interface accepts 2 parameters
     * @param arr source array
     * @param mode ascending or descending mode
     */
    public void sort(int[] arr, short mode){
        int length = arr.length;
        Integer[] tmp = new Integer[length];
        for( int i = 0; i < length; i++)
            tmp[i] = Integer.valueOf(arr[i]);
        sort(tmp,mode);
        for(int i = 0; i < length ; i++)
            arr[i] = tmp[i];
    }

    abstract void sort(Comparable<? extends Object>[] arr,short mode);

    // check whether the array fits our requirement
    // all the type in the container must be the same type
    protected boolean checkValid(Object[] arr){
        // if the array is empty
        if( arr.length == 0 )
            return false;
        // if the type of array object is not identical
        Class type = arr[0].getClass();
        for ( int i = 1 ; i < arr.length; i++ ){
            if( arr[i].getClass() != type ){
                System.err.println("Invalid Usage. The type of objects in array is not identical");
                return false;
            }
        }
        // verify Object whehter implements Comparable
        return true;
    }
    /**
     * exchange the value of ith and jth element
     */
    void exchange(int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
