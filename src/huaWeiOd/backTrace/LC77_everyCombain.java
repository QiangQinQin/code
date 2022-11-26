package huaWeiOd.backTrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2022/11/26

https://leetcode.cn/problems/combinations/
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。
示例 1：
输入：n = 4, k = 2
输出：
[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]
示例 2：
输入：n = 1, k = 1
输出：[[1]]

提示：
1 <= n <= 20
1 <= k <= n

 画一个搜索树：https://leetcode.cn/problems/combinations/solution/77-zu-he-tu-jie-dai-ma-jian-ji-by-chen-w-q48j/

 */
public class LC77_everyCombain {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();// 存放路径上的结点

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);// 即重【1，n]找出所有k个数的组合
        return result;
    }

    private void combineHelper(int n, int k, int startIndex){
        //先定义出口 (0...k-1 共k个)
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){ // 减枝，比如 4个数中找2个数，下标至少为【0，1，2，3】中的2，否则个数不够
            path.add(i);// 添加到末尾
            combineHelper(n, k, i + 1); //搜索起点要加 1，因为组合数理不允许出现重复的元素
            path.removeLast();//深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC77_everyCombain().combine(4,2));
    }
}
