package SwordOffer;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author QiangQin
 * * @date 2021/7/11
 */
class Solution {
    public int findRepeatNumber(int[] nums) {
//      力扣似乎没考虑 栈为空  有 多个重复数字
        HashMap<Integer, Integer> map = new HashMap<>();
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
               result= map.get(nums[i]);
                break;
            }
            else{
                map.put(nums[i],nums[i]);
            }
        }
        return result;
    }
}
public class Offer_04_Repeat {
}
