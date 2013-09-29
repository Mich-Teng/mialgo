package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-23 14:35
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class Sort {
    // define the descending or ascending mode of the final sequence
    public final static short DESCENDING = 0;
    public final static short ASCENDING = 1;

    /**
     *
     * @param arr source array list
     * @param algo sorting algorithm used
     * @param mode ascending or descending
     *
     */
    public static<T> void process(Comparable<T>[] arr,SortingAlgorithm algo,short mode){
        algo.sort(arr,mode);
    }

    /**
     *
     * @param arr source array list
     * @param algo sorting algorithm used
     */
    public static<T> void process(Comparable<T>[] arr,SortingAlgorithm algo){
        System.out.println("Enter Processing");
        algo.sort(arr,DESCENDING);
    }


    /**
     *
     * @param arr source array list
     */
    public static<T> void process(Comparable<T>[] arr){
        new QuickSort().sort(arr,DESCENDING);
    }

    /**
     *
     * @param arr source array list
     * @param algo  algorithm performing
     * @param mode  ASCENDING OR DESCENDING mode
     */
    public static void process(int[] arr,SortingAlgorithm algo,short mode){
        algo.sort(arr,mode);
    }

    /**
     * simpler form, the default algorithm performed is quicksort
     * @param arr source array list
     * @param mode ASCENDING OR DESCENDING mode
     */
    public static void process(int[] arr,short mode){
        new QuickSort().sort(arr,mode);
    }

    /**
     * simpler form, the default algorithm performed is quicksort
     * default mode is DESCENDING
     * @param arr source array list
     */
    public static void process(int[] arr){
        new QuickSort().sort(arr,DESCENDING);
    }

    /**
     * simpler form, the default algorithm performed is quicksort
     * default mode is DESCENDING
     * @param arr source array list
     * @param algo algorithm performed
     */
    public static void process(int[] arr,SortingAlgorithm algo){
        algo.sort(arr,DESCENDING);
    }

}
