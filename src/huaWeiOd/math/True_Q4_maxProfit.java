package huaWeiOd.math;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/26
https://blog.csdn.net/misayaaaaa/article/details/128244039?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167198428916800182172080%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=167198428916800182172080&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-1-128244039-null-null.blog_rank_default&utm_term=%E4%B9%B0%E5%8D%96%E6%B0%B4%E6%9E%9C&spm=1018.2226.3001.4450
3
3
4 5 6
1 2 3
4 3 2
1 5 3

 32=4*(3-1) +  5*(0) + 6*(1-5)

 1
 1
 1
 1
 */
public class True_Q4_maxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number=Integer.parseInt(sc.nextLine());
        int days=Integer.parseInt(sc.nextLine());

        int[] maxHold = new int[number];
        String[] holds=sc.nextLine().split(" ");
        for (int i = 0; i < number; i++) {
            maxHold[i]=Integer.parseInt(holds[i]);
        }

        int[][] itemPrice = new int[number][days];
        for (int i = 0; i < number; i++) {
            String[] prices=sc.nextLine().split(" ");
            for (int j = 0; j < days; j++) {
                itemPrice[i][j]=Integer.parseInt(prices[j]);
            }
        }

        int maxProfit=0;

//        统计每个商品的最大收益
        for (int i = 0; i < number; i++) {
            int min=itemPrice[i][0];
            int maxSub=0;
            for (int j = 0; j < days; j++) {
                maxSub= (itemPrice[i][j]-min)>maxSub ? (itemPrice[i][j]-min):maxSub; // 第i号商品在第j天的价格
            }
            maxProfit += maxHold[i]*maxSub;
        }
        System.out.println(maxProfit);

    }
}
