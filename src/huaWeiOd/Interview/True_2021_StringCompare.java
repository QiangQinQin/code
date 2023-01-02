package huaWeiOd.Interview;

/**
 * @author QiangQin
 * * @date 2023/1/2

https://blog.csdn.net/weixin_36313227/article/details/115992419
字符串比较
题目描述:
给定字符串A，B和正整数V，A的长度与B的长度相等，请计算A满足如下条件的最大连续子串的长度:
1、该连续子串在A和B中的位置和长长度均相同。
2、该连续子串|A[i]-B[i]| 之 和 小于等于V，其中|A]-B利表示两个字母ASCII码之差的绝对值。

输入描述:
输入为三行:
第一行为字符串A，仅包含小写字符，。
第二行为字符串B，仅包含小写字符。
第三行为正整数V。
输出描述:
字符串最大连续子串的长长度，要求该子串|A[i]-B[间]之和小于等于V。
输入∶
xxcdefg
cdefghi
5
输出:
2
 */
public class True_2021_StringCompare {
    public static void main(String[] args) {
        String str1="xxcdefg";
        String str2="cdefghi";
        int tar=5;

        int maxLen=1;
        boolean isFind=false;
        for (int window = str1.length(); window >=1 ; window--) {
            for (int i = 0; i+window <=str1.length() ; i++) {
                if(isFind == false){
                    int compare=0;
                    for (int j = i; j < i+window; j++) {
                        compare +=Math.abs(str1.charAt(j)-str2.charAt(j));
                        if(compare > tar){
                            break;
                        }
                    }
                    if(compare <= tar){
                        isFind =true;
                        maxLen =window;
                        break;
                    }
                }
            }
        }
        System.out.println(maxLen);
    }
}
