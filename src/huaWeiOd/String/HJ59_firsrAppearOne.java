package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/7
https://www.nowcoder.com/practice/e896d0f82f1246a3aa7b232ce38029d4?tpId=37&tqId=21282&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
描述
找出字符串中第一个只出现一次的字符

数据范围：输入的字符串长度满足  1000 \1≤n≤1000

输入描述：
输入一个非空字符串
输出描述：
输出第一个只出现一次的字符，如果不存在  输出-1

示例1
输入：
asdfasdfo
输出：
o
 */
public class HJ59_firsrAppearOne {
    public static void main(String[] args) {
        /*
        思路1：   subString(i).contains(charAt(i) )
        思路2：   遍历每个字符，判断第一次和最后一次出现的下标是否相同  str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i)
        思路3：   第一次遍历用 HashMap统计次数，第二次遍历找找第一个出现次数为1的字符

        *
        * */

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //设置信号量
            int signal = 0;
            //读取输入内容
            String str = sc.nextLine();
            //遍历输入内容
            for(int i = 0; i < str.length(); i++){
                //判断每个字符是否出现第二次，如果存在，设置信号量signal为1；
                if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                    System.out.print(str.charAt(i));
                    signal = 1;
                    break;
                }
            }
            //如果信号量为零，证明不存在重复字符
            if(signal == 0){
                System.out.println(-1);
            }
            //每读取一行输出一个回车
            System.out.println();
        }
    }
}
