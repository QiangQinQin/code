package huaWeiOd.math;

import java.util.Arrays;
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
/*   官方：枚举会超时   https://leetcode.cn/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/ */
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


/*   官方2： 埃式筛   */
    public int countPrimesNice(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) { //i的所有倍数，从x*x开始
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(new LC204_PrimeCount().countPrimesNice(10));
        /* =============== 自己================= */
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
        for (int i = 2; i * i <= num; i++) {  //  i <= Math.sqrt(num)  不如  i * i <= num 效率高  ，而且要写=，不然输入10.预期4 （为2，3，5，7），实际输出6（2 3 4 5 7 9，多了4和9）
            if(num%i==0){
                flag=false;
                break;
            }

        }
        return  flag;
    }
}
