package huaWeiOd.math;

import java.util.Scanner;


/**
 * @author QiangQin
 * * @date 2022/11/20
 *
 * https://www.nowcoder.com/practice/88ddd31618f04514ae3a689e83f3ab8e?tpId=37&tqId=21322&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
自守数是指一个数的平方的尾数等于该数自身的自然数。
例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。
请求出n(包括n)以内的自守数的个数

输入：
6
输出：
4
说明：
有0，1，5，6这四个自守数


输入：
1
输出：
2
说明：
有0, 1这两个自守数
 */
public class HJ99_ZiShou {
    public static void main(String[] args) {

        System.out.println(judgeWeiShu(1232));


        Scanner in = new Scanner(System.in);
        int num=in.nextInt();

        System.out.println(judgeZiShou(num));
    }

    private static int judgeZiShou(int num) {
        int res=0;
        for(int i=0;i<=num;i++){
            if((Math.pow(i,2)-i)  % Math.pow(10,judgeWeiShu(i))==0)  // (5*5 -5)%10=0   反例：10  --》100-10
                res++;
        }

        return res;
    }

    private static int judgeWeiShu(int num) {
        int res=1;
        while(num/10!=0){
            num/=10;
            res++;
        }
        return res;
    }
}
