package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/2
 */
//public class HJ85 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//
//        String ans = "";
//        int max = 0;
//
//        int len = s.length();
//        //列举所有起点的  所有长度的子串
//        for (int i = 0; i < len; i++)
//            for (int j = i + 1; j <= len; j++) {//子串长度至少为2
//                String test = s.substring(i, j);
//                //更新最优值
//                if (isPalindromic(test) && test.length() > max) {
//                    ans = s.substring(i, j);
//                    max = Math.max(max, ans.length());
//                }
//            }
//
//        System.out.println(ans.length());
//    }
//
//    private static boolean isPalindromic(String s) {
//        int len = s.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (s.charAt(i) != s.charAt( len-1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

public class HJ85 {

    //把回文串两端向两侧扩展
    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;//因为跳出while时，相当于是 多扩大了一次的边界
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        //记录最长的相关信息
        int max= 0;
        //尝试  所有回文中心
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //奇数串的中心（即初始串的长度为1）
            int len2 = expandAroundCenter(s, i, i + 1);//偶数串的中心（即初始串的长度为2） 有可能i+1越界，函数里用right < s.length() 判断

            //更新最优值
            int len = Math.max(len1, len2);
            if(len>max){
                max=len;
            }
        }

        System.out.println(max);
    }

}


