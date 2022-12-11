package huaWeiOd.String;

/**
 * @author QiangQin
 * * @date 2022/11/27
https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=196&tqId=37122&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3DNC17%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=NC17
描述
对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。
输入：
"ababc"
返回值：
3
说明：
最长的回文子串为"aba"与"bab"，长度都为3

输入：
"b"
返回值：
1
 */
public class NC17_MaxHuiWen {
    /*
       ********************中心扩散法***************************
       遍历每个结点作为中心点，还需要从中心点向左右扩散比较
     */
//    public int getLongestPalindrome(String A) {
//        return childGetLongestPalindrome(A,A.length());
//    }
//    public int childGetLongestPalindrome(String A, int n) {
//        if(n < 2) {
//            return n;
//        }
//        // 最大长度
//        int res = 0;
//        // 遍历每个结点作为中心点
//        for(int i = 0; i < n; i++) {
//            /* 可能两种情况：
//                类似 aba 的字符串，中心点为1个字符，左右初始边界为 i ,i
//                类似 abba 的情况，中心点为2个字符，左右初始边界为 i,i+1
//              只需要分别计算出以一个和两个字符作为中心点的子串，然后取出较大的长度即可
//             */
//            int len = helper(A, i, i) > helper(A, i, i+1)  ?  helper(A, i, i) : helper(A, i, i + 1);
//            // 更新最大长度
//            res = Math.max(res, len);
//        }
//        return res;
//    }
//
//    public int helper(String A, int left, int right) {
//        // 从left到right开始向两边扩散、比较
//        while(left >= 0 && right < A.length()) {
//            // 如果相等则继续扩散比较
//            if(A.charAt(left) == A.charAt(right)) {
//                left--;
//                right++;
//                continue;
//            }
//            // 如果不相等则剪枝，不用再继续扩散比较
//            break;
//        }
//        // "+1"是因为通过下标计算子串长度
//        // "-2"是因为上边的while循环是当索引为left和right不想等才退出循环的
//        // 因此此时的left和right是不满足的，需要舍弃
//        return right - left + 1 - 2;
//
//    }

/*
* **********************动态规划************************************
输入："abc1234321ab",12
返回值：7
* */
public int getLongestPalindrome(String s) {
    int len = s.length();
    // 特判
    if (len < 2) {
        return s.length();
    }
    int maxLen = 1;
    int begin = 0;
    // 1. 状态定义： dp[i][j] 表示s[i...j] 是否是回文串
    int[][] dp = new int[len][len];
    char[] chars = s.toCharArray();
    /* 3. 状态转移
     填表规则：
        固定j，填每个i，即 先一列一列的填写，再一行一行的填，
        由于dp[i][j] = dp[i + 1][j - 1] ，所以要保证左下方的单元格先进行计算
    */
    for (int j = 1; j < len; j++) { // j 等于1。是因为i小于j
        for (int i = 0; i < j; i++) {
            // 头尾字符不相等，不是回文串
            if (chars[i] != chars[j]) {
                dp[i][j] = 0;
            }  // 相等的情况下
            else {
                // 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
                if (j - i <= 2) {
                    dp[i][j] = 1;
                } else {
                    // 状态转移
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
            // 只要dp[i][j] == 1 成立，表示s[i...j] 是否是回文串

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
        System.out.println(new NC17_MaxHuiWen().getLongestPalindrome("abc1234321ab"));
        // 判断最长
        // 判断回文
    }
}
