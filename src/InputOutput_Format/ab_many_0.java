package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
输入描述:
   输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
输出描述:
   输出a+b的结果

输入例子1:
1 5
10 20
0 0

输出例子1:
6
30
* */
public class ab_many_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;
       while(true){
           a=scanner.nextInt();
           b=scanner.nextInt();
           if(a==0 && b==0){
               break;
           }else {
               System.out.println(a+b);
           }
        }

    }
}
