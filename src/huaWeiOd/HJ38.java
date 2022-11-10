package huaWeiOd;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/4
 */
public class HJ38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int h= scanner.nextInt();

       double t= h*1.0; // 初始 高度
       double sum=t;
       for(int i=1;i<5;i++){ // 第5次落地 ，前面反弹了4次
           t= t /2;// 反弹 后的 高度
           sum += 2*(t);
       }
        System.out.println(sum);
        System.out.printf(String.format("%.5f", t/2));
    }
}
