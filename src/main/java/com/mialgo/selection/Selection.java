package com.mialgo.selection;

import com.mialgo.sort.Sort;

import java.util.LinkedList;
import java.util.Queue;

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
     * Object version of getMax
     * @param arr source array
     * @return maximum element
     * @throws EmptyArrayException
     */
    public static Comparable getMax(Comparable[] arr) throws EmptyArrayException{
        return new SelectionImp().getMax(arr);
    }

    /**
     * primitive double version of getMax
     * @param arr source array
     * @return maximum element
     * @throws EmptyArrayException
     */
    public static double getMax(double[] arr)throws EmptyArrayException{
        Double[] tmp = new Double[arr.length];
        for( int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        return (Double)new SelectionImp().getMax(tmp);
    }
    /**
     * get the minimum element in the array
     * @param arr source array
     * @return minimum element
     */
    public static Comparable getMin(Comparable[] arr) throws EmptyArrayException{
        return new SelectionImp().getMin(arr);
    }

    /**
     * primitive double version of getMax
     * @param arr source array
     * @return maximum element
     * @throws EmptyArrayException
     */
    public static double getMin(double[] arr)throws EmptyArrayException{
        Double[] tmp = new Double[arr.length];
        for( int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        return (Double)new SelectionImp().getMin(tmp);
    }

    /**
     * get the ith element in the array
      * @param arr source array
     * @param index index of number
     * @param mode largest or smallest
     * @return value of element
     */
    public static Comparable select(Comparable[] arr,int index,short mode) throws IndexExceedBoundException,IndexUnderflowException{
        if( index <= 0 )
            throw new IndexUnderflowException();
        return new SelectionImp().select(arr,index-1,mode);
    }

    public static double select(double[] arr,int index,short mode) throws IndexExceedBoundException,IndexUnderflowException{
        if( index <= 0 )
            throw new IndexUnderflowException();
        Double[] tmp = new Double[arr.length];
        for( int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        return (Double)new SelectionImp().select(tmp,index-1,mode);
    }
}
