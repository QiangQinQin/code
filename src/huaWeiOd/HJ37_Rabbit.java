package huaWeiOd;

import java.util.ArrayList;
import java.util.Scanner;
//
////有一只兔子，从出生后 第3个月起 每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
//// 假如兔子都不死，问每个月的兔子总数为多少？
////        本题有多组数据。
////
////（即满两个月才会生产），第三个月会生产一直兔子，第三个月过去那只小兔子也会满一个月。
////        输入描述:
////            输入int型表示month
////
////        输出描述:
////            输出兔子总数int型
////
////     输入
////          9
////     输出
////         34
//
////将兔子分成三类：小，中，大
////所以每个月的兔子数量为
////     月 1    2    3    4    5    6    7    8    9    10    11    12
////
////     小 1    0    1    1    2    3    5    8    13    21    34    55
////
////     中 0    1    0    1    1    2    3    5    8      13    21    34
////
////     大 0    0    1    1    2    3    5    8    13    21    34    55
//兔子数量：1      1      2      3      5     8       13
//
////小兔数等于当月的大兔数
////上个月的大兔数＋上个月的中兔数=这个月的大兔数
////大中小兔相加即为该月总数
////填表先写大兔数-》小兔数-》中兔数
////分析：由上表，每个月兔子的总数都为前 两 个月兔子的总和
//
//public class HJ37_Rabbit {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
////        可以输入多组数据
//        while(sc.hasNext()){
//            int input = sc.nextInt();
//            System.out.println(getNumber(input));
//        }
//    }
////斐波那契数列
//    private static int getNumber(int input) {
//        if(input < 3){
//            return 1;
//        }
//        return getNumber(input - 2)  + getNumber(input - 1) ;
//    }
//}


//定义一个兔子类

public class HJ37_Rabbit {
    //提交代码只能有一个类，注意Rabbit位置（这样写，有点费空间）
    /**
     * 兔子类
     */
    public static class Rabbit {
        private int age;

        //初始化
        public Rabbit(int age) {
            this.age = age;
        }


        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();

            //1.初始时农场有一只年龄为0的兔子,添加到存放每个兔子信息的farm数组里
            ArrayList<Rabbit> farm = new ArrayList<>();
            Rabbit rabbit = new Rabbit(0);
            farm.add(rabbit);

            //2.每过去一个月：在这一个月*里面*，满了两个月的兔子会生产，同时它们的年龄会增加
            for (int i = 0; i < month; i++) {//每个月都要把所有兔子处理完一遍
                int n = farm.size();
                for (int j = 0; j < n; j++) {//处理每个兔子，可以生育的话，就添加一个小兔子到农场里
                    Rabbit rabbit1 = farm.get(j);
                    if (rabbit1.getAge() >= 2) {
                        farm.add(new Rabbit(1));//这里是1不是0，需要注意。因为这个月过去了小兔子也满一个月了
                    }
                    rabbit1.setAge(rabbit1.getAge() + 1);//老兔子长一岁
                }
            }
            //得到兔子的总数
            int number = farm.size();
            System.out.println(number);
        }
    }
}