/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-09-23 14:26
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */
import com.mialgo.selection.IndexExceedBoundException;
import com.mialgo.selection.Selection;
import com.mialgo.sort.*;
import java.util.*;
import java.lang.Integer;

public class Test {
    final private static int TEST_SCALE = 10;
    final private static int MAX = 100;

    static void test(){
        Random rand = new Random(TEST_SCALE);
        int[] arr_int = new int[TEST_SCALE];
        // test for primitives
        for(int i= 0 ; i < TEST_SCALE ; i++)
            arr_int[i] = rand.nextInt(MAX);
        System.out.println("before sort");
        for( int value : arr_int )
            System.out.print(value+",");
        Sort.process(arr_int,new QuickSort(),Sort.DESCENDING);
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
        System.out.println("");
        Sort.process(arr_obj,new QuickSort(),Sort.DESCENDING);
        System.out.println("after sort");
        for ( Integer value: arr_obj)
            System.out.print(value+",");
    }
    public static void main(String[] args){
       //  test();
        Random rand = new Random(TEST_SCALE);
        double[] arr_int = new double[TEST_SCALE];
        // test for primitives
        for(int i= 0 ; i < TEST_SCALE ; i++)
            arr_int[i] = rand.nextDouble();
        System.out.println("before sort");
        for( double value : arr_int )
            System.out.print(value+",");
        System.out.println("");
        try{
            double d = Selection.select(arr_int,2,Sort.DESCENDING);
            System.out.println("select " + d);
        }catch(Exception e){
            System.out.println("Index out of bounds");
        }

        System.out.println("after sort");
        new BucketSort().sort(arr_int,Sort.ASCENDING);
        for ( double value: arr_int)
            System.out.print(value+",");
    }
}
