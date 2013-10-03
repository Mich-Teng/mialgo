package com.mialgo.sort;

/**
 * ********************************************************************
 * Author: Chao Teng
 * Time: 2013-10-03 14:58
 * License: GNU/GPL
 * <p/>
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ********************************************************************
 */
public class MergeSort extends SortingAlgorithm {
    @Override
    public void sort(Comparable<? extends Object>[] arr, short mode){
        if( checkValid( arr ) == false )
            return ;
        int pivot = (arr.length-1)/2;
        merge(arr,0,pivot,arr.length-1,mode);
    }
    // call merge recursively to sort the sub arrays and merge them
    // ** further optimization:
    //  use insertion sort to finish the sort of sub arrays whose elements are less than N
    //  This will improve the performance of the algorithm
    void merge(Comparable<? extends  Object>[] arr, int left, int pivot, int right, short mode){
        // index of leftside
        int l = left;
        // index of rightside
        int r = pivot+1;
        // cycling count
        int count = 0;
        // single node
        if( left == right )
            return ;
        if( !(left == pivot ) ){
            merge(arr,left,(left+pivot)/2,pivot,mode);
        }
        if( !(right == pivot) )
            merge(arr,pivot+1,(pivot+right)/2,right,mode);
        Comparable[] tmp = new Comparable[right-left+1];
        while( count <= right - left + 1 ){
            // l or r across the boundary
            if( l > pivot || r > right )
                break;
            // if the leftside element should be put forward
            if( (mode == Sort.ASCENDING)?((Comparable)arr[l]).compareTo(arr[r])<0:((Comparable)arr[l]).compareTo(arr[r])>0 )
                tmp[count++] = arr[l++];
            else
                tmp[count++] = arr[r++];
        }
        while(l <= pivot )
            tmp[count++] = arr[l++];
        while(r <= right )
            tmp[count++] = arr[r++];
        // copy the elements from tmp to arr;
        for( int i = left; i <= right; i++ ){
            arr[i] = tmp[i-left];
        }
    }

}
