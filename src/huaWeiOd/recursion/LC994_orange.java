package huaWeiOd.recursion;

import java.util.*;

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

/*   多源广度优先搜索     */
class Solution {
    int[] dr = new int[]{-1, 0, 1, 0}; // dr[0] 搭配dc[0] 即 上左下右的坐标
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();//怀橘子队列
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();//坏橘子深度
        // 初始化数据
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;//算位置是 从左往右  从上往下第几个
                    queue.add(code);//尾进
                    depth.put(code, 0);
                }
            }
        }

        // 广度优先，腐烂橘子
        int ans = 0;
        // 每一个时间 都有一个队
        while (!queue.isEmpty()) {
            int code = queue.remove();//头出
            int r = code / C, c = code % C;//还原出 坐标
            for (int k = 0; k < 4; ++k) { //处理 当前坐标的  四周橘子
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) { //坐标合法 且 是好橘子,就变坏,加到坏队 且 记录深度 且 更新 坏时间
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);//将新坏橘子入队
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row: grid) {//二位数组,相当于每个元素是一维数组的 一维数组   将二维数组 按 行遍历
            for (int v: row) { //再遍历数组 某行的每一列
                if (v == 1) { //即 没有新增坏橘子时 有 新鲜的
                    return -1;
                }
            }
        }
        return ans;
    }
}

public class LC994_orange {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1,1,0}, {0,1,1}};
        System.out.println(new Solution().orangesRotting(grid));

    }
///*
//自己（模拟法   代码越复杂，越容易出错）
//
//橘子（坐标 、状态 、 第几轮）
//只要新增感染数 不为0，就 遍历方格中的每一个橘子
//最后根据 是否有新鲜橘子 输出结果
//* */
//   static  class orange{
//        int value;
//        int ite=-1;//第ite轮迭代是否是坏的
//        int x=0,y=0;
//
//        orange(int value,int x,int y){
//            this.value=value;
//            this.x=x;
//            this.y=y;
//            this.ite=-1;
//        }
//
//        @Override
//        public String toString() {
//            return "orange{" +
//                    "value=" + value +
//                    ", ite=" + ite +
//                    ", x=" + x +
//                    ", y=" + y +
//                    '}';
//        }
//    }
//    public static void main(String[] args) {
////        int[][] grid = {{2, 1, 1}, {1,1,0}, {0,1,1}};
//        int[][] grid = {{0,2}};
////        int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        orange[][] orgs = new orange[grid.length][grid[0].length];
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                orgs[i][j] = new orange(grid[i][j], i, j);
//            }
//        }
//
////        System.out.println(Arrays.deepToString(orgs));
//
//        do{
//            change=0;
//            // 一次迭代，遍历方格所有橘子
//            for (int i = 0; i < orgs.length; i++) {
//                for (int j = 0; j < orgs[0].length; j++) {
//                    // 判断至少上轮时，是否为坏橘子,
//                    if(orgs[i][j].value == 2 && orgs[i][j].ite != iteCount){
//                        // 若是，试图去感染周围的橘子
//                        deal(orgs,i,j,grid.length,grid[0].length,iteCount);
//                    }
//                }
//            }
//            iteCount++;
//        }while(change!=0);
//
//        //判断最后是否有 感染不到的 新橘子
//        for (int i = 0; i < orgs.length; i++) {
//            for (int j = 0; j < orgs[0].length; j++) {
//                if(orgs[i][j].value==1){
//                    System.out.println(-1);
//                    return ;
//                }
//            }
//        }
//        System.out.println(iteCount-1);
//    }
//
//    private static void deal(orange[][] orgs, int i, int j, int row, int col, int iteCount) {
//        //该橘子周围  是否有橘子
//        if(i-1>0  && orgs[i-1][j].value==1){
//            orgs[i-1][j].value=2;
//            orgs[i-1][j].ite=iteCount;
//            change++;
//        }
//        if(i+1<row && orgs[i+1][j].value==1){
//            orgs[i+1][j].value=2;
//            orgs[i+1][j].ite=iteCount;
//            change++;
//        }
//        if(j-1>0 && orgs[i][j-1].value==1){
//            orgs[i][j-1].value=2;
//            orgs[i][j-1].ite=iteCount;
//            change++;
//        }
//        if(j+1<col && orgs[i][j+1].value==1){
//            orgs[i][j+1].value=2;
//            orgs[i][j+1].ite=iteCount;
//            change++;
//        }
//    }
//
//    static  int change=0,iteCount=0;//比ite大1
}
