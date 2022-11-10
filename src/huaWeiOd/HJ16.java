package huaWeiOd;

/**
 *

 原题：https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&&tqId=21239&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking

 1000 5
 800 2 0
 400 5 1
 300 5 1
 400 3 0
 500 2 0

 2200
 Exception in thread "main" java.lang.NullPointerException???
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


class Item {
    // 价格
    int price;
    // 权重: 价格与重要度的乘积
    int weight;

    public Item(int a, int b) {
        this.price = a;
        this.weight = a * b;
    }
}


public class HJ16 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int money = Integer.parseInt(s[0]);  //            钱数
        int amount = Integer.parseInt(s[1]); // 希望购买的物品件数
        Item[][] items = new Item[amount + 1][3];// amount+1  是因为：0号下标不用， 因为题目中 主件的编号  从1开始    3是因为：1个主键 +  最多两个附件

        // 每一行   是   编号为i的物品的 基本数据
        for(int i = 1; i <= amount; i++) {
            s = br.readLine().split(" ");
            int price = Integer.parseInt(s[0]);   // 价钱
            int weight = Integer.parseInt(s[1]);  // 重要度
            int masterID = Integer.parseInt(s[2]);
            Item tmp = new Item(price, weight);
            if(masterID == 0) { // 0 表示 其为主件
                items[i][0] = tmp;
            } else {            // 不为0，表示该附件  对应的 主件编号
                if(items[masterID][1] == null) {
                    items[masterID][1] = tmp;
                } else {
                    items[masterID][2] = tmp; // 因为 1个主件 最多有两个附件
                }
            }
        }
        /*
            经过以上循环后,items[][] 里存放了所有的主件和附件,
            其中,当items[n][0]为null时,代表items[n]为附件.
        */


        /*
           buyable[n]： 当拥有n元钱的时候能买到的 最大权重。
           此处用一维数组保存,是对算法的空间复杂度进行了优化,如用二维数组,则 空 间复杂度为 N * M
           但是一维数组的缺点就是，到最后不知道买了啥，哈哈。
           如下面的两个循环所示，算法的时间复杂度为N * M
        */
        int[] buyable = new int[money + 1]; //buyable[0]  buyable[1]...    buyable[money]: 当拥有 money元 钱的时候能买到的  最大权重！！！。

        // 表示 可选物品为  items[0]... items[i]!!!
        for(int i = 1; i <= amount; i++) {
            // 不考虑附件，因为不存在单独购买附件的情况
            if(items[i][0] == null) {
                continue;
            }

            //  表示拥有 j 元钱
            for(int j = money; j >= 0; j--) {
                /*
                    定义：items[i] 为items[1][0-2], items[2][0-2]....到items[i][0-2]所包含的物品
                    此处循环是找出当  拥有j元 时,能从 items[0...i]中 买到的最大权重.
                    例如i = 3；j = 1000时，
                        代表了   拥有1000元，从items[1][0-2], items[2][0-2], items[3][0-2]中，
                                能买到的最大权重.
                */
                // 主件 用 master 表示
                Item master = items[i][0];

                // 情形1： 不买主件
                int max = buyable[j];

                // 情形2: 购买主件
                if(j >= master.price  &&  max < buyable[ j - master.price ] + master.weight) {
                    // buyable[j - master.price]: 当用钱 买下主件后  剩余的钱，能买到的最大权重
                    max = buyable[j - master.price] + master.weight;
                }

                // 情形3：购买主件和附件1（附件1存在即代表主件存在）
                if(items[i][1] != null) {
                    int cost = master.price + items[i][1].price; //买下主件和附件1所需的价格
                    int weight = master.weight + items[i][1].weight;
                    if(j >= cost && max < buyable[j - cost] + weight) {
                        max = buyable[j - cost] + weight;
                    }
                }

                if(items[i][2] != null) { // 附件2存在即代表主件及附件1存在）
                    // 情形4: 购买主件及附件2
                    int cost = master.price + items[i][2].price;
                    int weight = master.weight + items[i][2].weight;
                    if(j >= cost && max < buyable[j - cost] + weight) {
                        max = buyable[j - cost] + weight;
                    }

                    // 情形5：购买主件，附件1及附件2
                    cost = master.price + items[i][1].price + items[i][2].price;
                    weight = master.weight + items[i][1].weight + items[i][2].weight;
                    if(j >= cost && max < buyable[j - cost] + weight) {
                        max = buyable[j - cost] + weight;
                    }
                }
                // 存储结果
                buyable[j] = max;
            }
        }


        System.out.println(buyable[money]);
    }
}