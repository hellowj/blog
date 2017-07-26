package com.jun.blog;

import java.util.Arrays;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        dijkstra();
    }

    static public void dijkstra(){
        int infinity = 999999;
        int[][] paths = {
                {0, 1, 12, infinity, infinity, infinity},
                {infinity, 0, 9, 3, infinity, infinity},
                {infinity, infinity, 0, infinity, 5, infinity},
                {infinity, infinity, 4, 0, 13, 15},
                {infinity, infinity, infinity, infinity, 0, 4},
                {infinity, infinity, infinity, infinity, infinity, 0}};
        int[] dis = {0, 1, 12, infinity, infinity, infinity};
        boolean[] sure = {true, false, false, false, false, false};
        int temp = infinity, min = 0, n = 6;
        System.out.println(Arrays.toString(dis));
        for(int i=1; i<n; i++){
            for(int m=0; m<dis.length; m++){
                if(!sure[m] && temp > dis[m]){
                    temp = dis[m];
                    min = m;
                }
            }
            temp = infinity;
            for(int j=0; j<n; j++){
                if(j != min && !sure[j] && paths[min][j] + dis[min] < dis[j]){
                    dis[j] = paths[min][j] + dis[min];
                    System.out.println(Arrays.toString(dis));
                }
            }
            sure[min] = true;
        }
    }

}
