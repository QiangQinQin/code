package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/2
 */
public class HJ106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();

        StringBuilder builder = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){
            builder.append(str.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
