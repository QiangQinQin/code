package huaWeiOd;

import java.util.Scanner;

public class HJ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();

             //先补0，让字符串长度为8的倍数
            StringBuilder sb = new StringBuilder(str);
            int size = str.length();
            int addZeroNum = 8 - size % 8;//[1,8]
            while ((addZeroNum > 0) && (addZeroNum < 8)) {//注意边界调节，避免addzero=8
                sb.append("0");//也可append ‘’或“”
                addZeroNum--;
            }
            String str1 = sb.toString();

            //  截取
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }
        }
    }
}
