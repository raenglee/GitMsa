package org.example;

/*
2. 다음 메소드는 int형 1차원 배열에 저장된 값을 두 번째 매개변수로 전달된 값의 크기만큼 전부 증가시킨다.
public static void addOneDArr(int[] arr, int add){
    for(int i =0; i<arr.length; i++){
        arr[i] += add;
    }
}
위 메소드를 호출하는 형태로, int형 2차원 배열에 저장된 값 전부를 두번째 매개변수로 전달된 값의 크기만큼
증가시키는 메소드를 다음의 형태로 정의하자
public static void addTwoDArr(int[][] arr, int add){
    // 이안에 addOneDArr 메소드를 호출한다.
}
3. 다음 형태로 표현된 2차원 배열이 존재한다고 가정해보자
1   2    3   //1행
4   5    6   //2행
7   8    9   //3행
이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 다음의 형태로 배열의 구조를 변경시키는 메소드를 정의하자
7   8    9   //1행
1   2    3   //2행
4   5    6   //3행
물론 배열의 가로와 세로길이에 상관없이 위와 같이 동작하도록 메소드를 정의해야 한다.
 */

import java.util.Arrays;

public class Ex00 {

    public static void addOneDArr(int[] arr, int add){
        for(int i =0; i<arr.length; i++){
            arr[i] += add;
        }
    }

    public static void addTwoDArr(int[][] arr, int add){
        for (int i = 0; i < arr.length; i++) {
            addOneDArr(arr[i],add);
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3,},{4,5,6},{7,8,9}};

        addTwoDArr(arr,5);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));
    }
}