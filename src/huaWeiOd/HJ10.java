package huaWeiOd;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/2
 */
/*
* 编写一个函数，计算字符串中含有的 不同 字符的 个数。
* 字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
* 不在范围内的不作统计。多个相同的字符只计算一次
*
* 例如，
* 输入一行没有空格的字符串。对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
*
* uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx
*/
public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        char[] array=s.toCharArray();
//        System.out.println(
//                Arrays.toString(array)
//        );
//        key-value形式存字符，及其出现次数
        Map<Character,Integer> map=new HashMap<>();
        for (Character ch:array) {
//            即出现过
            if (map.get(ch) != null ) {
                continue;//不执行下面，直接进行下一次循环
            }
//            char会自动变成ASCII的int值
            if (ch >= 0 && ch <= 127) {
                map.put(ch, 1);
            }
        }
        System.out.println(map.size());
    }
}
