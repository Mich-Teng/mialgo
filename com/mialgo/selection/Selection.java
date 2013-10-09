package com.mialgo.selection;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-10-09 16:21
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class Selection {
    /**
     * get the maximum element in the array
     * @param arr source array
     * @return maximum element
     */
    public static double getMax(double[] arr) throws EmptyArrayException{
        int length = arr.length;
        if( length == 0 ){
            throw new EmptyArrayException();
        }
        double max = arr[0];
        for( int i = 1; i < length; i++ ){
            if( max < arr[i] )
                max = arr[i];
        }
        return max;
    }

    /**
     * get the minimum element in the array
     * @param arr source array
     * @return return minimum element
     */
    public static double getMin(double[] arr) throws EmptyArrayException{
        int length = arr.length;
        if( length == 0 ){
            throw new EmptyArrayException();
        }
        double min = arr[0];
        for( int i = 1; i < length; i++ ){
            if( min > arr[i] )
                min = arr[i];
        }
        return min;
    }
}
