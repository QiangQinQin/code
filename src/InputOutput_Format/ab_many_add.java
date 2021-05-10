package InputOutput_Format;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
输入描述:
   输入数据有多组, 每行表示一组输入数据。
   每行的第一个整数为整数的个数n(1 <= n <= 100)。
   接下来n个正整数, 即需要求和的每个正整数。

输出描述:
   每组数据输出求和的结果

输入例子1:
4 1 2 3 4
5 1 2 3 4 5

输出例子1:
10
15
* */
public class ab_many_add {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=0,add=0;
        while(scanner.hasNext()){ //注意不能用while(true)  或者 hasNextLine()!!!!!!
//            会报java.util.NoSuchElementException
            num =scanner.nextInt();
           add=0;
           for(int i=0;i<num;i++){
               add+=scanner.nextInt();
           }
            System.out.println(add);
        }
    }
}
