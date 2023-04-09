package huaWeiOd.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author QiangQin
 * * @date 2023/4/9

https://leetcode.cn/problems/longest-substring-of-all-vowels-in-order/
当一个字符串满足如下条件时，我们称它是 美丽的：
    所有 5 个英文元音字母（'a'，'e'，'i'，'o'，'u'）都必须至少出现一次。
    这些元音字母的顺序都必须按照 字典序升序排布（也就是说所有的 'a'都在 'e'前面，所有的 'e'都在 'i'前面，以此类推）

比方说，字符串"aeiou" 和"aaaaaaeiiiioou"都是 美丽的，但是"uaeio"，"aeoiu"和"aaaeeeooo"不是美丽的。

给你一个只包含英文元音字母的字符串word，请你返回word 中 最长美丽子字符串的长度。如果不存在这样的子字符串，请返回 0。

子字符串 是字符串中一个连续的字符序列。

    输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
    输出：13
    解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。

    示例 2：
    输入：word = "aeeeiiiioooauuuaeiou"
    输出：5
    解释：最长子字符串是 "aeiou" ，长度为 5 。

    示例 3：
    输入：word = "a"
    输出：0
    解释：没有美丽子字符串，所以返回 0 。

提示：
    1 <= word.length <= 5 * 10^5
    word 只包含字符 'a'，'e'，'i'，'o' 和 'u' 。
 */
public class LC1839_longestBeautifulSubstring {
/**
如何判断美丽
    至少出现一次 + 字典序
如何拿到最大长度
    思路1： 遍历所有起点，找最长串，记录最大值
    思路2： 滑动窗口，由大到小

 45 / 121 个通过测试用例 ！！！
*/
    public static int myLongestBeautifulSubstring(String word) {
        for (int window = word.length(); window >=5 ; window--) {
            for (int start = 0; start + window <= word.length(); start++) {
                int cur=start+1;
                int count=1;//新起点，新count

                for (   ; cur < start+window; cur++) {
                    if(word.charAt(cur) < word.charAt(cur-1)){
                        break; //即没有完全按照字典序
                    }
                    if(word.charAt(cur)>word.charAt(cur-1)){
                        count++;//字母不同，且升序  则统计出现的字母种类数
                    }
                }

                if(cur==start+window  &&  count==5  )  { // 分析遍历到末尾时，window内字母统计情况
                    return window;
                }
            }
        }

        return 0;
    }

//伸缩窗口
    public static int LC1longestBeautifulSubstring(String word) {
        List<Character> window=new ArrayList<Character>();
        Set<Character> set = new HashSet<Character>();
        int left=0;
        int res = 0;
        int right=0;
        /*
        即 增序则添加，逆序则清空
        * */
        while(right<word.length()) {
            if (window.isEmpty() || word.charAt(right)>=window.get(window.size()-1)) {
                window.add(word.charAt(right));
                set.add(word.charAt(right));
                if (set.size()==5) {
                    res=Math.max(res, window.size());
                }
            }else {
                window.clear();
                set.clear();
                left=right;
                window.add(word.charAt(left));
                set.add(word.charAt(left));
            }
            right++;
        }
        return res;
    }

// max!!!  遍历所有起点，找该位置开始最大的  美丽串
    public int LC2longestBeautifulSubstring(String word) {
        int ans = 0, type = 1, len = 1;

        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) >= word.charAt(i-1)) len++; //更新当前字符串长度
            if(word.charAt(i) > word.charAt(i-1)) type++; //更新当前字符种类
            if(word.charAt(i) < word.charAt(i-1)) { type = 1; len = 1;} //当前字符串不美丽，从当前字符重新开始!!!
            if(type == 5) ans = Math.max(ans, len);  //更新最大字符串（，但并没有主动break循环）
        }
        return ans;
    }

// a e  i  o u   遍历所有起点，找该位置开始最大的  美丽串
    public int LC3longestBeautifulSubstring(String words) {
        int res = 0;
        int len = words.length();
        int p =0;
        char[] word = words.toCharArray();

        while(p<len){
            int i=p;
            if (i<len&&word[i]=='a'){
                while (i<len&&word[i]=='a') i++;
                if (i<len&&word[i]=='e'){
                    while (i<len&&word[i]=='e') i++;
                    if (i<len&&word[i]=='i'){
                        while (i<len&&word[i]=='i') i++;
                        if (i<len&&word[i]=='o'){
                            while (i<len&&word[i]=='o') i++;
                            if (i<len&&word[i]=='u'){
                                while (i<len&&word[i]=='u') i++;
                                res = Math.max(res,i-p);
                            }
                        }
                    }
                }
            }
            p = i;
            while(p<len&&word[p]!='a') p++;


        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myLongestBeautifulSubstring("aeiou"));
        System.out.println(myLongestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
