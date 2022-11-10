import java.util.Scanner;

/**
a  97
 A  65
 */
public class HJ21 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
        Scanner scanner = new Scanner(System.in);
        String input=scanner.next();

        char[] arr=input.toCharArray();

        for (char ch:arr ) {
            if(Character.isUpperCase(ch)){
                ch= (char) (ch-'a' + '0');

            }
//                ch-3';
        }
    }
}
