package huaWeiOd.String;

/**
 * @author QiangQin
 * * @date 2022/11/20
 *
https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 */
public class LC674_maxSeq {

    public static void main(String[] args) {
        int[] chs=new int[]{1,3,5,4,7};

        int count=1,res=1;
        for (int i = 1; i < chs.length; i++) {
            if(chs[i]>chs[i-1]){
                count++;
            }else{
                count=1;
            }
            res=Math.max(count,res);
        }
    }
}
