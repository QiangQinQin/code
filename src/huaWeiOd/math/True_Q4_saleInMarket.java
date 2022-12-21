package huaWeiOd.math;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author QiangQin
 * * @date 2022/12/21

https://renjie.blog.csdn.net/article/details/128115638

模拟商场优惠打折，有三种优惠券口可以用，满减券、打折券和无门槛券。
满减券:满100减10，满200减20，满300减30，满400减40，以此类推不限制使用;
打折券:固定折扣92折，且打折之后向下取整Q，每次购物只能用1次;
无门槛券:—张券减5元，没有使用限制;

每个人结账使用优惠券时有以下限制:
每人每次只能用两种优惠券，
并且同一种优惠券必须一次用完，不能跟别的穿插使用(比如用—张满减，再用—张打折，再用一张满减，这种顺序不行)。

求不同使用顺序下每个人用完券之后得到的  最低价格 和 对应使用优惠券的总数;
如果两种顺序得到的价格—样低，就取使用优惠券数量较少的那个。

输入描述:
第一行三个数字m,n,k，分别表示每个人可以使用的满减券、打折券和无门槛券的数量
第二行一个数字x,表示有几个人购物
后面x行数字，依次表示是这几个人打折之前的商品总价

输出描述:
输出每个人使用券之后的最低价格 和 对应使用优惠券的数量

示例:
输入∶
3 2 5
3
100
200
400
输出:
65 6
135 8
275 8
说明:
第一个人使用1张满减券和5张无门槛券价格最低。  100-10 -5*5
第二个人使用3张满减券和5张无门槛券价格最低。  200-20-10-10 -5*5
第三个人使用3张满减券和5张无门槛券价格最低。

最多使用两种优惠卷
同种优惠卷必须一次用完
打折券不能交替使用
打折券只能用一次

 分析：先用无门槛，再用满减 或 打折，会降低基数
 */
public class True_Q4_saleInMarket {
    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()){
//            int manJian= sc.nextInt();
//            int daZhe=sc.nextInt();
//            int noDoor=sc.nextInt();
//            int peopleNum= sc.nextInt();
//            for (int i = 0; i < peopleNum; i++) {
//                int total= sc.nextInt();
//                System.out.println(deal(total,manJian,daZhe,noDoor));
//            }
//        }
//    }
//
////todo    满减怎么表示，怎么
//    // 需要得到 最低价格 和 最少使用优惠券数量
//    private static int deal(int total,int manJian,int daZhe,int noDoor){
//        int res=0,price=0;
////        1. 先用满减，再用打折券
//
//
////        2. 先用满减，再用无门槛
//
//        //3. 先用打折券，再用无门槛
//
//        //4. 先用打折券，再用 满减
//
//
//        return  res;
//    }


        /*
    博主：
        1:暴力遍历即可，因为不能交叉使用且只能使用两种，那么所有的可能性都可以暴力枚举出来:假设为A、B、C
            AB
            BA
            AC
            CA
            BC
            CB
          总共六种使用的可能性。
        2∶其次按照常识，先使用无门槛优惠券，把总价的基数变小之后，再用别的优惠券肯定得不到最大的优惠，所以还剩4种方案。3:按照4种可能行算出结果，比对出最小值即可。
        4∶感觉题目设计是不是有问题，打折券只能用一张，为啥要给出打折券的个数，难道是迷惑项?
        * */
            //处理输入
            Scanner in=new Scanner(System.in);
            List<Integer> params = Arrays.stream(in.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int m = params.get(0);  // 满减券数
            int n = params.get(1);  // 打折券数
            int k = params.get(2);  // 无门槛券数

            int x = Integer.parseInt(in.nextLine());

            while (in.hasNext()) {
                int price = Integer.parseInt(in.nextLine());
                // 存4种模式 对应的 价格和优惠券数
                int[][] result = new int[4][2];
                result[0] = mode_a(price, m, n);
                result[1] = mode_b(price, m, n);
                result[2] = mode_c(price, m, k);
                result[3] = mode_d(price, n, k);

                //按照 价格降序，用券数降序 排序 ！！！
                Arrays.sort(result, (int[] a, int[] b) -> {
                    if (a[0] != b[0]) {
                        // 第一个数不相等 第一个数降序
                        return a[0] - b[0];
                    } else {
                        // 第一个数相等 第二个数降序
                        return a[1] - b[1];
                    }
                });


                System.out.print(result[0][0]);
                System.out.print(" ");
                System.out.println(result[0][1]);

            }
        }

        //先满减后打折
        public static int[] mode_a(int price, int m, int n) {
            int count = 0;
            while(m > 0) { // 即 满减每用完
                if (price < 100) {
                    break;
                }
                price -= (price/100 * 10); // 先用一张 最大的满减
                count += 1;
                m--;
            }
            price *= 0.92; // 打折，截断小数
            count += 1;
            int a[] = {price, count};
            return a;
        }

        //先打折后满减
        public static int[] mode_b(int price, int m, int n) {
            int count = 0;

            price *= 0.92;
            count += 1;

            while(m > 0) {
                if (price <100) {
                    break;
                }
                price -= (price/100 * 10);
                count += 1;
                m--;
            }

            int a[] = {price, count};
            return a;

        }

        //先满减后无门槛
        public static int[] mode_c(int price, int m, int k) {
            int count = 0;

            while(m > 0) {
                if (price <100) {
                    break;
                }
                price -= (price/100 * 10);
                count += 1;
                m--;
            }

            for (int i=0;i<k;i++) {
                price -= 5;
                count += 1;
                if (price <0) {
                    break;
                }
            }

            int a[] = {price, count};
            return a;
        }

        //先打折后无门槛
        public static int[] mode_d(int price, int n, int k) {
            int count = 0;

            price *= 0.92;
            count += 1;

            for (int i=0;i<k;i++) {
                price -= 5;
                count += 1;
                if (price < 0) {
                    break;
                }
            }
            int a[] = {price, count};
            return a;
        }

}
