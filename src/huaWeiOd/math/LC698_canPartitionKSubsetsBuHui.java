package huaWeiOd.math;

import java.util.Arrays;

/**
 * @author QiangQin
 * * @date 2022/12/20
 *

https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/

698. 划分为k个相等的子集
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。

示例 2:
输入: nums = [1,2,3,4], k = 3
输出: false

提示：
1 <= k <= len(nums) <= 16
0 < nums[i] < 10000
每个元素的频率在 [1,4] 范围内


同样我们用一个整数 S 来表示当前可用的数字集合：从低位到高位，第 i 位为 0 则表示数字 nums[i] 可以使用，否则表示nums[i] 已被使用。
然后我们用dp[S] 来表示在可用的数字状态为 S 的情况下是否可能可行，初始全部状态为记录为不可行状态False，只记 dp[0]=True 为可行状态。

我们每次对于当前状态下从可用的数字中选择一个数字，
若此时选择全部数字取模后小于等于per（即组和）。则说明选择该数字后的状态再继续往下添加数字是可能能满足题意的，并且此时标记状为可能可行状态，
否则就一定不能达到满足。
最终dp[U] 即可，其中 U 表示全部数字使用的集合状态。


 */
public class LC698_canPartitionKSubsetsBuHui {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        //  列举特殊情况，也能通过 150 / 162    ！！！！
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) {
            return false;
        }
        int per = all / k; // 每组和的大小

        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) { // 最大的数  比 组的和大，即有反例，一定不行
            return false;
        }


// todo 理解
        boolean[] dp = new boolean[1 << n];
        int[] curSum = new int[1 << n]; //即2的n次方，用类似 10101111的形式表示 某位数字有没有选中
        dp[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (curSum[i] + nums[j] > per) {
                    break;
                }
                if (((i >> j) & 1) == 0) { // 即看  i位置数  是0还是 1
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        curSum[next] = (curSum[i] + nums[j]) % per;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1},4));
    }
}
