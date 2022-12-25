package huaWeiOd.recursion;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/25
https://blog.csdn.net/misayaaaaa/article/details/128319496?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167169363516782425188104%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=167169363516782425188104&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-128319496-null-null.blog_rank_default&utm_term=%E5%A4%9A%E4%BD%99%E7%A9%BA%E6%A0%BC&spm=1018.2226.3001.4450
现有一个机器人，可放置于M×N的网格中  任意位置 ，每个网格包含一个非负整数编号，
当相邻网格的数字编号差值的 绝对值小于等于1 时，机器人可以在网格间移动

问题:求机器人可活动的最大范围对应的网格点数目。
说明:
.网格左上角坐标为(0,0),右下角坐标为(m-1,n-1)
.机器人只能在相邻网格间上下左右移动

输入描述
第1行输入为M和N，
    M表示网格的行数
    N表示网格的列数之后
    M行表示网格数值，每行N个数值(数值大小用k表示)，
数值间用单个空格分隔，行首行尾无多余空格
M、N、k均为整数，且1≤M,N≤150，O≤k≤50

输出描述
输出1行，包含1个数字，表示最大活动区域的网格点数目
行首行尾无多余空格
示例一
4 4
1 2 5 2
2 4 4 5
3 5 7 1
4 6 2 4

6  （对应起点为0,3）
示例二
输入
2 3
1 3
5 4
1 3
输出
1


 怎么比较元素大小
 置访问标记（不然 一个元素 可被上下左右的结点 访问多次，统计多次）
 终止判断

 类似 LC994 腐烂的橘子
 */
public class True_Q4_Robot {
//      自己  数组越界
//    static int res=0;
//    static  int[][] nums;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m=sc.nextInt();
//        int n=sc.nextInt();
//        nums = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                nums[i][j]=sc.nextInt();
//            }
//        }
//
//        System.out.println(findGezi(nums,0,0,res));
//
//    }
//
//
//    private static int findGezi(int[][] nums, int i,int j,int res) {
//        if(i-1>=0 &&  Math.abs(nums[i-1][j]-nums[i][j]) <=1){
//            res++;
//            return findGezi(nums,i-1,j,res);
//        }
//        if(j-1>=0 &&  Math.abs(nums[i][j-1]-nums[i][j]) <=1){
//            res++;
//            return  findGezi(nums,i,j-1,res);
//        }
//        if(i+1 < nums.length &&  Math.abs(nums[i+1][j]-nums[i][j]) <=1){
//            res++;
//            return findGezi(nums,i+1,j,res);
//        }
//        if(j+1< nums[0].length &&  Math.abs(nums[i][j+1]-nums[i][j]) <=1){
//            res++;
//            return  findGezi(nums,i,j+1,res);
//        }
//
//        return res;
//    }


    /*
    博主：
1:题目说机器人可以放在 任意位置  ，那么说明，起点要遍历所有的点。
2∶其实起点确定好，其余的就很好做了，从起点去判断上下左右是否可到达，一个简单的BFS。
    * */
        private static final int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 右 左 下 上
        private static int k = 1; // 暂存某一起点下 可访问到的结点数

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] matrix = new int[m][n];
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    matrix[x][y] = in.nextInt();
                }
            }

            // 起点可以是每一个位置
            int result = 0;
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix[x].length; y++) {
                    boolean[][] visited = new boolean[m][n]; // 标记是否访问过
                    k = 1;
                    bfs(matrix, visited, x, y);
                    result = Math.max(k, result);
                }
            }
            System.out.print(result);

        }

        public static void bfs(int[][] matrix, boolean[][] visited, int x, int y) {
            visited[x][y] = true; // 将当前结点标记为访问过
            //四个方向  查看是否可行
            for (int[] d : dic) {
                int newX = x + d[0], newY = y + d[1];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                    if (!visited[newX][newY] && Math.abs(matrix[x][y] - matrix[newX][newY]) <= 1) {
                        k++;
                        bfs(matrix, visited, newX, newY);
                    }
                }
            }
        }


}
