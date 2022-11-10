package huaWeiOd;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/9/26
 */
public class HJ72 {
    public static void main(String[] args) {
//        Collections.sort();
        Scanner in = new Scanner(System.in);


//        while (in.hasNextInt()) {
//            int  invalid = in.nextInt();
//
//            for (int male = 0; male <= 20; male++) {           // 公鸡(值5)   20*5
//                for (int female = 0; female <= 33; female++) { // 母鸡值3     33*3
//                    int left = (100 - male * 5 - female * 3);//买公鸡 和 母鸡后的余额
//
//                    if (left > 0   &&  male+female+left*3 ==100){
//                        System.out.println(male + " " + female + " " + left*3);//鸡雏 值1/3   1元能买3个
//                    }
//                }
//            }
//         }

        while (in.hasNextInt()) {
            int invalid = in.nextInt();

            for(int male =0;male<= 20; male++){
                double female=(200 - 14 * male) / 8.0;
                double child = 100 - female - male;
                if (female == (int)(female)  && female >= 0 && child >= 0)
                    System.out.println(male + " " + female + " " + child);
            }

        }
    }
}
