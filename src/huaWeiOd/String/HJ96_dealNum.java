package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/20
 *
https://www.nowcoder.com/practice/637062df51674de8ba464e792d1a0ac6?tpId=37&tqId=21319&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
将一个字符串中所有的 整数 前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
输入：
Jkdi234klowe90a3
输出：
Jkdi*234*klowe*90*a*3*

1**3   ==》 *1****3*
 */
public class HJ96_dealNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        StringBuilder builder = new StringBuilder();

        int count=0;//连续的数字个数
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!Character.isDigit(ch)){
//            if(Character.isLetter(ch)){  //no！！  非数字的都保持原样
                if( count!=0){ //处理 连续数字的 结尾
                    builder.append("*");
                }
                builder.append(ch);

                count=0;
            }


            if(Character.isDigit(ch)){
                if( count==0){// 处理数字开头
                    builder.append("*");
                }
                count++;
                builder.append(ch);

                //处理末尾是数字的
                if(i==str.length()-1 ){
                    builder.append("*");
                }

            }
        }
        System.out.println(builder);
    }
}
