package com.mialgo.util;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-29 18:18
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */
class NonComparableException extends Exception{};

public class Heap<T> {
    T[] arr;
    public Heap(T[] input) throws NonComparableException{
        // check whether the class implements Comparable
        if( input.getClass().isInstance(Comparable.class) == false ){
            System.err.println("Invalid Input. The array must implement Comparable");
            throw new NonComparableException();
        }
        // copy the content from original array
        arr = input.clone();
    }
}
