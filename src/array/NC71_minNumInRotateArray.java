package array;
/*
* 题目描述
      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
      输入一个  非递减排序  的数组的一个  旋转，输出旋转数组的  最小元素。
NOTE：给出的所有 元素 都大于0，若 数组大小 为0，请返回0。

[3,4,5,1,2]   1

先分析好 基本情况  和  特殊情况
再优化时间和空间复杂度
*/

import java.util.Vector;

public class NC71_minNumInRotateArray {
    public static int minNumbInRotateArray(int [] nums) {

        //数组长度为0
        if(nums.length==0){
            return 0;
        }
        int lo = 0, hi = nums.length-1;

        //右侧右端点  可能和  左侧左端点 值相同
        //保证左半部分一定大于右半部分，先去除掉特殊情况
        //  2 2 3 4 1 2
        while(lo < hi && nums[lo] == nums[hi]){
            lo ++;
        }
        // 所有元素都相等   1  1  1 1  1
        if(lo == hi){
            return nums[0];
        }
        // 坑点   2  2  2  0  1 2 (循环完后，lo...hi是递增区间)
        if(nums[lo] < nums[hi]){
            return nums[lo];
        }

        //上面已去掉下面的二分策略lo会越界的情况   3  4  5  1  2
        int left_min = nums[lo];
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= left_min){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return nums[lo];

    }
    public static void main(String[] args) {
        int[] array={3,4,5,1,2};
        System.out.println(minNumbInRotateArray(array));

    }
}
