package huaWeiOd.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author QiangQin
 * * @date 2022/12/22
https://leetcode.cn/problems/number-of-islands/

给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1：
输入：grid = [
["1","1","1","1","0"],
["1","1","0","1","0"],
["1","1","0","0","0"],
["0","0","0","0","0"]
]
输出：1


示例 2：
输入：grid = [
["1","1","0","0","0"],
["1","1","0","0","0"],
["0","0","1","0","0"],
["0","0","0","1","1"]
]
输出：3


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
 
 */
public class LC200_numIsland {

    /*  自己*/
//    public int numIslands(char[][] grid) {
//        int  res=0;
//        return dfs(grid,0,0,res);
//
//    }
//
//    private int dfs(char[][] grid, int x,int y,int res) {
//        if(grid[x][y]==1){
//            grid[x][y]=0;
//            return 1;
//            dfs(grid,x-1,y,res);
//            dfs(grid,x,y-1,res);
//            dfs(grid,x+1,y,res);
//            dfs(grid,x,y+1,res);
//
//        }
//    }


    /*
    官方1：   深度优先
    我们可以将二维网格看成一个无向图，竖直或水平相邻的 1 之间有边相连。
为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 1，则以其为起始节点开始进行深度优先搜索。
在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。
最终岛屿的数量就是我们进行深度优先搜索的次数。

    * */
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') { // 遇见一个1，则把相连的1都置0，作为一个整体岛
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 先判断合法性
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


    /*
     官方2： 广度优先
    扫描整个二维网格。如果一个位置为 1，则将其加入队列，开始进行广度优先搜索。
    在广度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。直到队列为空，搜索结束。
        最终岛屿的数量就是我们进行广度优先搜索的次数。

    * */

    public int numIslandsBF(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);// 技巧！！！
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove(); // 广度优先。 每弹出一个结点  要 处理其所有相邻结点
                        int row = id / nc;
                        int col = id % nc;

                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }


    public static void main(String[] args) {

    }
}
