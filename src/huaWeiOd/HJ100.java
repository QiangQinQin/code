package huaWeiOd;

import java.util.Scanner;


public class HJ100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int res = (1+3*n)*n/2;
            System.out.println(res);
        }
    }
}
