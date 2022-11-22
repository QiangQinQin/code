package huaWeiOd.math;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/20
 *

https://leetcode.cn/problems/count-primes/

给定整数 n ，返回 所有 小于 非负整数的质数的数量 。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7

 */
public class LC204_PrimeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int count=0;
        if(n==0 || n==1){
            count=0;
        }

//      通过20/66    输入5000000，会超时
        for (int num =2 ; num < n ; num++) {
            if(judge(num)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean judge(int num) {
        boolean flag=true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0){
                flag=false;
                break;
            }

        }
        return  flag;
    }
}
