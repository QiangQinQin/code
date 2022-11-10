package huaWeiOd;

/**
 * @author QiangQin
 * * @date 2021/10/8
 */
import java.util.Scanner;

public class HJ35{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();    //行数 n

            int[][] result = new int[n][];    // 1.建立数组（n行）
            int t = 1;    //记录依次赋予的 数组值
            // 行下标
            for(int i=0; i < n; i++){
                result[i] = new int[n-i];    //  2.数组第i行有n-i个元素!!!  每行的元素个数不一样
                // 列下标
                for(int j=0; j < i+1; j++){    //对第i个对角线赋值  (看图：第i个对角线  有 i+1个元素，即从 0,..i)
                    result[i-j][j] = t; //行下标逐渐变小 列逐渐增加，即 斜向上填
                    t++;
                }
            }

            //输出数组值
            for(int[] a : result){ //输出每一维的数据
                for(int a1 : a)
                    System.out.print(a1 + " ");
                System.out.println();
            }
        }
    }
}