package com.yday72__7.reviewCodes.generic;

public class App {
    public static void main(String[] args) {
        Double[] arr1 = {1.1, 3.2, 7.1, 2.9, 3.3};
        List<Double> list= new List<>(arr1);
        System.out.println(list.findMax());

        Integer[] arr2 = {4, 5, 1, 3, 6, 2};
        List<Integer> list2= new List<>(arr2);
        System.out.println(list2.findMax());
    }
}
