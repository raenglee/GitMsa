package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex03 {

    //boolean test(T t);
    public static int sum(Predicate<Integer> predicate, List<Integer> list){
        int mysum = 0;
        for(int n :list){
            if(predicate.test(n))
                mysum+=n;
        }
        return mysum;
    }

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,5,3,9,1,15,8);

        int result = sum( integer -> integer%2==1 , list);
        System.out.println(result);
    }
}
