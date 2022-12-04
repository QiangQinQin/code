package Simulation.TrueQ4;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author QiangQin
 * * @date 2022/11/28
https://www.nowcoder.com/discuss/post/421697823329071104

给定一个数组nums,将元素分为若干个组，使得  每组和相等 ，求出满足条件的所有分组中，组内元素  和的最小值
第一行输入 m
接着输入m个数，表示此数组
数据范围:1<=M<=50, 1<=nums[i]<=50
输入
7
4 3 2 3 5 2 1
输出
5
说明:可以等分的情况有 4个子集((5)  (1,4)  (2,3)  (2,3)


=====================================================
网友: 求元素总和， 然后将每个数排序，从最大值开始累加  找  和为（总和的）因数的数   即为 满足条件的

难点:
分几组?  (滑动窗口  2 ,3,4 ??)
和的最小值?(求和,然后除以窗口元素个数)
每组元素个数不一定相等?()
排序,首尾元素加  的组内和最小

青青：
    不用看每组怎么分，是哪几个。  只要  总和%组内和=0，就行 ；
    最大元素一人一组，组合最小值 即为最大元素；
    若不能整除，让最大元素＋一个最小元素试
    1  2  2  3  3  4  5  和为25
 */
public class test01_MinSumGroup {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
//
//        int max=Integer.MIN_VALUE;
//        int sum=0;
//        //统计数字和出现的次数
//        for (int i = 0; i < n; i++) {
//            int num= sc.nextInt();
//            sum+=num;
//            max=num>max?num:max;
//            if(treeMap.containsKey(num)){
//                treeMap.put(num,   treeMap.get(num)+1);
//            }else{
//                treeMap.put(num,1);
//            }
//
//        }

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        int max=Integer.MIN_VALUE;
        int sum=0;
        //统计数字和出现的次数
        for (int i = 0; i < n; i++) {
            int num= sc.nextInt();
            sum+=num;
            max=num>max?num:max;
            if(treeMap.containsKey(num)){
                treeMap.put(num,   treeMap.get(num)+1);
            }else{
                treeMap.put(num,1);
            }

        }

/*
怎么组合  分组
先让最大的数 一个人一组,
  若总和%max==0,再让其他数 凑这个和
  若不能整除,则 让最大的数+一个最小的数,在试
  若不能整除,则 让最大的数+一个最小的数+一个最小的数,在试

* */

//  judgeRes();

        System.out.println(treeMap);
    }
}
