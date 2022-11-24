package huaWeiOd.stack;

/**
 * @author QiangQin
 * * @date 2022/11/23
https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/

如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：

字符串是一个  空字符串 ""，或者是一个不为 "(" 或 ")" 的  单字符。
字符串可以写为 AB（A 与 B字符串连接），其中 A 和 B 都是 有效括号字符串 。
字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。


类似地，可以定义任何有效括号字符串S 的 嵌套深度 depth(S)：
depth("") = 0
depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串

例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。

示例 1：

输入：s = "(1+(2*3)+((8)/4))+1"
输出：3
解释：数字 8 在嵌套的 3 层括号中。

示例 2：
输入：s = "(1)+((2))+(((3)))"
输出：3


对于括号计算类题目，我们往往可以用栈来思考。

遍历字符串 ss，如果遇到了一个左括号，那么就将其入栈；
如果遇到了一个右括号，那么就弹出栈顶的左括号，与该右括号匹配。
这一过程中的栈的大小的最大值，即为 ss 的嵌套深度。

代码实现时，由于我们只需要考虑栈的大小，我们可以用一个变量size 表示栈的大小，当遇到左括号时就将其加一，遇到右括号时就将其减一，从而表示栈中元素的变化。
这一过程中 size 的最大值即为 ss 的嵌套深度。

 */
public class LC1614_MaxKuoHao {
//    public static int maxDepth(String s) {
//        int depth=0;
//
//        if(s.equals("")  || (s.length()==1 && s!="(" && s!=")") ){
//            return 0;
//        }else if()
//        if{
//            return 0;
//        }
//
//    }

    public static int maxDepth(String s) {
        int ans = 0, size = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++size;
                ans = Math.max(ans, size);
            } else if (ch == ')') {
                --size;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
