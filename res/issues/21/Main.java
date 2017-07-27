package com.jun.blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        bfs();
    }

    static public void bfs(){
        int n = 5;
        int max = 10;
        int[][] map = {
                {0,1,0,0,0},
                {0,1,0,1,0},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,1,0}};
        int[][] result = new int[2][max];
        for(int i=0; i<max; i++){
            result[0][i] = -1;
            result[1][i] = -1;
        }
        int[][] path = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                path[i][j] = -1;
            }
        }
        List<Integer> xs = new ArrayList();
        List<Integer> ys = new ArrayList();
        xs.add(0);
        ys.add(0);
        while (xs.size()>0){
            int x = xs.get(0);
            int y = ys.get(0);
            xs.remove(0);
            ys.remove(0);
            path[x][y] = 0;
            //System.out.println("x="+x+", y="+y);

            if(x == n-1 && y == n-1){
                System.out.println("success");
                break;
            }

            if(x<n-1 && y<n && map[x+1][y] == 0){
                xs.add(x+1);
                ys.add(y);
            }
            if(x<n && y<n-1 && map[x][y+1] == 0){
                xs.add(x);
                ys.add(y + 1);
            }
        }
        //System.out.println(Arrays.deepToString(path));
        int xx = n - 1;
        int yy = n - 1;
        int step = 1;
        result[0][0] = n-1;
        result[1][0] = n-1;
        while(true){
            //System.out.println("xx="+xx+", yy="+yy);
            if(yy != 0 && path[xx][yy - 1] == 0){
                result[0][step] = xx;
                result[1][step] = yy-1;
            } else if (xx != 0) {
                result[0][step] = xx-1;
                result[1][step] = yy;
            }
            xx = result[0][step];
            yy = result[1][step];
            step++;
            if(xx == 0 && yy == 0){
                break;
            }
        }
        for(int i=0; i<max; i++){
            if(result[0][max-1-i] > -1){
                System.out.println(result[0][max-1-i] + "," + result[1][max-1-i]);
            }
        }
    }

}
