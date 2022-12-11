package huaWeiOd.dynamic;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/7

https://www.nowcoder.com/practice/3959837097c7413a961a135d7104c314?tpId=37&tqId=21275&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。

要求：
给定任意两个字符串，写出一个算法计算它们的编辑距离。

数据范围：给定的字符串长度满足1≤len(str)≤1000

输入描述：
每组用例一共2行，为输入的两个字符串

输出描述：
每组用例输出一行，代表字符串的距离

示例1
输入：
abcdefg
abcdef
复制
输出：
1
 解释
通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。

 */
public class HJ52_editDistance {
    public static void main(String[] args) {
        /*
我们使用dp[i][j]表示字符串A的前i个字符与字符串B的前j个字符相同所需要的编辑距离。
首先需要进行状态的初始化，
当一个字符串为空时，编辑距离等于另一个字符串的长度

对于状态转移方程，需要分两种情况讨论：
第一种情况，a[i]==b[j]，这种情况下，我们不需要进行编辑，dp[i][j]=dp[i-1][j-1]
第二种情况，a[i]!=b[j]，如果两个字符不相等，我们有三种处理方式：
    替换字符串b，编辑距离为dp[i-1][j-1]+1；
    插入一个字符与其相等，则编辑距离为dp[i-1][j]+1；
    删除该字符，编辑距离为dp[i][j-1]+1，三者取其小即可。 具体以下图为例
        * */

        Scanner sc = new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();


            /*
            dp[i][j]表示 str1的前i个字符（0...i-1）  与  str2的前j(0...i-1)个字符相同所需要的编辑距离
            dp[str1.length()][str2.length()]表示 str1的【0, str1.length()）  与   str2的【0, str2.length()）的编辑距离
             */
            int[][] dp = new int[str1.length()+1][str2.length()+1];
            // 即str2为空串时,str1的前i个字符 变为str2, 需要i步
            for(int i=1; i<=str1.length(); i++){  // 初始化
                dp[i][0] = i;
            }
            // 即str1为空串时，
            for(int i=1; i<=str2.length(); i++){  // 初始化
                dp[0][i] = i;
            }

            for (int i = 1; i <= str1.length(); i++) {
                for (int j = 1; j <= str2.length(); j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {  //第一种情况
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {  //第二种情况
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1));  //状态转移方程
                    }
                }
            }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}
