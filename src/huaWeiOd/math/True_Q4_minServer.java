package huaWeiOd.math;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/19



 类似NC37，合并区间？
 */

class task{
    int startTime;
    int endTime;
    int parallelism;

//     构造函数
    task(int startTime, int endTime, int parallelism){
        this.startTime=startTime;
        this.endTime=endTime;
        this.parallelism=parallelism;
    }

    @Override
    public String toString() {
        return "task{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", parallelism=" + parallelism +
                '}';
    }
}
public class True_Q4_minServer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int taskNum=sc.nextInt();
            ArrayList<task> arrayList = new ArrayList<>();
            for (int i = 0; i < taskNum; i++) {
                task  task=new task(sc.nextInt(),sc.nextInt(),sc.nextInt());
                arrayList.add(task);
            }
            System.out.println(arrayList);
            /*
            思路1：
        求所有重叠的区间段的起止位置 ???
        计算每个重叠区间所需要的服务器数
        取所需服务器数的最大值

        思路2：
         (先按起点，然后按终点先后排序；
         遍历所有区间， 发现区间有重叠的，先合并为 子区间  且 服务器数为二者和，并将区间添加到List里)
         特殊情况：  任务只有一个 或 两个  （拿基本分！！！）

         思路2：
         （暴力！！！）
         遍历第一个区间 和 其后所有区间的交集，并计算对应服务器数
         遍历第二个区间和 其后所有区间的交集
          。。。。

          遍历交集之间的交集
        * */
        }



    }
}
