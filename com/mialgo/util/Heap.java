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


public class Heap<T> {
    T[] arr = null ;
    int heapSize = 0;
    public static final short  MAX_HEAP = 0;
    public static final short  MIN_HEAP = 1;
    boolean isMax = true;

    public Heap(T[] input) throws NonComparableException{
        this(input,MAX_HEAP);
    }

    public Heap(T[] input, short mode) throws NonComparableException{
        isMax = (mode == MAX_HEAP )?true:false;
        // check whether the class implements Comparable
        if( ( input[0] instanceof Comparable) == false ){
            System.err.println("Invalid Input. The array must implement Comparable");
            throw new NonComparableException();
        }
        // copy the content from original array
        arr = input.clone();
        heapSize = input.length;
        build();

    }

    /**
     * default constructor
     */
    public Heap(){}

    /**
     * create heap
     */
    void build(){
        for( int i = heapSize/2 - 1; i >= 0; i--){
            heapify(i);
        }
    }
    /**
     * get the top element in the heap
     */
    public T getTop(){
        return arr[0];
    }

    /**
     * pop the top element and rebuild the heap
     * @return
     */
    public T pop(){
        // exchange the value of the first and the last element
        T temp = arr[0];
        arr[0] = arr[heapSize-1];
        arr[heapSize-1] = temp;
        heapSize--;
        // call heapify
        heapify(0);
        return arr[heapSize];
    }
    /**
     * heapify the heap below the ith node
     * @param i index of node
     */
    public void heapify( int i ){
        int left = LEFT(i);
        int right = RIGHT(i);
        int nIndex = i;
        if( left < heapSize && needExchange((Comparable)arr[i],(Comparable)arr[left]) == true ){
            nIndex = left;
        }
        if( right < heapSize && needExchange((Comparable)arr[nIndex],(Comparable)arr[right]) == true){
            nIndex = right;
        }
        if( nIndex != i ){
            // exchange the value of arr[i] and arr[nIndex]
            T c = arr[i];
            arr[i] = arr[nIndex];
            arr[nIndex] = c;
            // recursively call the heapify
            heapify( nIndex );
        }
    }


    /**
     * decides whether the nodes need to be exchanged
     * @return need exchange: true
     */
    boolean needExchange(Comparable a, Comparable b ){
        if( isMax == true ){
            return (b.compareTo(a) > 0)?true: false;
        }else{
            return (b.compareTo(a) < 0)?true: false;
        }
    }

    /**
     * get the left child of the node
     * @param i node index
     * @return the index of left child
     */
    int LEFT( int i ){ return 2*i+1; }

    /**
     * get the right child of the node
     * @param i node index
     * @return the index of the right child
     */
    int RIGHT( int i ){ return 2*i+2; }

    /**
     * get the parent of the node
     * @param i node index
     * @return the index of the parent node
     */
    int PARENT( int i ){ return (i-1)/2; }
}
