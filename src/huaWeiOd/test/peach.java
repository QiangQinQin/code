package huaWeiOd.test;

import java.util.Scanner;

/**
 * 链接：https://ac.nowcoder.com/discuss/347483
 * <p>
 * 孙悟空偷吃蟠桃，天兵天将会离开蟠桃园k小时，求孙悟空在天兵天将回来之前，孙悟空将所有蟠桃吃完的最小吃桃速度，
 * 在吃每棵蟠桃树上桃子时，剩下的一个小时内，如果没有可吃的桃子，这一小时内不再吃其他树上的桃子。
 * 输入为每棵树上蟠桃数量，以及天兵天将会回来的时间，输出为最小的吃桃速度。
 * input：3，11，6，7          8
 * output：                                                  4  （最小吃桃速度）
 * <p>
 * 暴力穷举？  会超时？
 * <p>
 *
 * 思路:
 * 速度递增，逐一分析：
 * 求某特定速度下，每棵树的用时，
 * 将各树用时累加起来
 * 然后 和 天兵天将回来的时间 对比
 */
public class peach {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");//  3 11 6 7 8

        int[] num = new int[input.length - 1];
        int time = 0;//回来时间

        for (int i = 0; i < input.length; i++) {
            if (i == input.length - 1)
                time = Integer.parseInt(input[i]);
            else {
                num[i] = Integer.parseInt(input[i]);
            }
        }


        int speed = 1;
        int tmp = 0;
         //  i是树的编号
        for (int i = 0; i < num.length; i++) {
            tmp = tmp + (int)(Math.ceil(num[i]*1.0 / speed));  //转为float,结果也是float，然后向上取整

           //当前速度吃桃 会超时，则  从头试下一个速度
            if (tmp > time) {
                speed++;
                tmp = 0;
                i = -1; // 因为for循环里要i++，会从1开始
            }

        }

        System.out.println(speed);


        //  //机试时所写  一坨屎  不想看
//        Scanner scanner = new Scanner(System.in);
//        String[] input=scanner.nextLine().split(" ");
//        int[] num=new int[input.length-1];
//        int time=0;
//        int count=0;
//        int speed=0;
//        int tmp=0;//某速度用时
//
//        for(int i=0;i<input.length;i++){
//            if(i==input.length-1)
//                time= Integer.parseInt(input[i]);
//            else{
//                num[i]= Integer.parseInt(input[i]);
//                count+=num[i];
//            }
//        }
//        //输入异常时 -1
//        if(time<num.length){
//            System.out.println("-1");
//        }else{
////            一次只能吃一个树
//            speed=count/time;
//
//            for(int i=0;i<num.length;i++){
//
////                向上取整（＋0.5后四舍五入）
//                tmp+= (num[i]%speed==0?(num[i]/speed):(num[i]/speed+1));
//                System.out.println("第"+i+"个用时："+ (num[i]%speed==0?(num[i]/speed):(num[i]/speed+1))+"总时间："+tmp);
//            }
//            while(tmp>time){
//                speed++;
//                time=0;
//                for(int i=0;i<num.length;i++){
//                    tmp=tmp + num[i]%speed==0?(num[i]/speed):(num[i]/speed+1);
//                }
//            }
//
//            System.out.println(speed);
//        }

    }
}
