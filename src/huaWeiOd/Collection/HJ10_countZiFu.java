package huaWeiOd.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/2
 */
/*
https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ10%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ10
* 编写一个函数，计算字符串中含有的 不同 字符的 个数。
* 字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。
* 不在范围内的不作统计。多个相同的字符只计算一次
*
* 例如，
* 输入一行没有空格的字符串。对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
*
* uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx
*/
public class HJ10_countZiFu {
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
