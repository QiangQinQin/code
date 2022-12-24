package huaWeiOd.recursion;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/22
 *
https://renjie.blog.csdn.net/article/details/128159161
题目
题目描述
给你一个由大于0的数（陆地)和0(水)组成的的二维网格，请你计算网格中最大岛屿的体积。
陆地的数表示所在岛屿的体积。岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
输入描述
第一行是二维网格的宽和高。
后面几行是二维网格。
输出描述
输出岛屿的最大体积。
样例
输入
5 5
0 1 1 0 0
0 1 1 0 0
0 0 0 0 0
0 0 1 2 3
0 0 1 3 9
输出
19

思路
1: leetcode 200原题。
2:唯—做了一些改动就是将求解岛屿的个数，改为了求岛屿中最大的那个的面积
考点
1: DFS
 */
public class True_Q4_maxIsland {
//
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int row=sc.nextInt();
//        int col=sc.nextInt();
//        int[][] nums = new int[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                nums[i][j]= sc.nextInt();
//            }
//        }
//
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if(nums[i][j]!=0){ // 遍历该点周围所有的
////                    nums[i][j]=0;
//                    area=0;
//                    dfs(nums,i,j);
//                }
//            }
//        }
//
//        System.out.println(maxIsland);
//    }
//    static int maxIsland=0;
//    static int area=0;
//    private static void dfs(int[][] nums, int i, int j) {
//        if(nums[i][j]==0){ //如果从53放调过来，那么 nums[i][j]一定为0
//            return;
//        }else if(nums[i][j]!=0){
//            area+=nums[i][j]; // 每遇到一个，累加 +  更新
//            maxIsland= area > maxIsland ? area:maxIsland;
//            nums[i][j]=0;
//        }
//
//        if(i-1>=0){
//            dfs(nums,i-1,j);
//        }
//        if(i+1<nums.length){
//            dfs(nums,i+1,j);
//        }
//        if(j-1>=0){
//            dfs(nums,i,j-1);
//        }
//        if(j+1<nums[0].length){
//            dfs(nums,i,j+1);
//        }
//    }

        static int area;
        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            int row = in.nextInt();
            int col = in.nextInt();
            int[][] matrix = new int[row][col];
            int max = Integer.MIN_VALUE;
            //初始化岛屿
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] > 0) {
                        area = 0;
                        //求当前点所属岛屿的大小
                        dfs (matrix, i, j);
                        max = Math.max(area, max);
                    }
                }
            }
            System.out.println(max);

        }
        public static void dfs(int[][] matrix, int i, int j) {
            int row = matrix.length, col = matrix[0].length;
            if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] == 0) {
                return;
            }
            area += matrix[i][j];
            matrix[i][j] = 0;
            //上下左右判断是否为1
            dfs(matrix, i-1, j);
            dfs(matrix, i+1, j);
            dfs(matrix, i, j-1);
            dfs(matrix, i, j+1);
        }

}
