package huaWeiOd.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/19

https://renjie.blog.csdn.net/article/details/128025784
题目内容
在一个狭小的路口，每秒只能通过一辆车，假好车辆的颜色只有3种，找出N秒内经过的最多颜色的车辆数量。三种颜色编号为0，1，2

输入描述
第一行输入的是通过的车辆颜色信息
[0,1,1,2]代表4秒钟通过的车辆颜色分别是0，1 ,1 ,2
第二行输入的是统计时间窗，整型，单位为秒

输出描述
输出指定时间窗内经过的最多颜色的车辆数量。样例

样例一:
输入
0 1 2 1
3
输出2

样例解释
在3秒时间窗内，每个颜色最多出现2次。例为:[1,2,1]

样例二:
输入
0 1 2 1
2
输出1
样例解释
在2秒时间窗内，每个颜色最多出现1次。

 */
public class True_Q4_maxColorInWindow {
    public static void main(String[] args) {
        //        /*
//        自己：
//
//        遍历每个起点
//        统计时间窗内的颜色数量，找到颜色次数的最大值
//        找到所有时间窗口内的最大值
//
//        颜色只有0 1 2 ，可对应数组下标，数组值 即 对应的颜色出现次数
//
//        时间窗 大于 车辆数？？？？
//         超时？？？？
//        * */
//        Scanner sc = new Scanner(System.in);
//        String[] splits = sc.nextLine().split(" ");
//        int[] cars = new int[splits.length];
//        for (int i = 0; i < splits.length; i++) {
//            cars[i]=Integer.parseInt(splits[i]); //经过的车辆的颜色信息
//        }
//
//        int window= Integer.parseInt(sc.nextLine()); // 时间窗口大小
//
//        int res=0;
//        if(cars.length < window){ // 时间窗 大于 车辆数？？？？
//            int[] counts = new int[3];// 统计各颜色出现次数
//            for (int i = 0; i < cars.length; i++) {
//                if (cars[i] == 0) counts[0]++;
//                if (cars[i] == 1) counts[1]++;
//                if (cars[i] == 2) counts[2]++;
//            }
//
//            int max = 0; //出现次数最多的颜色， 可能有某些颜色为空
//            for (int k = 0; k < 3; k++) {
//                if (max < counts[k]) {
//                    max = counts[k];
//                }
//            }
//            res=max;
//        }else {
//
//            for (int i = 0; i < cars.length - window + 1; i++) { // cars.length-window .....cars.length-1共window个元素；  至少要有一个时间窗
//                int[] counts = new int[3];// 统计各颜色出现次数
//                for (int j = i; j < i + window; j++) {
//                    if (cars[j] == 0) counts[0]++;
//                    if (cars[j] == 1) counts[1]++;
//                    if (cars[j] == 2) counts[2]++;
//                }
//
//                int max = 0; //出现次数最多的颜色， 可能有某些颜色为空
//                for (int k = 0; k < 3; k++) {
//                    if (max < counts[k]) {
//                        max = counts[k];
//                    }
//                }
//
//                res = Math.max(res, max);
//
//            }
//        }
//        System.out.println(res);


        /*
        博主：
        滑动窗口 +  颜色数组
        * */
                // 处理输入
                Scanner in = new Scanner(System.in);
                String input_str = in.nextLine();
                String[] input_list = input_str.split(" ");

                int[] cars = new int [input_list.length];
                String window_size_str = in.nextLine();
                int window_size = Integer.valueOf(window_size_str);

                // 初始化滑动窗口
                int[] car_count = new int[3];
                for (int i=0;i<window_size;i++) {
                    car_count[cars[i]] += 1; // cars[i]即i车 对应的颜色，   颜色是下标，值是次数
                }

                //滑动窗口向前滑
                int max_res = Math.max( Math.max(car_count[0], car_count[1]), car_count[2]); // 暂存当前结果最大值
                for (int i = window_size; i < cars.length; i++) { // i是窗口内元素终点的下标；  窗口后移一个元素，统计的次数 就要改（去除 滑出的元素次数 ； 添加 划入的元素次数）
                    car_count[cars[i]] += 1;
                    car_count[cars[i-window_size]] -= 1;
                    max_res =  Math.max(max_res,  Math.max( Math.max(car_count[0], car_count[1]), car_count[2])); // 在有限个元素中找最大值
                }
                System.out.println(max_res);

    }
}
