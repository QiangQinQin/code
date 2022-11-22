package huaWeiOd.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/3
 *
https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ5%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ5

写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
输入：
0xAA
输出：
170

 */


public class HJ5_16To10 {
    // 全局变量
    private final static int BASE = 16;
    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
    }};


    public static int getDecimal(String number) {
        int res = 0;

        //转为数组，从左到右 即从高位到低位 处理，  注意 每右移一位，部分和 要 乘base
        for (char ch : number.toCharArray()) {
            res = res * BASE + map.get(ch);
        }

        for (int i = 0; i < number.length(); i++) {
            res+= (map.get(number.charAt(i)) * Math.pow(16,number.length()-i));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String number = in.next();
            int res = getDecimal(number.substring(2)); //[2,length-1]  即去掉 0x
            System.out.println(number);
            System.out.println(res);
        }
    }
}
