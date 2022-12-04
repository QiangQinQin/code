package Simulation.Prac1128;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author QiangQin
 * * @date 2022/11/28
明明的随机数
明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。

数据范围：1≤n≤1000  ，输入的数字大小满足 1≤val≤500
https://www.nowcoder.com/questionTerminal/3245215fffb84b7b81285493eae92ff0
 */
public class testRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }
        for (Integer cur:treeSet   ) {
            System.out.println(cur);
        }

    }
}
