package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
输入描述:
  输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
  接下来t行, 每行一组数据。
  每行的第一个整数为整数的个数n(1 <= n <= 100)。
  接下来n个正整数, 即需要求和的每个正整数。

输出描述:
  每组数据输出求和的结果

输入例子1:
2
4 1 2 3 4
5 1 2 3 4 5

输出例子1:
10
15
* */
public class ab_num_sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();//组数

        int add=0;
        for(int i=0;i<num;i++){
            int first=scanner.nextInt(); //每行第一个数为需要求和的整数个数
            add=0;//把上一轮算的累加和清空
            for(int j=0;j<first;j++){
                add+=scanner.nextInt();
            }
            System.out.println(add);
        }
    }
}
