package huaWeiOd.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/26
https://www.nowcoder.com/practice/f9a4c19050fc477e9e27eb75f3bfd49c?tpId=37&tqId=21264&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ41%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ41
描述
现有n种砝码，重量互不相等，分别为 m1,m2,m3…mn ；
每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。

注：
称重重量包括 0
数据范围：每组输入数据满足 1≤n≤10  ， 2000 \1≤m  ，1≤xi≤10

输入描述：
对于每组测试数据：
第一行：n --- 砝码的种数(范围[1,10])
第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])

输出描述：
利用给定的砝码可以称出的不同的重量数

输入：
2
2 1
1 2
输出：
5
说明：
可以表示出0，1，2，3，4五种重量。
(*前为数量  *后为重量)
 0*2 + 0*1 = 0
 0*2 + 1*1 = 1
 0*2 + 2*1 = 2

 1*2 + 0*1 = 2
 1*2 + 1*1 = 3
 1*2 + 2*1 = 4


算法过程：
(*前为数量  *后为重量)
 0  = 0

 0+1*2 =2

 0+  1*1 = 1
 2+  1*1 = 3

 0+ 2*1 =2
 1+ 2*1 =3
 2+ 2*1=4
 3+2*1=5
 */
public class HJ41_Weight {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//
//        int[] w = new int[n];
//        String[] splits = sc.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            w[i]= Integer.parseInt(splits[i]);
//        }
//
//        int[] nums = new int[n];
//        String[] ns = sc.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            nums[i]= Integer.parseInt(ns[i]);
//        }
//
//
//        //穷举所有集合，然后用set去重
//        for(int i=0;i<n;i++){
//
//        }
//
//        // 列出个数的全排列？

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();//个数
            int[] w = new int[n];
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                w[i] = in.nextInt();//砝码的重量
            }
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();//砝码个数
            }


            HashSet<Integer> set = new HashSet<>();//存放所有可能的结果
            //添加一个必有的0
            set.add(0);
            //逐步添加砝码
            for(int i=0;i<n;i++){
                ArrayList<Integer> list = new ArrayList<>(set);//取当前所有的结果
                //遍历当前砝码的 所有可能个数
                for(int j=1;j<=nums[i];j++){
                    //给当前结果集中每种重量 都加上  当前砝码砝码*数量
                    for(int k=0;k<list.size();k++){
                        set.add(list.get(k) + w[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}

