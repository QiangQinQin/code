package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/14
https://www.nowcoder.com/practice/43072d50a6eb44d2a6c816a283b02036?tpId=37&tqId=21294&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

描述
问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
要求：
实现如下2个通配符：
 *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由  英文字母  和  数字0到9  组成，下同）
 ？：匹配1个字符

注意：匹配时 不 区分大小写。

输入：
通配符表达式；
一组字符串。
输出：

返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
数据范围：字符串长度：≤s≤100
进阶：时间复杂度：O(n^2)，空间复杂度：O(n)

输入描述：
先输入一个带有通配符的字符串，再输入一个需要匹配的字符串

输出描述：
返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false

示例1
输入：
te?t*.*
txt12.xls
输出：
false

示例2
输入：
z
zz
输出：
false

示例3
输入：
pq
pppq
输出：
false

示例4
输入：
**Z
0QZz
输出：
true

示例5
输入：
?*Bc*?
abcd
输出：
true

示例6
输入：
h*?*a
h#a
输出：
false
说明：
根据题目描述可知能被*和?匹配的字符仅由英文字母和数字0到9组成，所以?不能匹配#，故输出false

示例7
输入：
p*p*qp**pq*p**p***ppq
pppppppqppqqppqppppqqqppqppqpqqqppqpqpppqpppqpqqqpqqp
输出：
false

 类似力抠44
https://leetcode.cn/problems/wildcard-matching/

 */
public class HJ71_wildcard_buhui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1= sc.nextLine();  // txt12.xls
            String str2=sc.nextLine();  //  te?t*.*
            // 字符串   模式串
            System.out.println(isMatch(str1, str2));

        }


    }


    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
