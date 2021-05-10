package InputOutput_Format;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/9
 */

/*
对输入的字符串进行排序后输出
https://ac.nowcoder.com/acm/contest/5657#question
输入描述:
    多个测试用例，每个测试用例一行。
    每行通过,隔开，有n个字符，n＜100
输出描述:
    对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
示例1
输入
a,c,bb
f,dddd
nowcoder
输出
a,bb,c
dddd,f
nowcoder
* */
public class sort_many_comma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String[] array=scanner.nextLine().split(",");
//           排序
            Arrays.sort(array);
            for(int i=0;i<array.length-1;i++){
                System.out.print(array[i]+",");
            }
            System.out.println(array[array.length-1]);
        }
    }
}
