package com.jun.blog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    static int grid[][] =
            {{5, 8, 5, 7, 1, 8},
                    {1, 3, 2, 8, 7, 9},
                    {7, 8, 6, 6, 8, 7},
                    {9, 9, 8, 1, 6, 3},
                    {2, 4, 10, 2, 6, 2},
                    {5, 5, 2, 1, 8, 8}};

    static int value[][] =
            {{5, 8, 5, 7, 1, 8},
                    {1, 3, 2, 8, 7, 9},
                    {7, 8, 6, 6, 8, 7},
                    {9, 9, 8, 1, 6, 3},
                    {2, 4, 10, 2, 6, 2},
                    {5, 5, 2, 1, 8, 8}};

    public static void main(String[] args) {
        test();
    }

    static public void test(){
        dp(0, 0);
        int x = 5;
        int y = 5;
        int left;
        int up;
        List<String> list = new ArrayList<>();
        list.add("[" + x + "," + y + "]");
        //System.out.println("[" + x + "," + y + "] = " + value[x][y]);
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(x == 0){
                    y--;
                }else if(y == 0){
                    x--;
                }else {
                    left = value[x][y - 1];
                    up = value[x - 1][y];
                    if (left > up) {
                        y = y - 1;
                    } else {
                        x = x - 1;
                    }
                }
                list.add(0,"[" + x + "," + y + "]");
                if(x ==0 && y == 0){
                    System.out.println(Arrays.deepToString(list.toArray()));
                    return;
                }
            }
        }
    }

    static public void dp(int x, int y){
        value[x][y] = grid[x][y];
        int max = 0;
        int n = 6;
        //from top
        if(x > 0 && max < value[x-1][y]){
            max = value[x-1][y];
        }
        //from left
        if(y > 0 && max < value[x][y-1]){
            max = value[x][y-1];
        }
        value[x][y] += max;
        if(x < n-1){
            dp(x+1, y);
        }
        if(y < n-1){
            dp(x, y+1);
        }
    }

}
