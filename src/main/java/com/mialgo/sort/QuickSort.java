package com.mialgo.sort;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-25 11:18
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */

import com.mialgo.tools.ObjectTools;

import java.util.Queue;
import java.util.LinkedList;

public class QuickSort {
    // when to start using Insertion Sort instead of Quick Sort
    static final int BOUNDARY = 4;
    /**
     * implementation of quick sort
     * pivot selection strategy : select median from three numbers
     * optimization : each partition divides the array into three sub arrays: smaller,equal and larger,
     * which will improve the performance when the arrays have many same elements
     * @param arr source array
     * @param mode sorting mode: ASCENDING OR DESCENDING
     */
    public static void sort(Comparable[] arr,short mode){
        if( arr == null ) {
            return ;
        }
        qsort(arr,0,arr.length-1, mode);
    }

    /**
     * main processing function
     * @param left left side of the array
     * @param right right side of the array
     */
    static void qsort(Comparable[] arr, int left, int right, short mode){
        int length = right - left + 1;
        Comparable tmp;
        int j;
        int[] ret = new int[2];
        if( length < BOUNDARY ){
            // perform insertion sort here
            for( int i = left+1 ; i < left+length; i++ ){
                tmp = arr[i];
                for (j = i-1; j >=left; j-- ){
                    if( (mode == SortMode.ASCENDING)?tmp.compareTo(arr[j])<0 : tmp.compareTo(arr[j])>0 )
                        ObjectTools.exchange(arr,j,j+1);
                    else
                        break;
                }
                arr[j+1] = tmp;
            }
            return ;
        }
        // select pivot and exchange the corresponding position
        selectPivot(arr,left,right,mode);
        // divide the array into 3 groups,arr[right] and arr[left] have already put into right position,pivot = arr[right - 1]
        ret = partition(arr,left+1,right-1,mode);

        qsort(arr,left,ret[0],mode);
        qsort(arr,ret[1], right,mode);
    }

    /**
     * select pivot, and change the position of pivot into right -1
     * three number and fetch the median
     * @param left  left side of array
     * @param right right side of array
     */
    static void selectPivot(Comparable[] arr, int left, int right, short mode){
        int middle = (left+right)/2;
        int lm = ((Comparable)arr[left]).compareTo(arr[middle]);
        // insertion sort performed
        // need change the position of left and middle
        if( (mode == SortMode.ASCENDING)?lm > 0:lm < 0){
            ObjectTools.exchange(arr, left,middle);
        }
        int mr = ((Comparable)arr[middle]).compareTo(arr[right]);
        // need change the position of left and middle
        if( (mode == SortMode.ASCENDING)?mr > 0:mr <0){
            ObjectTools.exchange(arr,middle,right);
            lm = ((Comparable)arr[left]).compareTo(arr[middle]);
            if( (mode == SortMode.ASCENDING)?lm > 0:lm <0){
                ObjectTools.exchange(arr, left,middle);
            }
        }
        ObjectTools.exchange(arr, right-1,middle);
    }

    /**
     * @param left left side of the array
     * @param right position of pivot, which is the last element of array
     * @return
     * ret[0] means the end of element which is less than pivot
     * ret[1] means the start of the element which is larger than pivot
     */
    public static int[] partition(Comparable[] arr, int left , int right ,short mode){
        Comparable pivot = arr[right];
        // specify the position before where pivot should be
        int lpos = left - 1;
        // specify the index in equal array
        int epos = 0;
        int ret[] = new int[2];
        int[] equals = new int[right-left+1];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for( int i = left; i < right ; i++ ){
            // if needing change the position
            if( (mode == SortMode.ASCENDING)?pivot.compareTo(arr[i])> 0:pivot.compareTo(arr[i])< 0 ){
                lpos ++;
                // change the value of arr[lpos] and arr[i]
                ObjectTools.exchange(arr, lpos,i);
                // use queue to verify the current minimum index
                if(count > 0){
                    epos = queue.peek().intValue();
                    if( equals[epos] == lpos ){
                        equals[epos] = i;
                        queue.remove();
                        queue.offer(new Integer(epos));
                     }
                }
            } else if( pivot.compareTo(arr[i]) == 0 ){
                // record the index of equal element
                equals[count++] = i ;
                queue.offer(new Integer(count-1));
            }
        }
        lpos++;
        // exchange the value of pivot and arr[lpos]
        ObjectTools.exchange(arr,lpos,right);

        if(count > 0){
            epos = queue.peek().intValue();
            if( equals[epos] == lpos ){
                equals[epos] = right;
                queue.remove();
                queue.offer(new Integer(epos));
            }
        }
        // put the elements equal to pivot just after the pivot

        int j = 0 ;
        for( int i = 0; i < count; i++ ){
            if( arr[lpos+i+1].equals(arr[equals[j]]) ) {
                continue;
            }
            // need to be exchanged, find the exact index of equal
            while( j < count && equals[j] <= lpos + count ) {
                j++;
            }
            ObjectTools.exchange(arr, lpos+i+1,equals[j]);
            j++;
        }


        // get the return value
        ret[0] = lpos-1;
        ret[1] =lpos+1 + count;
        return ret;
    }

    /**
     * simple object version of quick sort , default mode ASCENDING
     * @param arr source array
     */
    public static void sort(Comparable[] arr){
        // default is the ASCENDING mode
        sort(arr,SortMode.ASCENDING);
    }
}
