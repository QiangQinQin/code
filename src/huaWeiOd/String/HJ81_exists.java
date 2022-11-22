package huaWeiOd.String;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/20
 *
 * https://www.nowcoder.com/practice/22fdeb9610ef426f9505e3ab60164c93?tpId=37&tqId=21304&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=

okekwgktczxeposiirjmquypjbohexyinlktaunjyhkjw
yjynxoawaobtbpyxhbqpzdqjehydzfistxtlzrqzdotglpcunfmpvaparnxkmsybwo

 */
public class HJ81_exists {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String sub=in.nextLine();
            String all=in.nextLine();
            boolean res=true;
            /*
            只说出现，没说连续出现？？？
            contains 不够全面
             字符 ≠ 字母，也不适合用128元素的数组
             */
            HashSet<Character> set = new HashSet<>();
//             for (char ch : pShortString.toCharArray())   另外中写法
            for (int i = 0; i < all.length(); i++) {
                set.add(all.charAt(i));
            }

            for (int i = 0; i < sub.length(); i++) {
                if(!set.contains(sub.charAt(i))){
                    res=false;
                    break;
                }
            }

            System.out.println(res);
        }

    }
}
