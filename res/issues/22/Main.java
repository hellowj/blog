package com.jun.blog;


/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99,100};
        int result = binarySearch(a1, 4);
        System.out.println(result);
    }

    static public int binarySearch(int array[],int key) {
        int begin = 0;
        int end = array.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (array[mid] > key){
                end = mid - 1;
            }
            else if (array[mid] < key){
                begin = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
