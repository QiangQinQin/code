package huaWeiOd.Interview;

import java.util.Stack;

/**
 * @author QiangQin
 * * @date 2023/1/5
 */


/*
 给定一个只包含两种字符的字符串：（ 和  ）
 写一个函数来检验这个字符串是否为有效字符串。
 有效字符串具有如下规则：
        1.任何左括号 (必须有相应的右括号 )
        2.任何右括号 )必须有相应的左括号 (
        3.左括号 ( 必须在对应的右括号之前 )

        */

//     (())  )(

    /*
    *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串

 *
    ""
    )
   （

    dp[][]
    *
    * */
public class True_LC678_checkValidString {
    public static boolean checkValidString(String s) {
        boolean res = true;

        if (s.length() == 0) {
            return true;
        } else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        if (stack.pop() == '(') {
                            continue;
                        } else {
                            res = false;
                            break;
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                res = false;
            }
        }

        return res;
    }


    /*
  LC678:  https://leetcode.cn/problems/valid-parenthesis-string/

    给定一个只包含三种字符的字符串：（，）和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
        任何左括号 (必须有相应的右括号 )。
        任何右括号 )必须有相应的左括号 (。
        左括号 ( 必须在对应的右括号之前 )。
        *可以被视为单个右括号 )，或单个左括号 (，或一个空字符串。
        一个空字符串也被视为有效字符串。
    示例 1:
    输入: "()"
    输出: True

    示例 2:
    输入: "(*)"
    输出: True

    示例 3:
    输入: "(*))"
    输出: True


要判断s是否为有效的括号字符串，需要  判断s的首尾字符  以及  s的中间字符是否符合有效的括号字符串的要求。可以使用动态规划求解。

假设字符串 s 的长度为 n。
定义dp[i][j]表示字符串 s 从下标 i 到 j 的子串是否为有效的括号字符串，其中0≤i≤j<n。

动态规划的边界情况是子串的长度为 1 或 2 的情况。
    当子串的长度为 1 时，只有当该字符是 ‘*’ 时，才是有效的括号字符串，此时子串可以看成空字符串；
    当子串的长度为 2 时，只有当两个字符是 “()",  “**" 中的一种情况时，才是有效的括号字符串，此时子串可以看成 “()"。
    当子串的长度大于 2 时，需要根据子串的首尾字符以及中间的字符判断子串是否为有效的括号字符串。
        字符串 s 从下标 i 到 j 的子串的长度大于 2 等价于j−i≥2，
        此时 dp[i][j] 的计算如下，只要满足以下一个条件就有 dp[i][j]=true：
            如果 s[i] 和 s[j] 分别为左括号和右括号 ，或者  为‘*’， 则当  dp[i+1][j−1]=true 时，dp[i][j]=true。    注：     i ,i+1 ,,,, j-1,j      为‘*’(此时 s[i] 和 s[j] 可以分别看成左括号和右括号)
            如果存在 i≤k<j 使得 dp[i][k] 和 dp[k+1][j] 都为true，则dp[i][j]=true。  因为字符串 s 的下标范围 [i, k] 和 [k+1,j] 的子串分别为有效的括号字符串，将两个子串拼接之后的子串也为有效的括号字符串，对应下标范围 [i, j]。

上述计算过程为从较短的子串的结果得到较长的子串的结果，因此需要注意动态规划的计算顺序。最终答案为dp[0][n−1]。

    * */


    public boolean checkValidStringHard(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // [i,i]处理单个字符
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                dp[i][i] = true;
            }
        }

        // 处理字符串长度为 2 的情况
        for (int i = 1; i < n; i++) {
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            dp[i - 1][i] = (c1 == '(' || c1 == '*')    &&   (c2 == ')' || c2 == '*');
        }

        // 长度大于2    [n-3 ，n-2, n-1, n)
        for (int i = n - 3; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < n; j++) { // i    i+1    i+2(j的起点)    i+3    i+4 ,,,   n
                char c2 = s.charAt(j);
                // 即 两边可配对，就可以缩减范围
                if (   (c1 == '(' || c1 == '*')    &&   (c2 == ')' || c2 == '*')   ) {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                // 否则 寻找可行的分割点k
                for (int k = i;    k < j && !dp[i][j];    k++) {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }

        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        System.out.println(checkValidString("(())"));
        System.out.println(checkValidString(")("));
        System.out.println(checkValidString("())"));
        System.out.println(checkValidString("))"));
        System.out.println(checkValidString("(()"));
    }

}

