package huaWeiOd.math;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/19

https://renjie.blog.csdn.net/article/details/128025806
小明在学习二进制时，发现了一类不含101的数，也就是:将数字用二进制表示， 不  能出现101。
现在给定一个整数区间[I,r]，请问这个区间包含了多少个不含101的数?
输入描述
输入的唯一—行包含两个正整数l, r ( 1≤l≤r≤10"9)。
输出描述
输出的唯一一行包含一个整数，表示在[I,r]区间内一共有几个不含101的数。

样例
样例一:
输入1 10
输出8
样例解释
区间[1,10]内，5的二进制表示为101，10的二进制表示为1010，因此区间[1,10]内有10-2=8个不含101的数。

样例二:
输入10 20输出7
样例解释
区间[10,20]内，满足条件的数字有[12,14,15,16,17,18,19]因此答案为7。
 */
public class True_Q4_No101 {
    public static void main(String[] args) {

        /*
      自己思路：
        遍历每个数；
        先将每个数转为二进制
        再转为String
        用contains判断是否包含"101"
        * */

        Scanner sc = new Scanner(System.in);
        int l=sc.nextInt();
        int r=sc.nextInt();

        int count=0;
        for (int i = l; i <= r; i++) {
            String bin=Integer.toBinaryString(i);
            if(!bin.contains("101")){
                count++;
            }
        }
        System.out.println(count);
    }
}
