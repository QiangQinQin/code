package huaWeiOd.dynamic;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/5
https://www.nowcoder.com/practice/181a1a71c7574266ad07f9739f791506?tpId=37&tqId=21288&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
查找两个字符串a,b中的最长公共子串。若有多个，输出在 较短串 中 最先 出现的那个。
注： 子串  的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。   请和“子序列”的概念分开！！！

输入描述：
输入两个字符串
输出描述：
返回重复出现的字符

示例1
输入：
abcdefghijklmnop
abcsafjklmnopqrstuvw
输出：
jklmnop
 */
public class HJ65_MaxComSeq {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        /*
//        自己：
//        滑动窗口由大到小，
//        判断长串 是否contains  小串的窗口部分, 超时？
//        * */
//        String str1=sc.nextLine();
//        String str2 = sc.nextLine();
//
//        String less="",more="";
//        if(str1.length() >= str2.length()){
//            less=str2;
//            more=str1;
//        }else{
//            more=str2;
//            less=str1;
//        }
//
//        boolean containFlag=false;
//        String res="";
//        for(int window=less.length();window>=0;window--){
//            if(containFlag==false) {
//                for(int start=0;start+window-1<less.length();start++){
//                    if(more.contains(less.substring(start,start+window))){
//                            containFlag=true;
//                            res=less.substring(start,start+window);
//                            break;
//                    }
//                }
//            }
//        }
//
//        System.out.println(res);
//    }


    /*
1.维护动态数组dp[i][j]表示在  较短字符串str1以第i个字符结尾， 较长字符串str2中以第j个字符结尾时的公共子串长度。
2.从左向右递推，i为短字符串str1的结尾索引，j为str2的结尾索引
3.相等则计数，并不断更新最长公共子串的长度和结尾索引
abcdefghijklmnop
abcsafjklmnopqrstuvw
    * */
//    public static void main(String[]args){
//        Scanner sc=new Scanner(System.in);
//        while(sc.hasNext()){
//            String s1=sc.nextLine();
//            String s2=sc.nextLine();
//            System.out.println(longString(s1,s2));
//        }
//    }
//
//    public static String longString(String str1, String str2) {
//        String temp = "";
//        // 保证str1是较短字符串
//        if (str1.length() > str2.length()) {
//            temp = str1;
//            str1 = str2;
//            str2 = temp;
//        }
//        // 加1，是因为要表示 字符串最后一个字符的匹配情况 [0，..., str1.length()-1,  str1.length()]
//        int m = str1.length() + 1;
//        int n = str2.length() + 1;
//        // 表示在较短字符串str1以第i个字符结尾，str2中以第j个字符结尾时的公共子串长度。
//        int[][] dp = new int[m][n];
//        // 匹配字符，并记录最大值时str1的结尾下标 （通过max，可以反推开始结点，然后截取str1就是结果）
//        int max = 0;
//        int index = 0;
//        // 从左向右递推，i为短字符串str1的结尾索引，j为str2的结尾索引
//        for (int i=1; i < m; i++) {
//            for (int j=1; j < n; j++) {
//                if (str1.charAt(i-1) == str2.charAt(j-1)) {
//                    // 相等则计数
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                    // 不断更新变量
//                    if (dp[i][j] > max) {
//                        max = dp[i][j];
//                        index = i;
//                    }
//                }
//            }
//        }
//        // 截取最大公共子串
//        return str1.substring(index-max, index);
//    }

    /*   双指针

    * */
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            longString(s1,s2);
        }
    }
    public static void longString(String s1,String s2){
        String shortStr = s1.length() < s2.length() ? s1 : s2;
        String longStr = s1.length() > s2.length() ? s1 : s2;

        int shortLen = shortStr.length();
        int longLen = longStr.length();
        int maxLen = 0, start = 0;
        for(int i = 0; i < shortLen;i++) {
            // 剪枝，子串长度已经不可能超过maxLen，退出循环
            if(shortLen - i + 1 <= maxLen) {
                break;
            }
            // 左指针j，右指针k, 右指针逐渐向左逼近
            for(int j = i, k = shortLen; k > j; k--) {
                String subStr = shortStr.substring(i, k);
                if(longStr.contains(subStr) && maxLen < subStr.length()) {
                    maxLen = subStr.length();
                    start = j;
                    // 找到就立即返回
                    break;
                }
            }
        }
        System.out.println(shortStr.substring(start, start + maxLen));
    }
}
