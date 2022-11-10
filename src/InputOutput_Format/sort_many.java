package InputOutput_Format;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */
/*
链接：https://ac.nowcoder.com/acm/contest/5657/I
来源：牛客网

输入描述:
    多个测试用例，每个测试用例一行。
    每行通过空格隔开，有n个字符，n＜100
输出描述:
    对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
示例1
输入
a c bb
f dddd
nowcoder
输出
a bb c
dddd f
nowcoder
* */
public class sort_many {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
//            最后一个字符串后面有没有空格不重要，以“ ”分割就行了
            String[] array=scanner.nextLine().split(" ");
//           排序
            Arrays.sort(array);
            for(int i=0;i<array.length-1;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println(array[array.length-1]); ///避免最后多个 结尾空格
        }
    }
}
