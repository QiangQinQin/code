package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/8
https://www.nowcoder.com/practice/2aa32b378a024755a3f251e75cbf233a?tpId=37&tqId=21252&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

描述
对输入的字符串进行加解密，并输出。

加密方法为：
当内容是英文字母时则用该英文字母的 后一个字母 替换，同时字母变换 大小写 ,如字母a时则替换为B；字母Z时则替换为a；
当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；  ==》 %10
其他字符不做变化。

解密方法为加密的 逆 过程。
数据范围：输入的两个字符串长度满足 1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成
输入描述：
第一行输入一串要加密的密码
第二行输入一串加过密的密码

输出描述：
第一行输出加密后的字符
第二行输出解密后的字符

示例1
输入：
abcdefg
BCDEFGH
输出：
BCDEFGH
abcdefg
 */
public class HJ29_StringSecret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         while(sc.hasNextLine()){
             String str1=sc.nextLine();
             encode(str1);

             String str2=sc.nextLine();
             decode(str2);

         }


    }

    /*
当内容是英文字母时则用该英文字母的 后一个字母 替换，同时字母变换 大小写 ,如字母a时则替换为B；字母Z时则替换为a；
当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；  ==》 (x+1)%10
其他字符不做变化。
    * */
    private static void encode(String str1) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char ch=str1.charAt(i);
            if(ch=='Z'){
               builder.append('a');
            }else if(ch == 'z'){
                builder.append('A');
            }else if(Character.isLowerCase(ch)){
                builder.append( (char)(ch-'a'  + 'A' + 1) );
            }else if(Character.isUpperCase(ch)){
                builder.append((char)(ch+ -'A' + 'a' + 1));
            }else if(Character.isDigit(ch)){
                builder.append( (ch-'0'+1)%10  );
            } else{
                builder.append(ch);
            }
        }
        System.out.println(builder);
    }

/*

当内容是英文字母时则用该英文字母的 前一个字母 替换，同时字母变换 大小写 ,如字母B-->b-->a；字母a--》A-->Z；
当内容是数字时则把该数字减1，如1替换0，2替换1，0替换9；  ==》 （x+1）%10
其他字符不做变化。

* */
    private static void decode(String str1) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char ch=str1.charAt(i);
            if(ch=='a'){
                builder.append('Z');
            }else if(ch == 'A'){
                builder.append('z');
            }else if(Character.isLowerCase(ch)){
                builder.append( (char)(ch-'a'  + 'A' - 1) );
            }else if(Character.isUpperCase(ch)){
                builder.append((char)(ch+ -'A' + 'a' - 1));
            }else if(Character.isDigit(ch)){
                int num=ch-'0';
                if(num==0) {
                    builder.append( 9 );
                }else {
                    builder.append( num-1 );
                }
            } else{
                builder.append(ch);
            }
        }
        System.out.println(builder);
      }

}
