package InputOutput_Format;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/8
 */

/*
*
输入描述:
    输入有两行，第一行n
    第二行是 n 个空格隔开的字符串
输出描述:
    输出一行排序后的字符串，空格隔开，无 结尾空格

输入
5
c d a bb e
输出
a bb c d e
* */
public class sort_num {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        注意是行
        int n = Integer.parseInt(scanner.nextLine());

        while(scanner.hasNextLine()){
//            最后一个字符串后面有没有空格不重要，以“ ”分割就行了
            String[] array=scanner.nextLine().split(" ");
//           排序
            Arrays.sort(array);
            for(int i=0;i<n;i++){
//                发现多了个结尾空格也没事
                System.out.print(array[i]+" ");
            }
//            System.out.println(array[n-1]);
        }
    }
}
