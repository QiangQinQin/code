package Simulation.Prac1128;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/28
 *
进制转换
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
数据范围：保证结果在 1≤n≤2的31次方−1
https://www.nowcoder.com/questionTerminal/8f3df50d2b9043208c5eed283d1d4da6
 */
public class test16TO10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex=sc.nextLine();
        System.out.println(Integer.parseInt(hex.substring(2),16));
    }
}
