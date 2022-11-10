package huaWeiOd;

import java.util.ArrayList;
import java.util.Scanner;
//不一定看上去简洁的代码，运行复杂度就简单。分情况，专门处理的代码虽多但可能比较合理
/*
* 题目描述
功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）
（如180的质因子为2 2 3 3 5 ）
最后一个数后面也要有空格

输入描述:
输入一个long型整数
输出描述:
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
*/
public class HJ06 {
// 若m 不 能被 2 ~ 根号m 间任一整数整除，m 必定是素数
// 合数指自然数中除了能被1和本身整除外，还能被其他数（0除外）整除的数。
// 与之相对的是质数，
// 而1既不属于质数也不属于合数。
    public static boolean judge(long num){
        long end= (long)Math.sqrt(num);
        for(long i=2;i<=end;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

//先找不大于这个数的所有质数
// 从最小的质数开始试，再看该数能否被此质数整除，
// 可以就保存，把结果作为被除数，从不大于这个数的最小的质数开始试；
// 否则就找下一个质数，能否被整除
//        辗转相除法
//

//        先不要想时间复杂度，简单粗暴有效的实现，再改进
        Scanner scanner=new Scanner(System.in);
        long input= scanner.nextLong();

//        数字本身是质数
//        数字的质数因子
//        找到素数
        if(judge(input)){
            System.out.println(input+" ");
        }else{
            ArrayList<Long> prime=new ArrayList<>();
            for(long i=2;i<=Math.sqrt(input);i++){ //判断0 到 根号input的数 里是质数的个数
                if(judge(i)){ //费时间
                    prime.add(i);
                }
            }
//            System.out.println(prime);
            for(int i=0;i<prime.size();i++){
                if(input%prime.get(i)==0){
                    System.out.print(prime.get(i)+" ");
                    input=input/prime.get(i);
                    i=-1;//这轮i++完为0
                }
                if (judge(input)) {
                    System.out.print(input+" ");
                    break;
                }
                if(input==0)//93938 --> 2 13 3613
                    break;
            }
        }
      }
}



// 正如我们判断数 num 是不是质数时，没必要从 2 一直尝试到 num 一样，
// 此题中的大循环也大可不必写一个到 num 的循环，写到 根号num 即可，
// 如果此时数字还没有除数，则可判定其本身是一个质数，没有再除下去的必要了，直接打印其本身即可：
//     long num = scanner.nextLong();
//    long k = (long) Math.sqrt(num);
//
//    for (long i = 2; i <= k; ++i) { //i=2,一直保持到里面的while执行完才改变
//        while (num % i == 0) {//余数为0，即能被分解时（若有合数的因子也被拆成小
// 素数先处理了（4=2*2）  180-》90-》45-》15-》5-》1
//            System.out.print(i + " ");//直接输出，不用保存到数组
//            num /= i;//将结果作为被除数继续判断
//        }
//    }
//    System.out.println(num == 1 ? "": num+" ");//等于1时，说明不是素数，什么都不用再输出；否则就输出原数字加空格
