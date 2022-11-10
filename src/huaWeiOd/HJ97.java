package huaWeiOd;

import java.util.Scanner;


public class HJ97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();           //数据个数
            int countNegative = 0;
            int countPositive = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {   //具体数据
                int number = sc.nextInt();
                if (number < 0) {
                    countNegative++;
                } else if (number > 0){
                    sum += number;
                    countPositive++;
                }
            }

               System.out.println(countNegative + " " + String.format("%.1f", sum * 1.0 / countPositive));

            System.out.print(countNegative + " " );
            System.out.printf("%.1f", (sum * 1.0 / countPositive));
            System.out.println();
        }

        sc.close();
    }
}
