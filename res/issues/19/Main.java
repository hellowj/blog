package com.jun.blog;

import java.util.Arrays;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        floyd();
    }

    static public void floyd(){
        int infinity = 999999;
        int[][] paths = {
                {0, 2, 6, 4},
                {infinity, 0, 3, infinity},
                {7, infinity, 0, 1},
                {5, infinity, 12, 0}};
        int n = 4;
        System.out.println(Arrays.deepToString(paths));
        for(int k=0; k<n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (paths[i][j] > paths[i][k] + paths[k][j]) {
                        paths[i][j] = paths[i][k] + paths[k][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(paths));
    }

}
