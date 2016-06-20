package ClassWork.week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhabenya on 18.06.16.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {5, 6, 9, 3, 2, 0, 4, 8, 9};

        boolean isContains =  contains(arr, 8);

        Arrays.sort(arr);

        int[] sortedArray = arr;
        boolean isBContains =  binaryContains(sortedArray, 8);

        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Hell");
        list.add("Hola");
        list.add("Hi");

        Collections.sort(list);


       // System.out.println(binarySearchComparator(list, "Hello"));
    }

       /*private static < T extends Comparable<T>> boolean binarySearchComparator(List<T> list, String word) {

           int start = 0;
           int end = list.size() - 1;

           while (start != end) {

               int mid = start + (end - start) / 2;

               if (list.get(mid).compareTo(word) < 0){
                   start = mid + 1;
               }
               else if(list.get(mid).compareTo(word) > 0){
                   end = mid - 1;
               }
               else {
                   return true;
               }

           }
           return false;
       }*/
       private static boolean binaryContains(int[] arr, int num){

           int start = 0;
           int end = arr.length - 1;

           while (start != end) {

               int mid = start + (end - start) / 2;

               if (arr[mid] < num){
                   start = mid + 1;
               }
               else if(arr[mid] > num){
                   end = mid - 1;
               }
               else {
                   return true;
               }

           }

           return false;
       }

        private static boolean contains(int[] arr, int num) {

            for (int i = 0; i < arr.length; i++) {

            if (arr[i] == num) return true;
        }

            return false;

    }
}
