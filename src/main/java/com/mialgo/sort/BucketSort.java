package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-10-09 11:57
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */

import com.mialgo.selection.EmptyArrayException;
import com.mialgo.selection.Selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * If your sequence is generated randomly and contains lots of numbers, you may use this algorithm
 * It's better to use the double number between [0,1), otherwise, the implementation will finish it for you, so the only
 * requirement is that the sequence is generated randomly.
 * Otherwise, it's better to use quicksort
 */

public class BucketSort {
    public static void sort(double[] arr, short mode){
        double[] norm = arr.clone();
        double min;
        double max;
        int length = arr.length;
        try{
            min = Selection.getMin(arr);
            max = Selection.getMax(arr);
        }catch(EmptyArrayException e){
            // array is empty, return;
            return ;
        }
        if( min < 0 || max >= 1){
            normalize(norm,min,max);
        }
        // the arraylist is used to store the bucket
        ArrayList<Double>[] tmp = new ArrayList[length];
        // initialize each arraylist to an empty list
        for( int i = 0 ; i < length; i++ ){
            tmp[i] = new ArrayList<Double>();
            tmp[i].clear();
        }
        // insert arr[i] to the specific list
        for( int i = 0; i < length ; i++ ){
            tmp[(int)Math.floor(norm[i]*length)].add(arr[i]);
        }
        // sort list tmp[i] using insertion sort
        for( int i = 0 ; i < length; i++ ){
            // for each list , sort it
            Collections.sort(tmp[i]);
        }

        int index = 0;
        // repose the number according to the mode
        if( mode == SortMode.ASCENDING ){
            for( int i = 0 ; i < length; i++ )
                for(Double p : tmp[i])
                    arr[index++] = p ;
        }
        else{
            for( int i = length - 1 ; i >= 0; i-- ){
                // starting from the last element
                // use iterator to accelerate the traversing
                ListIterator<Double> p = tmp[i].listIterator(tmp[i].size());
                while( p.hasPrevious() )
                    arr[index++] = p.previous();
            }
        }
    }


    static void normalize(double[] arr,double min, double max){
        for( int i = 0; i < arr.length; i++ ){
            arr[i] = (arr[i]-min)/(max-min+1);
        }
    }

}
