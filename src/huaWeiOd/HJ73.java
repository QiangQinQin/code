package huaWeiOd;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/2
 */
public class HJ73 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int y=in.nextInt();
        int m=in.nextInt();
        int d=in.nextInt();
        Calendar c1=Calendar.getInstance();//实例化
        c1.set(y, m-1, d);//注意月份从0开始
        System.out.println(c1.get(Calendar.DAY_OF_YEAR));
    }
}
