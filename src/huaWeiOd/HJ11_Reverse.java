package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/4/30
 */
public class HJ11_Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        String str=in.nextLine();
//        StringBuffer rs=new StringBuffer(str);
//        rs.HJ11_Reverse();
//        System.out.println(rs);
        int num=in.nextInt();
        if(num==0)
            System.out.print(0);
        else
        {
            while(num!=0)
            {
                System.out.print(num%10);
                num /= 10;
            }
        }
    }
}
