package Simulation.Prac1128;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/28
1.
汽水瓶
某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
数据范围：输入的正整数满足

注意：本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
https://www.nowcoder.com/exam/test/64153962/submission?pid=1088888

 */
public class testBottom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            if(num!=0){
                System.out.println(num/2);
            }else{
                break;
            }

        }

    }
}
