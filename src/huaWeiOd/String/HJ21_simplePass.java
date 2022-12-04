package huaWeiOd.String;

import java.util.Scanner;

/**
 https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&tqId=21244&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ21%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ21
 现在有一种密码变换算法。
 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，
 把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.

 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 数字和其它的符号都不做变换。

 数据范围： 输入的字符串长度满足 1≤n≤100

 输入描述：
 输入一组密码，长度不超过100个字符。

 输出描述：
 输出密码变换后的字符串

 示例1
 输入：
 YUANzhi1987
 复制
 输出：
 zvbo9441987

 */
public class HJ21_simplePass {
    public static void main(String[] args) {
//        System.out.println(Integer.valueOf('a'));
//        Scanner scanner = new Scanner(System.in);
//        String input=scanner.next();
//
//        char[] arr=input.toCharArray();
//
//        for (char ch:arr ) {
//            if(Character.isUpperCase(ch)){
//                ch= (char) (ch-'a' + '0');
//
//            }
////                ch-3';
//        }

        Scanner in=new Scanner(System.in);

        while(in.hasNext()){
            String str=in.nextLine();  // zhi ==>944
            char c[]=str.toCharArray();

            for(int i=0;i<str.length();i++){
                /*
                a  97
                A  65
                大写转小写，加32就行
                */

                // 大写
                if(c[i]>='A'&&c[i]<='Z'){
                    if(c[i]+32 != 'z') // 先转小写,然后向后移一位
                        c[i]+=32+1;
                    else
                        c[i]='a';
                }

                // 若为小写，则映射为  数字键盘上的数字（）
                else if(c[i]>='a'&&c[i]<='r')//  abc--2, def--3, ghi--4, jkl--5, mno--6, pqr  s--7
                    c[i]=(char) ( (c[i]-'a')/3+2  +'0');  // 先得到对应数字，然后变成对应数字的  ASCII
                else if(c[i]=='s')
                    c[i]='7';
                else if(c[i]>='t'&&c[i]<='v')
                    c[i]='8';
                else if(c[i]>='w'&&c[i]<='z')
                    c[i]='9';

                // 其他的(如数字)  不做变换

                //处理一个  输出一个
                System.out.print(c[i]);
            }

            System.out.println();
        }

    }
}
