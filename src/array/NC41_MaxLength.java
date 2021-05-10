package array;

import java.util.HashMap;
import java.util.Map;

/*
 * 题目描述
 * 给定一个数组arr，返回arr的最长的无重复子串的长度(无重复指的是所有数字都不相同)。
 * 示例1
 * 输入[2,3,4,5]返回值4
 * 示例2输入[2,2,3,4,3]返回值3
 * 1<n<10^5
 * 
 * 解析：
 * 用一个 数组暂存子串
 * 类似滑动窗口，从左到右遍历，遇到重复的，找到重复的索引，左指针++
*/
public class NC41_MaxLength {

	public static int maxLength (int[] arr) {
		
		int start = 0;
        int end = -1;
        int maxLen = 0;
        Map<Integer,Integer> map  = new HashMap<>();//滑动窗口
        
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])   &&   map.get(arr[i])>=start) {//窗口含有该元素  且  元素下标在窗口起始位置的 右 边
                start = map.get(arr[i]) + 1;//重置 起始 位置
            }
            
            //第一次，map里空，end为-1
            map.put(arr[i],i);//key是值      value存位置
            end++;//塞一个元素，右端窗口后移一位
            
            if (end-start+1>maxLen){//每添加一个元素 ，比较一次窗口长度是否为历来最大
            	maxLen = end-start+1;
            }
        }
        return maxLen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,2,3,4,3};
		System.out.println(maxLength(arr));
	}

}
