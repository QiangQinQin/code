package huaWeiOd.DF;

import java.util.Scanner;


/**
 * @author QiangQin
 * * @date 2022/12/18
https://leetcode.cn/problems/wildcard-matching/

给定一个   字符串(s)    和  一个字符模式(p)  ，实现一个支持'?'和'*'的通配符匹配。
   '?' 可以匹配任何单个字符。
   '*' 可以匹配 任意 字符串（包括空字符串）。
   两个字符串完全匹配才算匹配成功。

说明:
  s可能为空，且只包含从a-z的小写字母。
  p可能为空，且只包含从a-z的小写字母，以及字符?和*。

示例1:
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例2:
输入:
s = "aa"
p = "*"
输出: true
解释:'*' 可以匹配任意字符串。


 abcd
 ab*
 true

 acdcb
 a*c?b
 false


 */
public class LC44_wildcard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s=sc.nextLine(); // 待匹配串
            String p=sc.nextLine(); // 模式串

            System.out.println(isMatch(s,p));
        }
    }

    /*
    捋清问题，代码也就好写了
    * */

    private  static  boolean isMatch(String s,String p){
        boolean res=true;
        int sLength=s.length();
        int pLength=p.length();

        // 先列举特殊情况，拿到基本分
        if(sLength==0 && pLength==0){  // 即当字符串 ss 和模式 pp 均为空
            res=true;
        }else if(sLength!=0 && pLength==0){ //即 空模式  无法匹配  非空字符串；
            res=false;
        }else if(sLength==0 && pLength!=0){ // 只有 当模式 p 的前 j 个字符均为星号时，才能匹配空字符串
            for (int i = 0; i < pLength; i++) {
               if(p.charAt(i) != '*'){
                  res=false;
                  break;
               }
            }
        }

        else{
            /*
             dp[i][j] 代表   s的前 i个字符(从[0,i-1]共i个）   和  模式 p 的前j个字符  的匹配结果 ;
             dp方块中 行数为s的字符个数+1 ； 列数为模式p的字符个数+1
             值默认全false
            * */

            boolean[][] dp=new boolean[sLength+1][pLength+1];

            dp[0][0]=true; //代表s即 当字符串 ss 和模式 pp 均为空时，匹配成功；

//            for (int i = 1; i <= sLength; i++) { // 即 空模式 无法匹配  非空字符串；
//                dp[i][0]=false;  // 默认为false，可以不用赋值
//            }

            for (int i = 1; i <= pLength; i++) {  // 只有当模式 p 的前 j 个字符均为星号时，dp[0][j] 才为真。   从1开始！！！
                if(p.charAt(i-1)=='*'){ // p的i-1下标  其实是 第i个字符，所以队列dp[][i]
                    dp[0][i]=true;
                }else{
                    break;
                }
            }

            // 保证i-1、j-1不会越界
            for (int i = 1; i <= sLength; i++) {
                for (int j = 1; j <= pLength; j++) {
                    if(s.charAt(i-1) == p.charAt(j-1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if(p.charAt(j-1)=='?'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else if(p.charAt(j-1)=='*'){  //不能直接写else  ,但输入为 cb   ?a时会出错
                        dp[i][j]=dp[i-1][j] || dp[i][j-1];
                    }
                }
            }

            res =dp[sLength][pLength];
        }
        return res;
    }

    /*
    官方
    * */
//    public boolean isMatch(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        dp[0][0] = true;
//        for (int i = 1; i <= n; ++i) {
//            if (p.charAt(i - 1) == '*') {
//                dp[0][i] = true;
//            } else {
//                break;
//            }
//        }
//        for (int i = 1; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (p.charAt(j - 1) == '*') {
//                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                }
//            }
//        }
//        return dp[m][n];
//    }

}
