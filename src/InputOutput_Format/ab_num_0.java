package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
输入描述:
   输入数据包括多组。
   每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
   接下来n个正整数,即需要求和的每个正整数。

输出描述:
   每组数据输出求和的结果

输入例子1:
4 1 2 3 4
5 1 2 3 4 5
0

输出例子1:
10
15
* */
public class ab_num_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first,//即整数个数
                add=0;
        while(true){
            first=scanner.nextInt();
            if(first==0){
                break;
            }else {
                add=0;
                for(int i=0;i<first;i++){
                    add+=scanner.nextInt();
                }
                System.out.println(add);
            }
        }
    }
}
