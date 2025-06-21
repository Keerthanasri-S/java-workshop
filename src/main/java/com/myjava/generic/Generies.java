package com.myjava.generic;

public class Generies<T extends Comparable<T>> {
    public void  sortingalg(T[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j =i+1;j< arr.length;j++){
                if(arr[i].compareTo(arr[j])>0){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public void print(T[] arr){
        for(T values:arr){
            System.out.println(values);
        }
    }

    public static void main(String[] args) {
        Generies<Integer> list= new Generies<>();
        Integer[] arr = {10,38,79,29,30};
        list.sortingalg(arr);
        list.print(arr);

        Generies<String> stringList= new Generies<>();
        String[] arr1 = {"keerthana","chandra"};
        stringList.sortingalg(arr1);
        stringList.print(arr1);
    }

}
