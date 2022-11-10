package huaWeiOd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/3
 */
public class HJ5 {
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
