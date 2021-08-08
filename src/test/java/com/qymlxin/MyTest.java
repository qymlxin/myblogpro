package com.qymlxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = Arrays.asList(a);
        for(int b : list) {
            if(b == 12) return;
            System.out.println(b);
        }
        System.out.println(123146);
    }
}
