/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-23 14:26
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */
import com.mialgo.sort.*;
import java.util.*;
import java.lang.Integer;

public class Test {
    final private static int TEST_SCALE = 10000;
    final private static int MAX = 100;
    public static void main(String[] args){
        Random rand = new Random(TEST_SCALE);
        int[] arr_int = new int[TEST_SCALE];
        // test for primitives
        for(int i= 0 ; i < TEST_SCALE ; i++)
            arr_int[i] = rand.nextInt(MAX);
        System.out.println("before sort");
        for( int value : arr_int )
            System.out.print(value+",");
        Sort.process(arr_int,new InsertionSort());
        System.out.println("after sort");
        for ( int value: arr_int)
            System.out.print(value+",");

        // test for objects
        Integer[] arr_obj = new Integer[TEST_SCALE];
        for( int i = 0; i < TEST_SCALE ; i++ )
            arr_obj[i] = new Integer(rand.nextInt(MAX));
        System.out.println("before sort");
        for( Integer value : arr_obj )
            System.out.print(value+",");
        Sort.process(arr_obj,new InsertionSort());
        System.out.println("after sort");
        for ( Integer value: arr_obj)
           System.out.print(value+",");


    }
}
