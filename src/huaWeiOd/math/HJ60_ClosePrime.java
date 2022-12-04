package huaWeiOd.math;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/20
 *
先想思路，行的通 再动手

https://www.nowcoder.com/practice/f8538f9ae3f1484fb137789dec6eedb9?tpId=37&tqId=21283&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
输出组成指定偶数的两个素数差值最小的素数对。
20
7
13

 */
public class HJ60_ClosePrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in=sc.nextInt();


/*
        法1：先找所有素数，再找所有和为in的组合，再找其 最近的组合   no no no
        法2：n=a+b,枚举所有的a,就能得到所有的b，再判断a b是否为素数即可
 */
//        法1：
//        Integer[] prime=allPrime(in);
//          int[]  res=find(prime,in);
//        System.out.println(res[0]);
//        System.out.println(res[1]);

//        法2：
        find(in);
        findNice(in);
    }
    private static void find(int target) {
        int min=Integer.MAX_VALUE;
        int[] res=new int[2];

        for (int i = 2; i <= target/2; i++) { //从2开始  到  target/2为止（4=2+2）
            if(isPrime(i) &&  isPrime(target-i)){ // i 和 target-i  和满足
                if(Math.abs(target-i -i) < min){
                    res[0]=i;
                    res[1]=target-i;
                }
            }
        }
        System.out.println(res[0]+"\n"+res[1]);  // 直接打印， 不用返回
    }
    private static void findNice(int num) {
        //如num=10, 遍历:5,6,7,8
        // 从 最接近的  两个中位数开始处理判断
        for(int i = num / 2; i < num - 1; i++) {
            if(isPrime(i) && isPrime(num - i)) {
                System.out.println((num - i) + "\n" + i);
                return;
            }
        }
    }

//    废弃
//    /*
//    20 --》 2  3  5  7      11  13  17  19
//    //        双指针，从中间往两侧找
//    * */
//    private static int[] find(Integer[] prime, int in) {
//        int[] res=new int[2];
//        int start=0,end=prime.length-1;//不应该取 prime数组的中间下标（比如54的中间下标是19，但 27才是中间值），而是 in/2；
//        for(int i=prime.length/2-1,j=prime.length/2-1;i>=0 && j<prime.length;  ) // i j从同一个起点 且 除2向下取整，比如4=2+2
//        {
//            int first=prime[i];
//            int second=prime[j];
//            if(first+second==in){
//                res[0]=first;
//                res[1]=second;
//                break;//找到 则不用循环
//            }else if(first+second>in) {
//                i--;
//             }else if(first+second<in){
//                j++;
//             }
//        }
//        return res;
//    }
//
//    private static Integer[] allPrime(int in) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 2; i <=in ; i++) {
//            if(isPrime(i)){
//                list.add(i);
//            }
//        }
////https://blog.csdn.net/weixin_43314519/article/details/107811547
//        return list.toArray(new Integer[list.size()]);
//    }

//    质数是指在  大于1的自然数中，除了 1和它本身 以外不再有其他因数的自然数。
     private static boolean isPrime(int in){
         for(int i=2;i<=Math.sqrt(in);i++){ // 注意《=  ，比如4
             if(in%i==0){
                 return false;
             }
         }
         return true;
     }
}
