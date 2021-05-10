package huaWeiOd.test;
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
public class transaction
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] m=scanner.nextLine().split(",");
        int[] cost=new int[m.length];
        for(int i=0;i<m.length;i++){
//            https://www.cnblogs.com/zhangjs8385/archive/2011/11/04/2236527.html
//             由 String 转换成 数字的基本数据型态
            cost[i]= Integer.parseInt(m[i]);
        }



//由 基本数据型态转换成 String
//        int i = 10;
//        String str = String.valueOf(i);
//        这时候 str 就会是 "10"

        String[] n=scanner.nextLine().split(",");
        int[] sale=new int[n.length];
        for(int i=0;i<n.length;i++){
            sale[i]= Integer.parseInt(n[i]);
        }

        int money=scanner.nextInt();
//        System.out.println(money);


    }
}
