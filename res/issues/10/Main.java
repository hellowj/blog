package com.jun.blog;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    static int[] values = {2,4,1,17,7,5,11,9,3,9,1,18,4,4};

    public static void main(String[] args) {
        int result = maxValue(0, values.length-1);
        System.out.println("result = " + result);
    }

    static public int maxValue(int start, int end){
        if(end - start <= 1){
            return values[start] - values[end];
        }
        int mid = (start + end)/2;
        int min = values[end];
        int max = values[start];
        for(int i=start; i<=mid; i++){
            if(max < values[i]){
                max = values[i];
            }
        }
        for(int i=mid+1; i<=end; i++){
            if(min > values[i]){
                min = values[i];
            }
        }
        int result0 = max - min;
        int result1 = maxValue(start, mid);
        int result2 = maxValue(mid+1, end);
        return Math.max(result2, Math.max(result0, result1));
    }

}
