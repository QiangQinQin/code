package huaWeiOd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/6
 */

//“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
//        方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
//        然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，
//        最多可以换多少瓶汽水喝？
//输入描述:
//        输入文件最多包含10组测试数据
//      每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。
//      n=0表示输入结束，你的程序不应当处理这一行。
//输出描述:
//        对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。

//    输入
//            3
//            10
//            81
//            0
//    输出
//            1
//            5
//            40
public class HJ22 {
    public   static  void change(ArrayList<Integer> input){
        int output;
//        对输入的每个数据都有一个输出
        for(int i=0;i<input.size();i++){
            if(input.get(i)<3){
                output=0;
            }else {
//                已兑换的数量
                int exchange=input.get(i)/3;
//                换完后还剩的瓶子
                int left= input.get(i)%3+exchange;
                while(left >= 2){
                    //可以借一个
                    if(left==2){
                        exchange+=1;
                        break;
                    }else{
                        exchange+=left/3;
                        left= left%3+left/3;
                    }
                }
                output=exchange;
            }
            System.out.println(output);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> input=new ArrayList<>();//动态数组

//       接受多组数据(当前是0，就不读了)
        while(scanner.hasNext()){
            int tmp=scanner.nextInt();
            if(tmp==0)
                break;
            else {
                input.add(tmp);
            }
        }
//        Integer[] array = input.toArray(new Integer[]{});//转到new Integer[]{}里，然后用左边的array接住了

        //        while (true) {
//            System.out.print("请输入数值:");
//            int number = input.nextInt();
//            if (number != 0){
//                array.add(number);
//            }else {
//                break;
//            }
//        }

            change(input);
    }
}

//剩2个空瓶子时，可以先找老板借一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
// 也就是说2个空瓶子即可换一瓶汽水喝，而且喝完之后手里也没有空瓶子。
// 求解时直接把空瓶数除以2，即可得到正解。
//Scanner sc = new Scanner(System.in);
//            while(!sc.hasNext("0")){//当下一个不为0时，就读取该数字
//                  int n=sc.nextInt();
// //  可以直接输出n/2即为结果
//                  int count=0;//默认为0
//                  while(n/3>0){
//                      count+=n/3;
//                      n=n/3+n%3;
//                      if(n==2){
//                      n=n+1;
//                     }
//                  }
//             System.out.println(count);
//           }