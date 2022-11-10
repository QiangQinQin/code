package huaWeiOd;

import java.util.Scanner;

public class HJ86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();    //读取数字
            int max = 0,
                    tmp = 0;    //计数变量

            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1)    //如果末位为1则计数
                    tmp++;
                else {
                    if (tmp > max)
                        max = tmp;
                    tmp = 0;
                }

                num = num >>> 1;    //无符号右移
            }
            System.out.println(max);
        }

    }
}
