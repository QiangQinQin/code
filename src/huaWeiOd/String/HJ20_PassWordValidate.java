package huaWeiOd.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/21
 * https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ20%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ20
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * <p>
 * 如果符合要求输出：OK，否则输出NG
 * <p>
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * <p>
 * 输出：
 * OK
 * NG (因为Abc)
 * NG (因为只含有数字和大写)
 * OK
 */
public class HJ20_PassWordValidate {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            //条件1:长度超过8位
            if (s.length() <= 8) {
                System.out.println("NG");
                continue; // 即 不执行 本次循环 接下来内容
            }

            //条件2.包括大小写字母.数字.其它符号,以上四种至少三种
            int count[] = new int[4];//记录出现 类别个数
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    count[0] = 1;
                } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    count[1] = 1;
                } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count[2] = 1;
                } else {
                    count[3] = 1;
                }
            }
            if (count[0] + count[1] + count[2] + count[3] < 3) {
                System.out.println("NG");
                continue;
            }


            //3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）   即 有>=3的重复子串 就NG，如021Abcd9Abcd1中的Abc
            if (judgeRepeat(s)) {
                System.out.println("NG");
                continue;
            } else {
                System.out.println("OK");
            }
        }
    }

    //检测是否存在长度大于3的重复子串
    private static boolean judgeRepeat(String s) {
        for (int i = 0; i + 3 < s.length(); i++) {
            if (s.substring(i + 3).contains(s.substring(i, i + 3))) {  // 即 判断 [i+3,str.length)中是否含[i,i+3) 的字符串； i逐个往后移动
                return true;
            }
        }
        return false;
    }


    static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) { // 即 判断 [r,str.length)中是否含[l,r) 的字符串； l逐个往后移动
            return true;
        } else {
            return getString(str, l + 1, r + 1);
        }
    }

}

//    //检测是否存在长度大于3的重复子串
//    static boolean getString(String str,int l,int r) {
//        if (r >= str.length()) {
//            return false;
//        }
//        if (str.substring(r).contains(str.substring(l, r))) { // 即 判断 [r,str.length)中是否含[l,r) 的字符串； l逐个往后移动
//            return true;
//        } else {
//            return getString(str, l + 1, r + 1);//返回递归调用的结果 给该层
//        }
//    }