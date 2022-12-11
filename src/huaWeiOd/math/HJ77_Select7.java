package huaWeiOd.math;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/9
https://www.nowcoder.com/practice/ba241b85371c409ea01ac0aa1a8d957b?tpId=37&tqId=21278&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

描述
输出 1到n之间 的与 7 有关数字的个数。
一个数与7有关是指这个数是 7 的倍数，或者是包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）

数据范围：1≤n≤30000
输入描述：
一个正整数 n 。( n 不大于 30000 )

输出描述：
一个整数，表示1到n之间的与7有关的数字个数。

示例1
输入：
20
输出：
3
说明：
输入20，1到20之间有关的数字包括7,14,17共3个。
 */
public class HJ77_Select7 {
    public static void main(String[] args) {

        /*
        自己： 1）转字符contains 7   2) x%7==0 ?
        * */

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum=0;// 统计个数
            for(int i = 1;i<=n;i++){
                if(i%7==0){
                    sum++;
                }else{
                    String s = String.valueOf(i);
                    if(s.contains("7")){
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

}
