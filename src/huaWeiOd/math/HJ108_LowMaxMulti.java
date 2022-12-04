package huaWeiOd.math;


import java.util.Scanner;
/*
解题思路 最小公倍数=两数之积/两个数的最大公约数
根据语雀 中图：https://www.yuque.com/g/qiangqin/aw0bfu/btitff/collaborator/join?token=KPNKH14fH6soIn4U# 《华为牛客题库》
 */
public class HJ108_LowMaxMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(m * n / y(m, n));
        }
    }

    //求最大公约数
    public static int y(int a, int b) {
        //a设定为较大的值
        if (a < b) {
            int tmp;
            tmp = a;
            a = b;
            b = tmp;
        }
        //求最大公约数
        //非递归方法
// 		int k;
//         //k为余数
// 		while (b != 0) {
// 			k = a % b;
// 			a = b;
// 			b = k;
// 		}
//         		return a;
        //递归方法
        if (b == 0){
            return a;
        }
        return y(b, a % b);
    }
}
