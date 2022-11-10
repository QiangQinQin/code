package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/3
 */
public class HJ9 {
    private static int cal(int number) {
        boolean[] marked = new boolean[10];
        int result = 0;
        while (number != 0) {
            if (!marked[number % 10]) {
                result = result * 10 + number % 10;
                marked[number % 10] = true;
            }
            number /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int number = in.nextInt();
            int result = cal(number);
            System.out.println(result);
        }
    }
}
