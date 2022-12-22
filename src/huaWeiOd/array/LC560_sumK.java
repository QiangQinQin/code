package huaWeiOd.array;

/**
 * @author QiangQin
 * * @date 2022/12/21
 
https://leetcode.cn/problems/subarray-sum-equals-k/?favorite=2cktkvj

给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的 连续子数组 的个数。


示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2

提示：
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107


 思路1：
遍历所有起点
 从起点累加和为K


思路2：
滑动窗口

思路3：

 未通过用例：
[-1,-1,1]
1

[1,-1,0]
0
 预期：
 3
 分别为
 1-1
 1-1+0
 0



[1,2,3]
3
 预期
2
 */
public class LC560_sumK {

//     自己
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
//            int sum=nums[i];
//            if(sum==k){ // 若当前数 后面是0  ；  -1 +1 ,则以i为起点的连续子数组的个数 还要增加
//                count++;
//
//                int j=i+1;
//                while(sum<=k && j<nums.length){ //注意下标边界
//                    sum+=nums[j];
//                    j++;
//
//                    if(sum==k)
//                        count++;
//                }
//            }else if(sum > k){ // 若后面有负数，也可能让  sum==K
//                continue;
//            }else{
//                int j=i+1;
//                while(sum<=k && j<nums.length){ //注意下标边界
//                    sum+=nums[j];
//                    j++;
//
//                    if(sum==k)
//                        count++;
//                }
//            }

            int sum=nums[i];
            if(sum==k) count++;

            for (int j = i+1; j < nums.length; j++) {
                sum+=nums[j];
                if(sum==k)  count++;
            }
        }

        return count;
    }

// 枚举所有数组
    public int subarraySumLC(int[] nums, int k) {
        int count = 0;
        for (int end = 0;end < nums.length; ++end) { // 每个位置作为子数组的结尾
            int sum = 0;
            for (int start = end; start >= 0; --start) { //考虑所有0到end作为子数组的开头   0...start ...end... nums.length
                sum += nums[start];// 一边 遍历，一遍求和
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,0},0));
    }
}
