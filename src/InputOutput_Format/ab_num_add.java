package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
*
输入描述:
   输入第一行包括一个数据 组数t(1 <= t <= 100)
   接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)

输出描述:
   输出a+b的结果

输入例子1:
2
1 5
10 20
*/
public class ab_num_add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=scanner.nextInt();
        for(int i=0;i<num;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            System.out.println(a+b);
        }
    }
}
