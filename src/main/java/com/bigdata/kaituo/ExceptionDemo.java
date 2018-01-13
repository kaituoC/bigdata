package com.bigdata.kaituo;

/**
 * Created by chang on 2017/3/11.
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};
        try {
            System.out.println(a[4]);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        System.out.println("ok");
    }
}
