package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex02 {

    public static void main(String[] args) {
    List<Car> list = Arrays.asList(
            new Car("그랜저", 3000),
            new Car("K8", 3500),
            new Car("쏘렌토", 2200)
    );

    for(Car car : list){
            System.out.println(car);
        };
        System.out.println(list.get(0));  //한개씩 출력 0번째

//        Collections.sort(list, new Comparator<Car>() {
//                    @Override
//                    public int compare(Car o1, Car o2) {
//                        return o2.getDisp() - o1.getDisp();  //내림차순 정렬
//                    }
//                });


        //아래로는 람다
//        Collections.sort(list, ((o1, o2) -> o2.getDisp()-o1.getDisp()));
//        Collections.sort(list, ((o2, o1) -> o2.getDisp().compareTo(o2.getDisp()))); <- 틀렸는데 뭔지잘모르겠음
//        Collections.sort(list, ((o1, o2) -> o1.getName().length()-o2.getName().length()));


                System.out.println();
        for(Car car : list){
            System.out.println(car);
        }
    }
}
