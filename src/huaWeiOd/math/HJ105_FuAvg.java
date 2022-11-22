package huaWeiOd.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/20
 *
https://www.nowcoder.com/practice/64f6f222499c4c94b338e588592b6a62?tpId=37&tqId=21328&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=

输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0

输入描述：
输入任意个整数，每行输入一个。

输出描述：
输出  负数个数   以及   所有非负数的平均值

输入：
-13
-4
-7

3
0.0
 */
public class HJ105_FuAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int countFu=0;
        int countZheng=0;
        int sum=0;
        while(sc.hasNextInt()){  // 注意最后要输入一个 非数字的东西：https://blog.csdn.net/xiyuanda/article/details/119926249
            int in=sc.nextInt();
            if(in <0){
                countFu ++;
            }else{
                countZheng++;
                sum+=in;
            }

        }

        double avg=0.0;
        if(countZheng!=0){
            avg=sum/(double)countZheng;  //注意 除0前 先判断   ;  注意要先转为double，不然损失精度
        }

        System.out.println(countFu);
        System.out.printf("%.1f",avg);
    }
}
