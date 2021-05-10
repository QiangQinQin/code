package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
*
* 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
输出描述:
     输出a+b的结果
输入例子1:
1 5
10 20
输出例子1:
    6
    30

    int 4字节  2^31=2147483648
*/
public class ab_add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner好像会阻塞，输入数据不能有多余空格，也不能一次输入多组数据，但提交测试发现没问题
        while(scanner.hasNextLine()){
            String[] strings =scanner.nextLine().split(" ");
//            int[] num=new int[strings.length];
//            for (int i=0;i<strings.length;i++) {
//                num[i]=Integer.parseInt(strings[i]);
//            }
            int a=Integer.parseInt(strings[0]);
            int b=Integer.parseInt(strings[1]);
            System.out.println(a+b);

        }

////有时用long类型
//        while(sc.hasNext()){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a + b);
//        }

    }
}
