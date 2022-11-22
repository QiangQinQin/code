package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/2
https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37&tqId=21329&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ106%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ106
将一个字符串str的内容颠倒过来，并输出。

输入：
I am a student

输出：
tneduts a ma I
 */
public class HJ106_reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();

        StringBuilder builder = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            builder.append(str.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
