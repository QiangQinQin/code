package huaWeiOd.dynamic;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/7
 *
 https://www.nowcoder.com/practice/3cd4621963e8454594f00199f4536bb1?tpId=37&tqId=21255&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=


输入描述：
输入一个字符串（字符串的长度不超过2500）

输出描述：
返回有效密码串的最大长度

示例1
输入：
ABBA
输出：
4
示例2
输入：
ABBBA
输出：
5

本质为 最长会文子串  NC17_MaxHuiWen

 */
public class HJ32_SubPassWord {

        /*
       ********************中心扩散法***************************
       遍历每个结点作为中心点，还需要从中心点向左右扩散比较
     */
    public static int getLongestPalindrome(String A) {
        return childGetLongestPalindrome(A,A.length());
    }
    public static  int childGetLongestPalindrome(String A, int n) {
        if(n < 2) {
            return n;
        }
        // 最大长度
        int res = 0;
        // 遍历每个结点作为中心点
        for(int i = 0; i < n; i++) {
            /* 可能两种情况：
                类似 aba 的字符串，中心点为1个字符，左右初始边界为 i ,i
                类似 abba 的情况，中心点为2个字符，左右初始边界为 i,i+1
              只需要分别计算出以一个和两个字符作为中心点的子串，然后取出较大的长度即可
             */
            int len = helper(A, i, i) > helper(A, i, i+1)  ?  helper(A, i, i) : helper(A, i, i + 1);
            // 更新最大长度
            res = Math.max(res, len);
        }
        return res;
    }

    public  static int helper(String A, int left, int right) {
        // 从left到right开始向两边扩散、比较
        while(left >= 0 && right < A.length()) {
            // 如果相等则继续扩散比较
            if(A.charAt(left) == A.charAt(right)) {
                left--;
                right++;
                continue;
            }
            // 如果不相等则剪枝，不用再继续扩散比较
            break;
        }
        // "+1"是因为通过下标计算子串长度
        // "-2"是因为上边的while循环是当索引为left和right不想等才退出循环的
        // 因此此时的left和right是不满足的，需要舍弃
        return right - left + 1 - 2;

    }

    /*
   2. 动态规划
    * */
    public static int getLongestPalindromeDP(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s.length();
        }

        //  只有一个字符肯定是 回文
        int maxLen = 1;
        int begin = 0;
        // 1. 状态定义： dp[i][j] 表示s[i...j] 是否是回文串
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();
    /* 3. 状态转移
     填表规则：
        固定j，填每个i，即 一列一列的 从左往右填写，
        由于dp[i][j] = dp[i + 1][j - 1] ，所以要保证左下方的单元格先进行计算
    */
        for (int j = 1; j < len; j++) { // j 等于1。是因为i小于j
            for (int i = 0; i < j; i++) {
                // 头尾字符不相等，不是回文串
                if (chars[i] != chars[j]) {
                    dp[i][j] = 0;
                } else { // 相等的情况下
                    // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                    if (j - i <= 2) {
                        dp[i][j] = 1; // 成立，表示s[i...j] 是否是回文串
                    } else {
                        // 状态转移（向内搜索  【i，j】是不是回文  取决于 【i-1，j-1】是不是回文）
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 如果更大的回文串，则更新此 其长度和起始位置
                if (dp[i][j] == 1 && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 4. 返回值
        return s.substring(begin, begin + maxLen).length();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(getLongestPalindrome(str));
        System.out.println(getLongestPalindromeDP(str));
    }
}
