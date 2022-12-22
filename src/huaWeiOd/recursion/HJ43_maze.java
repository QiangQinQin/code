package huaWeiOd.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/7
https://www.nowcoder.com/practice/cf24906056f4488c9ddb132f317e03bc?tpId=37&tqId=21266&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

描述
定义一个二维数组 N*M ，如 5 × 5 数组下所示：
int maze[5][5] = {
0, 1, 0, 0, 0,
0, 1, 1, 1, 0,
0, 0, 0, 0, 0,
0, 1, 1, 1, 0,
0, 0, 0, 1, 0,
};

它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，
要求编程序找出从左上角到右下角的路线。
入口点为[0,0],既第一格是可以走的路。

数据范围： 2≤n,m≤10  ， 输入的内容只包含 0≤val≤1

输入描述：
输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。
数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

输出描述：
左上角到右下角的最短路径，格式如样例所示。

示例1
输入：
5 5
0 1 0 0 0
0 1 1 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
  
输出：
(0,0)
(1,0)
(2,0)
(2,1)
(2,2)
(2,3)
(2,4)
(3,4)
(4,4)
  
示例2
输入：
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 1
0 1 1 1 0
0 0 0 0 0
  
输出：
(0,0)
(1,0)
(2,0)
(3,0)
(4,0)
(4,1)
(4,2)
(4,3)
(4,4)

说明：
注意：不能斜着走！！


深度优先搜索的思想是
  沿着一个方向搜到底，如果行不通，则返回来试其他的路径。就一直这样直到找到一条通路输出就可以了
 */

// 结点
    class Node{
        int value;
        int x;
        int y;

    public Node(int value,int x,int y){
            this.value=value;
            this.x=x;
            this.y=y;
        }
}
public class HJ43_maze {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            // 输入(合法 且 有解)
                int row= sc.nextInt();
                int col=sc.nextInt();
            Node[][] maze = new Node[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j]=new Node(sc.nextInt(),i,j);
                }
            }

         /*
        深度遍历
        终止条件是到右下角
        栈弹出，尝试其四个方向
        path 存放路径
        */
            ArrayList<Node> list = new ArrayList<>();
            dfs(maze,list,maze[0][0]);
            //  打印结果
            for (int i = 0; i < list.size(); i++) {
                System.out.println("("+list.get(i).x+","+list.get(i).y+")");
            }

        }

    }

    private static boolean dfs(Node[][] maze, ArrayList<Node> path, Node node) {
        path.add(node);//添加到末尾
        maze[node.x][node.y].value = 1;//不走回头路（没意义,且会导致程序无法终止）
        // 即走到右下角，就可以退出
        if(node.x==maze.length-1  && node.y==maze[0].length-1){ // 注意length要-1
            return true;
        }
//        判断能否 向下走
        if(node.x+1 < maze.length  && maze[node.x+1][node.y].value==0){
            if(dfs(maze,path,maze[node.x+1][node.y])){
                return  true;
            }
        }
//如果上面没有return,就判断能否 向右走
        if(node.y+1 < maze[0].length  && maze[node.x][node.y+1].value==0){
            if(dfs(maze,path,maze[node.x][node.y+1])){
                return  true;
            }
        }
//向上能走时
        if(node.x -1 > -1   && maze[node.x-1][node.y].value==0){ //注意为-1
            if(dfs(maze,path,maze[node.x-1][node.y])){
                return  true;
            }
        }
//向左能走时
        if(node.y-1 >-1  && maze[node.x][node.y-1].value==0){
            if(dfs(maze,path,maze[node.x][node.y-1])){
                return  true;
            }
        }

        //上面都没return,即路不通，恢复原样
        maze[node.x][node.y].value = 0;
        path.remove(path.size()-1); //从末尾删除
        return  false;
    }
}


/*
import java.util.*;
// 题目已经提示了 【迷宫只有一条通道】，则直接使用 DFS 找路径就行了，如不有多条路径找最短考虑使用 BFS
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            // 构造迷宫
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            // 路径存储的数组
            List<Pos> path = new ArrayList<>();
            // DFS 搜索路径
            dfs(map, 0, 0, path);
            // 输出
            for (Pos p : path) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }

    // 返回值 标记是否找到可通行的路劲
    public static boolean dfs(int[][] map, int x, int y, List<Pos> path) {
        // 添加路径并标记已走
        path.add(new Pos(x, y));
        map[x][y] = 1;
        // 结束标志
        if (x == map.length - 1 && y == map[0].length - 1) {
            return true;
        }
        // 向下能走时
        if (x + 1 < map.length && map[x + 1][y] == 0) {
            if (dfs(map, x + 1, y, path)) {
                return true;
            }
        }
        // 向右能走时
        if (y + 1 < map[0].length && map[x][y + 1] == 0) {
            if (dfs(map, x, y + 1, path)) {
                return true;
            }
        }
        // 向上能走时
        if (x - 1 > -1 && map[x - 1][y] == 0) {
            if (dfs(map, x - 1, y, path)) {
                return true;
            }
        }
        // 向左能走时
        if (y - 1 > -1 && map[x][y - 1] == 0) {
            if (dfs(map, x, y - 1, path)) {
                return true;
            }
        }
        // 回溯
        path.remove(path.size() - 1);
        map[x][y] = 0;
        return false;
    }

    // 简单的位置类
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

* */