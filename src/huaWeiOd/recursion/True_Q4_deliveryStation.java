package huaWeiOd.recursion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author QiangQin
 * * @date 2022/12/25

https://renjie.blog.csdn.net/article/details/128418102
题目描述:
快递业务范围有N个站点，A站点与B站点可以中转快递，则认为A-B站可达，如果A-B可达，B-C可达，则A-C达。
现在给N个站点编号0、1、..n-1，用s[加]表示i j是否可达，s[i][j]=1表示i-j问达，s[i][j]=0表示i-j不可达。
现用二维数组给定N个站点的可达关系，请计算至少选择从几个主站点出发，才能可达所有站点(覆盖所有站点业)

说明: s[i][j]与s[j][i]取值相同

输入描述:
第一行输入为N，N表示站点个数之后N行表示站点之间的可达关系，
第i行第i个数值表示编号为i和i之间是否可达

输出描述:
输出站点个数，表示至少需要多少个主站点

补充说明:
1<N<10000
示例1
输入:
4
1 1 1 1
1 1 1 0
1 1 1 0
1 0 0 1
输出:
1
说明:
选择0号站点作为主站点，0站点可达其他所有站点，所以至少选择1个站点作为主站才能覆盖所有站点业务。

示例2
输入:
4
1 1 0 0
1 1 0 0
0 0 1 0
0 0 0 1
输出:
3
说明:
选择0号站点可以覆盖0、1站点，
选择2号站点可以覆盖2号站点，
选择3号站点可以覆盖3号站点，
所以至少选择3个站点作为主站才能覆盖所有站点业务。

4
1 1 1 1
1 1 1 0
1 1 1 0
1 0 0 1

 自己到自己,一定可达 Matrix[0,0]=[1,1]=[2,2]=[3,3]=1
 无向图，即 A->B可达  则 B->A也可达,即[i,j]=[j,i]
  可中转， A->B->C
//todo 理解
1:又是一个类似岛屿个数的那种DFS题目，回溯法，
从每一个站点出发，将可以到达的站点置为已到达(可以用一个集合或者map来保存已到达的站点)，
最后看需要从多少个站点出发的个数即可。
 */
public class True_Q4_deliveryStation {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        //已经 有连通的站点
        Set<Integer> site_set = new HashSet<>();
        //需要遍历的次数
        int res = 0;
        for (int i = 0; i < N; i++) {
            //当前站点已经可以达到，则直接退出，无需res++ !!!!
            if (site_set.contains(i)) {
                continue;
            }else{
                Set<Integer> temp = new HashSet<>();
                temp.add(i);
                check(temp, i, matrix); // tmp存放  从i出发可连通的站点   i是当前站点编号
                site_set.addAll(temp);
                res++;
            }
        }

        System.out.println(res);
    }

    public static void check(Set<Integer> tmp_set, int n, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // 遍历 n号站点与 其他所有站点的联通性
            if (tmp_set.contains(i)) {
                continue;
            }
            if (n != i && matrix[n][i] == 1) { // 即i号站点  不为n自己  且 能和n联通
                tmp_set.add(i);
                check(tmp_set, i, matrix); // DFS,判断 该站点 又能和其他谁 联通   《==》 能和n联通
            }
        }
    }

}
