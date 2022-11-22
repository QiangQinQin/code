package huaWeiOd.recursion;

import java.util.Arrays;

/**
 * @author QiangQin
 * * @date 2022/11/20
https://leetcode.cn/problems/rotting-oranges/

在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
    值0代表空单元格；
    值1代表新鲜橘子；
    值2代表腐烂的橘子。
每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。

返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。

 */

public class LC994_orange {

   static  class orange{
        int value;
        int ite=-1;//第ite轮迭代是否是坏的
        int x=0,y=0;

        orange(int value,int x,int y){
            this.value=value;
            this.x=x;
            this.y=y;
            this.ite=-1;
        }

        @Override
        public String toString() {
            return "orange{" +
                    "value=" + value +
                    ", ite=" + ite +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1}, {1,1,0}, {0,1,1}};
        int[][] grid = {{0,2}};
//        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        orange[][] orgs = new orange[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                orgs[i][j] = new orange(grid[i][j], i, j);
            }
        }

//        System.out.println(Arrays.deepToString(orgs));

        do{
            change=0;
            // 一次迭代，遍历反格所有橘子
            for (int i = 0; i < orgs.length; i++) {
                for (int j = 0; j < orgs[0].length; j++) {
                    // 判断至少上轮时，是否为坏橘子,
                    if(orgs[i][j].value == 2 && orgs[i][j].ite != iteCount){
                        // 若是，试图去感染周围的橘子
                        deal(orgs,i,j,grid.length,grid[0].length,iteCount);
                    }
                }
            }
            iteCount++;
        }while(change!=0);

        //判断最后是否有 感染不到的 新橘子
        for (int i = 0; i < orgs.length; i++) {
            for (int j = 0; j < orgs[0].length; j++) {
                if(orgs[i][j].value==1){
                    System.out.println(-1);
                    return ;
                }
            }
        }
        System.out.println(iteCount-1);
    }

    private static void deal(orange[][] orgs, int i, int j, int row, int col, int iteCount) {
        //该橘子周围  是否有橘子
        if(i-1>0  && orgs[i-1][j].value==1){
            orgs[i-1][j].value=2;
            orgs[i-1][j].ite=iteCount;
            change++;
        }
        if(i+1<row && orgs[i+1][j].value==1){
            orgs[i+1][j].value=2;
            orgs[i+1][j].ite=iteCount;
            change++;
        }
        if(j-1>0 && orgs[i][j-1].value==1){
            orgs[i][j-1].value=2;
            orgs[i][j-1].ite=iteCount;
            change++;
        }
        if(j+1<col && orgs[i][j+1].value==1){
            orgs[i][j+1].value=2;
            orgs[i][j+1].ite=iteCount;
            change++;
        }
    }

    static  int change=0,iteCount=0;//比ite大1
}
