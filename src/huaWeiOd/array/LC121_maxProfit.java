package huaWeiOd.array;

/**
 * @author QiangQin
 * * @date 2022/12/20

https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/

121. 买卖股票的最佳时机
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。



示例 1：
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。


提示：

1 <= prices.length <= 105
0 <= prices[i] <= 104




 */
public class LC121_maxProfit {
    public static int maxProfit(int[] prices) {
        int res=0,min=Integer.MAX_VALUE;
/*
思路1：
双重for, 遍历所有起点，找这个起点后面值的最大值，并记录差值。  再找差值里 最大的

思路2：
记录当前遇到的最小值， 和 当前值比，若差值大于最优，则更新。   表示在前面的最小值处买入，在当前值处卖出
* */
        for (int price : prices) {
            if(price<min)  min=price;
            if(price> min) {
                res=Math.max(res, price-min);
            }
        }
        return res;
    }


    /*
 官方：
遍历价格数组一遍，记录历史最低点，
然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？
当考虑完所有天数之时，我们就得到了最好的答案
    * */
    public int maxProfitLC(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
