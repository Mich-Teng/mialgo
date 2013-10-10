package com.mialgo.selection;

import com.mialgo.sort.Sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-10-10 11:50
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class SelectionImp {
    final int BOUNDARY = 10;
    Comparable[] arr = null;
    short mode;
    /**
     * select maximum element from object array which implements Comparable
     * @param arr source array
     * @return maximum element
     * @throws EmptyArrayException
     */
    public Comparable getMax(Comparable[] arr) throws EmptyArrayException{
        int length = arr.length;
        if( length == 0 ){
            throw new EmptyArrayException();
        }
        Comparable max = arr[0];
        for( int i = 1; i < length; i++ ){
            if( max.compareTo( arr[i] ) < 0 )
                max = arr[i];
        }
        return max;
    }
    /**
     * get the maximum element in the array
     * @param arr source array
     * @return maximum element
     */
    public double getMax(double[] arr) throws EmptyArrayException{
        int length = arr.length;
        if( length == 0 ){
            throw new EmptyArrayException();
        }
        double max = arr[0];
        for( int i = 1; i < length; i++ ){
            if( max < arr[i] )
                max = arr[i];
        }
        return max;
    }

    public Comparable getMin(Comparable[] arr) throws EmptyArrayException{
        int length = arr.length;
        if( length == 0 ){
            throw new EmptyArrayException();
        }
        Comparable min = arr[0];
        for( int i = 1; i < length; i++ ){
            if( min.compareTo(arr[i]) > 0 )
                min = arr[i];
        }
        return min;
    }

    /**
     * get the minimum element in the array
     * @param arr source array
     * @return return minimum element
     */
    public double getMin(double[] arr) throws EmptyArrayException{
        int length = arr.length;
        if( length == 0 ){
            throw new EmptyArrayException();
        }
        double min = arr[0];
        for( int i = 1; i < length; i++ ){
            if( min > arr[i] )
                min = arr[i];
        }
        return min;
    }

    /**
     * get the ith element of the array
     * @param index index of element
     * @param mode whether the ith largest element or the ith smallest mode
     * @return value of number
     */
    public Comparable select(Comparable[] arr,int index, short mode) throws IndexExceedBoundException{
        if( index >= arr.length )
            throw new IndexExceedBoundException();
        this.arr = arr;
        this.mode = mode;
        return randomSelect(0,arr.length-1,index);
    }

    Comparable randomSelect(int left,int right,int index){
        if( left == right )
            return arr[left];
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
            return arr[index];
        }
        selectPivot(left,right);
        int[] ret = partition(left+1,right - 1);
        if( index > ret[0] && index < ret[1] )
            return arr[index];
        if(index <= ret[0])
            return randomSelect(left,ret[0],index);
        else
            return randomSelect(ret[1],right,index);
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
    void exchange(int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
