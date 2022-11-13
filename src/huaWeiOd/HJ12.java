    package huaWeiOd;

    import java.util.Arrays;
    import java.util.Scanner;
    import java.util.UUID;

    /**
     * @author QiangQin
     * * @date 2021/5/6
     */
    //接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
    public class HJ12 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


    //            next()方法读取到空白符就结束l；
    //            nextLine()读取到回车结束也就是“\r”；
                String str= scanner.nextLine();
                //将字符串变成char数组再倒序输出
                char[] chars= str.toCharArray();
                for(int i=chars.length-1;i>=0;i--){
                    System.out.print(chars[i]);
                }
//            System.out.print(countNegative + " " );
//            System.out.printf("%.1f", sum * 1.0 / countPositive  + '\n');



        }
    }
