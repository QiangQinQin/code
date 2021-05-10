package huaWeiOd.test;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/5/6
 */
public class peach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        int[] num=new int[input.length-1];
        int time=0;
        int count=0;
        int speed=0;
        int tmp=0;//某速度用时

        for(int i=0;i<input.length;i++){
            if(i==input.length-1)
                time= Integer.parseInt(input[i]);
            else{
                num[i]= Integer.parseInt(input[i]);
                count+=num[i];
            }
        }

        //输入异常时 -1
        if(time<num.length){
            System.out.println("-1");
        }else{
//            一次只能吃一个树
            speed=count/time;

            for(int i=0;i<num.length;i++){

//                向上取整（＋0.5后四舍五入）
                tmp+= (num[i]%speed==0?(num[i]/speed):(num[i]/speed+1));
                System.out.println("第"+i+"个用时："+ (num[i]%speed==0?(num[i]/speed):(num[i]/speed+1))+"总时间："+tmp);
            }
            while(tmp>time){
                speed++;
                time=0;
                for(int i=0;i<num.length;i++){
                    tmp=tmp + num[i]%speed==0?(num[i]/speed):(num[i]/speed+1);
                }
            }

            System.out.println(speed);
        }

    }
}
