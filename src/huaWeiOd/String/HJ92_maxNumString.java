package huaWeiOd.String;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/11
https://www.nowcoder.com/practice/2c81f88ecd5a4cc395b5308a99afbbec?tpId=37&tqId=21315&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=3&tags=&title=


描述
输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
本题含有多组样例输入。

数据范围：字符串长度 1≤n≤200  ， 保证每组输入都至少含有一个数字

输入描述：
输入一个字符串。1<=len(字符串)<=200

输出描述：
输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。

示例1
输入：
abcd12345ed125ss123058789
a8a72a6a5yy98y65ee1r2
输出：
123058789,9
729865,2
说明：
样例一最长的数字子串为123058789，长度为9
样例二最长的数字子串有72,98,65，长度都为2

 */
public class HJ92_maxNumString {
    public static void main(String[] args) {
        /*
方式1：split
    把非数字的全部替换成空格，然后切割；
    遍历一次得到最大长度；
    再遍历一次，把符合上述最大长度的字符串取出作追加拼接。
        * */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
           String in= sc.nextLine();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < in.length(); i++) {
                char c=in.charAt(i);
                if(Character.isDigit(in.charAt(i))){
                    builder.append(c);
                }else{
                    builder.append(" ");
                }
            }

            String[] nums = builder.toString().split(" ");
            int max=0;
            for (int i = 0; i < nums.length; i++) {
                max=  nums[i].length()>max  ?  nums[i].length() : max;
            }

           StringBuilder builder2=new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                if(nums[i].length() == max)  builder2.append(nums[i]);
            }
            System.out.println(builder2+","+max);
        }

        /*
        * 动态规划
        *    a8a72a6a5yy98y65ee1r2
        * dp [0, 0, 1, 0, 1, 2, 0, 1, 0, 1, 0, 0, 1, 2, 0, 1, 2, 0, 0, 1, 0, 1]
        * */
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String str = sc.nextLine();
//            int len = str.length();
//
//            //  dp[i] 表示str[0,,,,i-1]的最长连续数字
//            int[] dp = new int[len+1];
//            int res = 0; //存 最大连续长度
//            for (int i =1; i <= len; i++) {
//                char tmp = str.charAt(i-1);
//                // 当前字符是数字
//                if (tmp >= '0' && tmp <= '9') {
//                    dp[i] = dp[i-1] +1;
//                    res = Math.max(res, dp[i]);
//                }
//            }
//
//            // 遍历所有下标
//            for (int i =1; i<= len; i++) {
//                if (dp[i] == res) {
//                    System.out.print(str.substring(i - res, i)); // [i - res,  i-1]
//                }
//            }
//            System.out.println("," + res);
//        }




            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String pInStr = in.nextLine();

                List<String> pOutputstr = new LinkedList<>();
                int res = continumax(pOutputstr, pInStr);

                for (String str : pOutputstr) {
                    System.out.print(str);
                }
                System.out.println("," + res);
            }

    }

/*

abcd12345ed125ss123058789

 */
    public static int continumax(List<String> pOutputstr,  String intputstr) {
        int max = 0 ;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < intputstr.length(); i++) {
            // 找到所有数字串，放于pOutputstr  并 得到数字串最大长度
            if (intputstr.charAt(i) >= '0' && intputstr.charAt(i) <= '9') {
                while (i < intputstr.length() && intputstr.charAt(i) >= '0' && intputstr.charAt(i) <= '9') {
                    s.append(intputstr.charAt(i++));
                }
                max = Math.max(max, s.length());
                pOutputstr.add(s.toString());
                s.setLength(0);// 等价于清空 builder内容
            }
        }

        // 移除短的数字串
        for (int i = 0; i < pOutputstr.size(); i++) {
            if (pOutputstr.get(i).length() < max) {
                pOutputstr.remove(i);
                i--;
            }
        }
        return max;
    }



}
