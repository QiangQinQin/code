package huaWeiOd.array;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author QiangQin
 * * @date 2022/12/24

https://renjie.blog.csdn.net/article/details/128420175
题目描述:
公司老板做了一笔大生意，想要给每位员工分配一些奖金，想通过游戏的方式来决定每个人分多少钱。
按照员工的工号顺序，每个人  随机抽取 一个数字。按照工号的顺序往后排列，
  遇到 第一个  数宇比自己数字大的，那么，前面的员工就可以获得  “距离*数宇差值”  的奖金。
  如果遇不到比自己数字大的，就给自己分配随机数数量的奖金。

例如，按照工号顺序的随机数字是: 2,10,3。
那么第2个员工的数字10比第1个员工的数字2大，所以，第1个员工可以获得1*(10-2)=8。
第2个员工后面没有比他数字更大的员工，所以，他获得他分配的随机数数量的奖金，就是10。
第3个员工是  最后一个员工 ，后面也没有比他更大数字的员工，所以他得到的奖金是3。
请帮老板计算一下每位员工最终分到的奖金都是多少钱

输入描述:
第一行n表示员工数量(包含最后一个老板)
第二是每位员工分配的随机数字

例如
3
2 10 3
输出描述:
最终每位员工分到的奖金数量例如
8 10 3
补充说明:
随机数字不重复，员工数量(包含老板)范围1~10000，随机数范围1~100000

示例1
输入:
3
2 10 3
输出:
8 10 3

 */
public class True_Q4_splitBonus {
    public static void main(String[] args) {
/*
自己： 双重for:
   遍历每个起点 ， 然后逐个 往找后找 第一个比自己大的，
* */
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]= sc.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            boolean hasBig=false;
//            for (int j = i+1; j < n; j++) {
//                if(nums[j]>nums[i]){
//                    hasBig=true;
//                    System.out.print((j-i)*(nums[j]-nums[i])+" "); // 距离*差值
//                    break;// 找到一个就可以
//                }
//            }
//            if(hasBig==false)
//                System.out.print(nums[i]+" ");
//        }


        /*
        UP：单调栈
1:其实翻译一下就是找数组的每一个元素的右边第一个比它大的数字。
2:如果用最简单的双层循环暴力法，最坏情况下 O(n”2)时间复杂度。
3:明显是一个单调栈就可以解决的问题，时间复杂度O(n)  //todo 没理解
      当栈中为空，直接压入，
      栈不为空，比较栈顶元素top和al]。
             若top <aji]，弹出栈顶元素。循环执行，直到遇到第一个top>ali](top即为第一个比其大的元素)或者栈为空（左边没有比a即i]大的元素，
             因此栈中元素从底到上按照从大到小的顺序
        * */
                // 处理输入
                Scanner in = new Scanner(System.in);
                int N = in.nextInt();

                int[] nums = new int[N];
                for(int i=0; i<N; i++){
                    nums[i] = in.nextInt();
                }

                int[] res = findMax(nums);
                for (int i=0;i<N;i++) {
                    if (res[i] == -1) {
                        System.out.print(nums[i]);
                    } else {
                        System.out.print(res[i]);
                    }
                    if (i!=N-1) { // 控制末尾不要加空格
                        System.out.print(" ");
                    }
                }
            }

    public static int[] findMax(int[] array) {
        int len =array.length;
        Stack<Integer> st = new Stack<Integer>();
        int res[]=new int[len];
        int i=0;
        while(i<len) {
            if(st.isEmpty()||array[i]<=array[st.peek()]) {
                st.push(i);
                i++;
            }else {
                res[st.peek()]=(array[i] - array[st.peek()]) * (i-st.peek());
                st.pop();

            }
        }
        while(!st.isEmpty()) {
            res[st.pop()]=-1;
        }
        return res;
    }
}
