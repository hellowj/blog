package com.jun.blog;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        MaxSubArray();
    }

    static public void MaxSubArray(){
        int[]  a = {1, -2, 3, 10, -4, 7, 2, -5};
        int curSum = 0, maxSum = 0;
        for(int i=0; i<a.length; i++){
            curSum += a[i];
            if(curSum < 0){
                curSum = 0;
            }
            if(curSum > maxSum){
                maxSum = curSum;
            }
        }
        System.out.println("maxSum = " + maxSum);
    }

}
