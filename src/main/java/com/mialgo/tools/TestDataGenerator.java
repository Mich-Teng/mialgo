package com.mialgo.tools;

import com.mialgo.tools.ObjectTools;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-11-07 16:44
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class TestDataGenerator {
    public static final float MAX_VALUE = 10000;
    /**
     * get the float array of random num
     * @param size length of array
     * @return randomize float array
     */
    public static Float[] getRandomFloatArray( int size ){
        Float[] ret = new Float[size];
        Random rand = new Random();
        for( int i = 0; i < size ; i++ )
            ret[i] = rand.nextFloat();
        return ret;
    }
    /**
     * get the double array of random num
     * @param size length of array
     * @return randomize float array
     */
    public static Double[] getRandomDoubleArray( int size ) {
        Double[] ret = new Double[size];
        Random rand = new Random();
        for( int i = 0 ; i < size; i++ ) {
            ret[i] = rand.nextDouble();
        }
        return ret;
    }
    /**
     * get the Integer array of random num
     * @param size length of array
     * @return randomize float array
     */
    public static Integer[] getRandomIntArray( int size ) {
        Integer[] ret = new Integer[size];
        Random rand = new Random();
        for( int i = 0 ; i < size; i++ ) {
            ret[i] = rand.nextInt();
        }
        return ret;
    }

    /**
     * get the Integer array of random num, which specify the max value
     * @param size length of array
     * @return randomize float array
     */
    public static Integer[] getRandomIntArray( int size , int max ) {
        Integer[] ret = new Integer[size];
        Random rand = new Random();
        for( int i = 0 ; i < size; i++ ) {
            ret[i] = rand.nextInt(max);
        }
        return ret;
    }

    /**
     *
     * @param arr source array
     * @param sentence prefix and postfix : optional
     * @param <T>
     */
    public static<T> void printArray(T[] arr, String... sentence ){
        int size = sentence.length;
        if( size > 2 ){
            System.err.println("Invalid Usage");
            return ;
        }
        if( size >= 1 )
            System.out.print(sentence[0]);
        for( T ele : arr ){
            System.out.print(ele + " ");
        }
        if( size == 2 )
            System.out.print(sentence[1]);
        System.out.println();
    }

}
