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

import java.util.Queue;
import java.util.LinkedList;

public class QuickSort extends SortingAlgorithm {
    // when to start using Insertion Sort instead of Quick Sort
    final int BOUNDARY = 50;
    /**
     * implementation of quick sort
     * pivot selection strategy : select median from three numbers
     * optimization : each partition divides the array into three sub arrays: smaller,equal and larger,
     * which will improve the performance when the arrays have many same elements
     * @param arr source array
     * @param mode sorting mode: ASCENDING OR DESCENDING
     */
    @Override
    public void sort(Comparable<? extends Object>[] arr,short mode){
        this.arr = arr;
        this.mode = mode;
        qsort(0,arr.length-1);
    }

    /**
     * main processing function
     * @param left left side of the array
     * @param right right side of the array
     */
    void qsort(int left, int right){
        int length = right - left + 1;
        Comparable tmp;
        int j;
        if( length < BOUNDARY ){
            // perform insertion sort here
            for( int i = 1 ; i < length; i++ ){
                tmp = arr[i];
                for (j = i-1; j >=0; j-- ){
                    if( (mode == Sort.ASCENDING)?tmp.compareTo(arr[j])<0 : tmp.compareTo(arr[j])>0 )
                        exchange(j,j+1);
                    else
                        break;
                }
                arr[j+1] = tmp;
            }
            return ;
        }
        // select pivot and exchange the corresponding position
        selectPivot(left,right);
        // divide the array into 3 groups,arr[right] and arr[left] have already put into right position,pivot = arr[right - 1]

        int[] ret = partition(left+1,right - 1);
        qsort(left,ret[0]);
        qsort(ret[1], right);
    }

    /**
     * select pivot, and change the position of pivot into right -1
     * three number and fetch the median
     * @param left  left side of array
     * @param right right side of array
     */
    void selectPivot(int left, int right){
        int middle = (left+right)/2;
        int lm = ((Comparable)arr[left]).compareTo(arr[middle]);
        // insertion sort performed
        // need change the position of left and middle
        if( (mode == Sort.ASCENDING)?lm > 0:lm < 0){
            exchange(left,middle);
        }
        int mr = ((Comparable)arr[middle]).compareTo(arr[right]);
        // need change the position of left and middle
        if( (mode == Sort.ASCENDING)?mr > 0:mr <0){
            exchange(middle,right);
            lm = ((Comparable)arr[left]).compareTo(arr[middle]);
            if( (mode == Sort.ASCENDING)?lm > 0:lm <0){
                exchange(left,middle);
            }
        }
        exchange(right-1,middle);
    }
    /**
     * @param left left side of the array
     * @param right position of pivot, which is the last element of array
     * @return
     * ret[0] means the end of element which is less than pivot
     * ret[1] means the start of the element which is larger than pivot
     */
    int[] partition(int left , int right){
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
            if( (mode == Sort.ASCENDING)?pivot.compareTo(arr[i])> 0:pivot.compareTo(arr[i])< 0 ){
                lpos ++;
                // change the value of arr[lpos] and arr[i]
                exchange(lpos,i);
                // use queue to verify the current minimum index
                if(count > 0){
                    epos = queue.peek().intValue();
                    if( equals[epos] == lpos ){
                        equals[epos] = i;
                        queue.remove();
                        queue.add(new Integer(epos));
                     }
                }
            }
            else if( pivot.compareTo(arr[i]) == 0 ){
                // record the index of equal element
                equals[count++] = i ;
                queue.offer(new Integer(count-1));
            }
        }
        lpos++;
        // exchange the value of pivot and arr[lpos]
        exchange(lpos,right);

        // put the elements equal to pivot just after the pivot
        for( int i = 0; i < count; i++ ){
            exchange(lpos+i+1,equals[i]);
        }

        // get the return value
        ret[0] = lpos-1;
        ret[1] =lpos+1 + count;
        return ret;
    }
}
