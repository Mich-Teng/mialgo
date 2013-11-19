package com.mialgo.tools;

import com.mialgo.sort.SortMode;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-11-06 18:45
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class ObjectTools {
    /**
     * exchange the value in the object array
     * @param list source array
     * @param src source index
     * @param des des index
     * if the index is out of bounds, JAVA offers exception itself
     */
    public static void exchange(Object[] list,int src, int des){
        if( src == des )
            return ;
        Object tmp = list[src];
        list[src] = list[des];
        list[des] = tmp;
    }

    /**
     * convert array to list
     * @param list source array
     * @param <T> template
     * @return List of source array
     */
    public static<T> List<T> arrayToList(T[] list){
        return Arrays.asList(list);
    }

    /**
     * convert list to array
     * @param list source list
     * @param <T> template
     * @return array of source list or null if the list is null or empty
     */
    public static<T> T[] listToArray(List<T> list){
        if( list == null || list.isEmpty() )
            return null;
        int size = list.size();
        T[] demo = (T[])Array.newInstance(list.get(0).getClass(),size);
        return list.toArray(demo);
    }

    /**
     * verify whetehr an array is sorted
     * @param arr source array
     * @param <T>
     * @return true or false
     */
    public static boolean isSorted( Comparable[] arr , short mode ){
        int size = arr.length;
        boolean flag = true;
        for( int i = 0 ; i < size - 1; i++ ){
            flag = (mode == SortMode.ASCENDING)?arr[i].compareTo(arr[i+1])<=0:arr[i].compareTo(arr[i+1])>=0;
            if( flag == false )
                return flag;
        }
        return flag;
    }

    /**
     * unpack Double[] to double[].
     * @param param array
     * @param <T>
     */
    public static double[] unpack( Double[] param ) {
        if( param == null || param.length == 0 ) {
            return null;
        }
        int size = param.length;
        double[] ret = new double[size];
        for( int i = 0; i < size; i++ ) {
            ret[i] = param[i];
        }
        return ret;
    }

    /**
     * unpack double[] to Double[].
     * @param param array
     * @param <T>
     */
    public static Double[] pack( double[] param ) {
        if( param == null || param.length == 0 ) {
            return null;
        }
        int size = param.length;
        Double[] ret = new Double[size];
        for( int i = 0; i < size; i++ ) {
            ret[i] = param[i];
        }
        return ret;
    }

    /**
     * unpack Integer[] to int[].
     * @param param array
     * @param <T>
     */
    public static int[] unpack( Integer[] param ) {
        if( param == null || param.length == 0 ) {
            return null;
        }
        int size = param.length;
        int[] ret = new int[size];
        for( int i = 0; i < size; i++ ) {
            ret[i] = param[i];
        }
        return ret;
    }

    /**
     * unpack int[] to Integer[].
     * @param param array
     * @param <T>
     */
    public static Integer[] pack( int[] param ) {
        if( param == null || param.length == 0 ) {
            return null;
        }
        int size = param.length;
        Integer[] ret = new Integer[size];
        for( int i = 0; i < size; i++ ) {
            ret[i] = param[i];
        }
        return ret;
    }

}
