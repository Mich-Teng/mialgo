package com.mialgo.tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * ******************************************************************
 * Author: Chao Teng
 * Time: 2013-11-15 16:59
 * License: GNU/GPL
 * 
 * Welcome to contact MichZc.Teng@gmail.com if any problems are found
 * ******************************************************************
 */


public class ObjectToolsTest {
    @Before
    public void init(){

    }

    @After
    public void destroy(){

    }

    @Test
    public void exchange(){
        boolean flag = false ;
        Integer[] l1 = {1,2};
        Integer[] l2 = {};
        Integer[] l3 = null;

        // normal condition
        ObjectTools.exchange(l1,0,1);
        assertTrue(l1[0] == 2);
        // index out of bounds
        try{
            ObjectTools.exchange(l2,0,1);
        }catch(Exception e){
            flag = true;
        }
        assertTrue(flag);
        flag = false;
        // null pointer
        try{
            ObjectTools.exchange(l3,0,1);
        }catch(Exception e){
            flag = true;
        }
        assertTrue(flag);
    }

    @Test
    public void arrayToList(){
        Integer[] l1 = {1,2};
        Integer[] l2 = {};
        Integer[] l3 = null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        // normal case
        list = (ArrayList<Integer>)ObjectTools.arrayToList(l1);
        assertTrue(list.get(0) == 1);
        // empty list
        list = (ArrayList<Integer>)ObjectTools.arrayToList(l2);
        assertTrue(list.getClass().getName().equals( "ArrayList" ) );
        // null pointer
        list = (ArrayList<Integer>)ObjectTools.arrayToList(l3);
        assertTrue(list == null);
    }

    @Test
    public void listToArray(){
        ArrayList<Integer> l1 = new ArrayList<Integer>(){{ add(1); add(2);}};
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        ArrayList<Integer> l3 = null;
        // normal case
        Integer[] arr = ObjectTools.listToArray(l1);
        assertTrue(arr[0] == 1);

        // empty list
        arr = ObjectTools.listToArray(l2);
        assertTrue(arr == null );

        // null pointer
        arr = ObjectTools.listToArray(l3);
        assertTrue(arr == null );
    }

    @Test
    public void unpack() {
        Double[] d = {1.2,3.0};
        double[] dArray = ObjectTools.unpack(d);
        assertTrue(dArray[0] == 1.2);
    }

}
