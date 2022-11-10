package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */

/*
输入描述:
    输入数据有多组, 每行表示一组输入数据。
    每行不定有n个整数，空格隔开。(1 <= n <= 100)。
输出描述:
    每组数据输出求和的结果
示例1
输入
1 2 3
4 5
0 0 0 0 0
输出
6
9
0
* */
public class ab_many_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        一次读一行
        while(sc.hasNextLine()) {
            String[] num = sc.nextLine().split(" ");
            int sum = 0; // 每一轮要将sum重置一下
            for(int i=0; i<num.length ;i++) {
                sum += Integer.parseInt(num[i]);
            }
            System.out.println(sum);
        }
    }
}
