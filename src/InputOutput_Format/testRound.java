package InputOutput_Format;

import java.math.BigDecimal;

/**
 * @author QiangQin
 * * @date 2022/11/14
 */
public class testRound {
    public static void main(String[] args) {
        double d = 1.23456789;
        BigDecimal decimal=new BigDecimal(d);

        // 四舍五入为五位小数
        System.out.printf("%.3f",d); // 1.235
        System.out.println();

           System.out.println(decimal.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue()); //1.235
        System.out.println(decimal.setScale( 0, BigDecimal.ROUND_UP ).longValue());// 向上取整     2
        System.out.println((int)Math.ceil(d));// 2.0

        System.out.println(decimal.setScale( 0, BigDecimal.ROUND_DOWN ).longValue());// 向下取整  1
        System.out.println((int)Math.floor(d));//1.0


    }
}
