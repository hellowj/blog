package com.jun.blog;


import java.util.Arrays;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        minNumber();
        System.out.println();
        add();
        System.out.println();
        addToEnd();
    }

    static public void minNumber(){
        int[] a = {99,5,36,7,22,17,46,12,2,19,25,28,1,92};
        int min = a[0];
        for(int i=0; i<a.length; i++){
            if(a[i]<min) {
                min=a[i];
            }
        }
        System.out.println(min);
    }

    static public void add(){
        int[] a = {-1,2,5,12,7,17,25,19,36,99,22,28,46,92};
        a[0] = 23;
        System.out.println(Arrays.toString(a));
        int i = 0, t, newValue;
        while (i*2+1 < a.length){
            newValue = a[i];
            if(a[i*2+1] > a[i*2+2]){
                t = i*2+2;
            }else{
                t = i*2+1;
            }
            a[i] = a[t];
            a[t] = newValue;
            i = t;
            System.out.println("在循环里");
        }
        System.out.println(Arrays.toString(a));
    }

    static public void addToEnd(){
        int[] a = {2,7,5,12,22,17,25,19,36,99,23,28,46,92,-1};
        a[a.length - 1] = 3;
        int newValue, i = a.length - 1;
        System.out.println(Arrays.toString(a));
        while(i>0){
            newValue = a[i];
            if(a[i] < a[i/2-1]){
                a[i] = a[i/2-1];
                a[i/2-1] = newValue;
                i = i/2-1;
            }else{
                break;
            }
            System.out.println("在循环里");
        }
        System.out.println(Arrays.toString(a));
    }

}
