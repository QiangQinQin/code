package huaWeiOd.test;

import java.util.Arrays;
import java.util.Scanner;
/*
4,2,6,4
5,3,8,7
15

经验（×）  教训（√）
脑子混乱    自己不会，不代表问题本身难
知道理解知识 和 能熟练使用还有个练习的差距，还要能说会道
建议配一本书，有问题先查书
午睡不要太久
提交后不能修改
可能不准使用库函数
顶住压力，尽早尽快完成任务
迎难而上积极尝试，尽量快速解决完问题，最后几分钟会紧张，不会有什么成果
简单得大家都能做好，没有什么成就感。
网络上搜索的是信息，而不是知识
学问不是文字，也不是知识，学问是从人生经验上来，做人做事上去体会的。随时随地的生活都是我们的书本，都是我们的教育。
避免基础的语法问题，把精力放在逻辑上
尽量少查资料。先自己解决，提高能力，印象也深。可以修正自己想的不对的地方
https://blog.csdn.net/yancr/article/details/89364757
命名为Main,似乎可以直接复制到在线机试上
抓住主要矛盾，娱乐都是小事，次要位置
因为不好好准备，而错过原本的机会，只有后悔
坚持练习刷题与回顾
认清形势：很有可能只能社招去外包 和小公司，被压榨，且没有提高

*/

/*
https://blog.csdn.net/yancr/article/details/89364757
题目描述：
    小王手里有点闲钱，想着做点卖水果的小买卖。
    给出两个数组m、n，用m[i]代表第i个水果的成本价，n[i]代表第i水果能卖出的价钱，
    假如现在有本钱k，试问最后最多能 赚 多少钱？

说明：
    1 每种水果只需买 一次（即一个） ，只能卖一次
    2 数组m、n大小不超过50
    3 数组元素为正整数，不超过1000

输入描述：
    1 数组m、n
    2 本钱k

备注：
    1 首行输入逗号分隔的数组m的元素值(即成本价)
    2 第二行输入逗号分隔的数组n的元素值(即售价)
    3 第三行输入本钱

输出描述：
    最多能 赚取 多少钱。（似乎是 本金 的意思）

示例1
输入
    4,2,6,4
    5,3,8,7
    15
输出
    22

说明
样例计算过程：
    先买前3种水果，全部卖出，（花4+2+6=12元  剩3元   卖16元，本金共16+3=19）
    再买第4种水果，再卖出，  （19-4+7=22元）
    最后本金变为22。
    （似乎不应该按这个次序买，不是 最佳搜索策略？？？）

思路：
    综合考虑 成本 和 利润，决定买的次序？

    穷举所有次序，计算利润，然后找利润最大？

    计算每个商品的利润率，
    然后先买能买的起的利润率最大的，
    直到 都买过，或者 全部买不起？  https://www.jianshu.com/p/6bedfc837cda

    先买 成本 便宜的，成本同样便宜的话，就先买 售价 高的
    随后卖掉（相当于本金增加了），
    再去买贵的
     https://daimajiaoliu.com/daima/479dc59e1900407
     对应买的顺序（2，3）  （4，7）  （4，5）  （6，8）
 */

public class transaction {
    static class B implements Comparable<B> {
        int m;
        int n;

        B(int m, int n) {
            this.m = m;
            this.n = n;
        }

//        （即先买最便宜的，且利润最大的水果，卖出后，有更多钱了，再继续卖其他的）
        @Override
        public int compareTo(B o) {
            if (m > o.m) { //即按成本 由小到大 排序
                return 1;
            }
            if (m < o.m) {
                return -1;
            }
            if (n > o.n) { //成本相同，按售价 由大到小 排序
                return -1;
            }
            if (n < o.n) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] mm = in.nextLine().split(",");  //进价
        String[] nn = in.nextLine().split(",");  //售价
        int k = in.nextInt();//本金

        B[] b = new B[mm.length]; //  将  （进价  售价） 包装成  一个B类型数据
        for (int i = 0; i < b.length; i++) {
            b[i] = new B(Integer.parseInt(mm[i]), Integer.parseInt(nn[i]));
        }

        // 方便回收
        mm = null;
        nn = null;

        Arrays.sort(b);//  b是B类型的，用里面的CompareTo方法。按成本由低到高，利润由高到低的顺序  购买商品，再卖出 （本金增长为 原本金+利润）
        for (int i = 0; i < b.length; i++) {
            if (k >= b[i].m && b[i].n > b[i].m) { //能买的起  且  有利润，就买一个
                k += (b[i].n - b[i].m);
            }
        }
        System.out.print(k);

        in.close();
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] m=scanner.nextLine().split(",");
//        int[] cost=new int[m.length];
//        for(int i=0;i<m.length;i++){
////            https://www.cnblogs.com/zhangjs8385/archive/2011/11/04/2236527.html
////             由 String 转换成 数字的基本数据型态
//            cost[i]= Integer.parseInt(m[i]);
//        }
//
//
//
////由 基本数据型态转换成 String
////        int i = 10;
////        String str = String.valueOf(i);
////        这时候 str 就会是 "10"
//
//        String[] n=scanner.nextLine().split(",");
//        int[] sale=new int[n.length];
//        for(int i=0;i<n.length;i++){
//            sale[i]= Integer.parseInt(n[i]);
//        }
//
//        int money=scanner.nextInt();
////        System.out.println(money);
//
//
//    }


}


