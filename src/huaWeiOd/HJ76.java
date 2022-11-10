package huaWeiOd;

import java.util.Random;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/2
 */
public class HJ76 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();

            int a1 = (int)Math.pow(m,2)+1-m;
            StringBuilder sb = new StringBuilder(Integer.toString(a1));//直接传数字是容量的意思
            for(int i = 1; i < m; i++){
                a1 = a1 + 2;
                sb.append("+");
                sb.append(a1);
            }
            System.out.println(sb);

//            Random
        }
    }
}
