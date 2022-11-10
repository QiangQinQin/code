package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/4
 */
public class HJ107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();

        double num= input>0? input:-input; //负数 当正数来处理

        double bottom = 0;
        double top = 0;
        while (top * top * top < num) {
            top++;
        }
        bottom = top - 1;

        double mid = bottom + (top - bottom) / 2;
        double mul = mid * mid * mid;

        while(top - bottom > 0.1){  // 因为只保留一位小数
            if (mul > num) {
                top = mid;
            } else if (mul < num) {
                bottom = mid;
            }

            mid = bottom + (top - bottom) / 2;
            mul = mid * mid * mid;
        }

        if(input<0){
            mid=-mid;
        }
        System.out.println(String.format("%.1f",mid));  //  12  => 2,3      -5 ==> -1.7

    }


//    private static double findAns(double num,double top,double  bottom) {
////        double ans = 0;
//        double mid = bottom + (top - bottom) / 2;
//
//        double mul = mid * mid * mid;
//        while(mul != num){
//            if (mul > num) {
//                top = mid;
//            } else if (mul < num) {
//                bottom = mid;
//            }
//
//            mul = mid * mid * mid;
//
//        }
//        return  mid;
//    }

}
