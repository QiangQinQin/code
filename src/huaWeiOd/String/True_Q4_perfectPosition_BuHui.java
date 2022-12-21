package huaWeiOd.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/21

https://renjie.blog.csdn.net/article/details/128051684
 */
public class True_Q4_perfectPosition_BuHui {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        char[] chs=sc.nextLine().toCharArray();
//        /*
//        自己
//         特殊情况：  原本就频率相等、
//          统计每个字母出现的次数， 看和总长/4差多少，找差值最大的  即为调整的次数？？？ 如AAAA?
//   * */
//        int[] counts = new int[4]; //  0 1 2 3 对应WASD
//        for (char ch : chs) {
//            if(ch=='W')  counts[0]++;
//            if(ch=='A')  counts[1]++;
//            if(ch=='S')  counts[2]++;
//            if(ch=='D')  counts[3]++;
//        }
//
//        int target= chs.length/4;
//        int change=0;
//        int maxDistance=0;
//        for (int count : counts) {
//            maxDistance= Math.abs(count-target)>maxDistance ? Math.abs(count-target):maxDistance;
//        }
//        if(maxDistance == 0){
//            change=0;
//        }else{
//            change=maxDistance;
//        }
//        System.out.println(change);
//
//    }


    /*
    UP主：
    1:先用一个map统计出字符串所有的字符个数，然后先看是否"完美"。
    2:再利用经典的尺取法。 ？？？？？？
       从左往右移动区间，
          当满足条件时，左端点右移，缩小区间，
          当不满足条件时，右端点右移，扩大区间，
        这样可以找到每个满足条件的区间，从而可以找到最小区间。
        记录不包含该区间时WASD 的数量，
          先判断能否通过替换区间内的元素使WASD数量一致，
          再判断剩余位置是否是4的倍数。
    * */
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String input_str = in.nextLine();
            //预设值
            Map<Character,Integer> char_count = new HashMap<Character,Integer>();

            //遍历字符串（统计出现的次数，没出现的记为0）
            for(int i=0; i<input_str.length(); i++) {
                char key = input_str.charAt(i);
                if(char_count.get(key) == null) {
                    char_count.put(key, 1);
                } else{
                    char_count.put(key,char_count.get(key)+1);
                }
            }
            //遍历WASD,防止输入没有这三个字符
            for(int i=0; i<"WASD".length(); i++) {
                char key = "WASD".charAt(i);
                if(char_count.get(key) == null) {
                    char_count.put(key, 0);
                }
            }


            // 特殊情况（出现频率相等）
            if (char_count.get('W') == char_count.get('A')  &&
                    char_count.get('W') == char_count.get('S')  &&
                    char_count.get('W') == char_count.get('D')) {
                System.out.println(0);
                return;
            }

            // 左右区间位置
            int left = 0;
            int right = 0;
            int length = 0;

            // 替换的最小长度
            int res = input_str.length();
            // 出现次数最多的字母
            int max_char_num = 0;
            // 可替换字母个数, 随着指针移动，如果free_char_num 大于0且能被4整除，当前范围满足条件，左指针右移一格，否则右指针右移
            int free_char_num = 0;

            char_count.put(input_str.charAt(0), char_count.get(input_str.charAt(0)) - 1);
            while (true) {
                max_char_num = Math.max(Math.max((Math.max(char_count.get('W'), char_count.get('S'))), char_count.get('A')), char_count.get('D'));
                length = right - left + 1;
                free_char_num = length - ((max_char_num - char_count.get('W')) + (max_char_num - char_count.get('S')) + (max_char_num - char_count.get('A')) + (max_char_num - char_count.get('D')));
                if (free_char_num >= 0 && free_char_num % 4 == 0){
                    if(length<res) {
                        res = length;
                    }
                    char_count.put(input_str.charAt(left), char_count.get(input_str.charAt(left)) + 1);
                    left++;

                } else {
                    right++;
                    char_count.put(input_str.charAt(right), char_count.get(input_str.charAt(right)) - 1);
                }

                if (right >= input_str.length()-1)// 越界即结束
                    break;
            }

            System.out.println(res);
        }
}
