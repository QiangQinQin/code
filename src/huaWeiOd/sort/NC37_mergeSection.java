package huaWeiOd.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/25
https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a?tpId=196&tqId=37071&ru=/exam/oj
描述
给出一组区间，请合并所有重叠的区间。
请保证合并后的区间按区间起点升序排列。

示例1
输入：
[[10,30],[20,60],[80,100],[150,180]]
返回值：
[[10,60],[80,100],[150,180]]

示例2
输入：
[[0,10],[10,20]]
返回值：
[[0,20]]

 1）入参怎么接受？  Arralist<Interval></>
 2）方案：
    先按起点 将所有区间排序
    如果重叠，则下一个区间的起点 <= 前一个区间的终点
 3)特殊入参
    输入[[1,4],[0,2],[3,5]]
    输出[[0,5]]
 */

//  Definition for an interval.
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

public class NC37_mergeSection {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        //先按起点，后按终点，由小到达排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start){
                    return o1.end-o2.end;
                }else{
                    return o1.start-o2.start;
                }
            }
        });

        // 特殊情况
        if(intervals.size()<=1){
            return intervals;
        }else{ // 多区间时，需判断 是否可和前一个区间合并
            res.add(intervals.get(0));
            for (int i = 1; i < intervals.size(); i++) {
                Interval cur=intervals.get(i);
                //当前区间 和 结果区间的最后一个 比上下限，能合并就扩大， 不重叠就添加至结果区间
                if(cur.start <= res.get(res.size()-1).end ){
                    Interval tmp = new Interval(0,0);
                    tmp.start=Math.min(intervals.get(i).start, res.get(res.size()-1).start);
                    tmp.end=Math.max(  intervals.get(i).end  ,   res.get(res.size()-1).end);
                    res.set(res.size()-1,tmp);
                }else{
                    res.add(cur);
                }
            }
        }

        return res;
    }

// //   ================官方========================
//    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//        ArrayList<Interval> res = new ArrayList<>();
//        //去除特殊情况
//        if (intervals.size() == 0)
//            return res;
//        //重载比较，按照区间首排序
//        Collections.sort(intervals, new Comparator<Interval>() {
//            public int compare(Interval o1, Interval o2) {
//                if (o1.start != o2.start)
//                    return o1.start - o2.start;
//                else
//                    return o1.end - o2.end;
//            }
//        });
//        //放入第一个区间
//        res.add(intervals.get(0));
//        int count = 0;
//        //遍历后续区间，查看是否与末尾有重叠
//        for (int i = 1; i < intervals.size(); i++) {
//            Interval o1 = intervals.get(i);
//            Interval origin = res.get(count);
//            if (o1.start > origin.end) {
//                res.add(o1);
//                count++;
//                //区间有重叠，更新结尾
//            } else {
//                res.remove(count);
//                Interval s = new Interval(origin.start, o1.end);
//                if (o1.end < origin.end)
//                    s.end = origin.end;
//                res.add(s);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(merge(new ArrayList<Interval>() {
                                     { //[[10,30],[20,60],[80,100],[150,180]]
                                         add(new Interval(10, 30));
                                         add(new Interval(20, 60));
                                         add(new Interval(80, 100));
                                         add(new Interval(150, 180));
//                                         add(new Interval(1, 4));
//                                         add(new Interval(0, 2));
//                                         add(new Interval(3, 5));
                                     }
                                 }
        ));
    }
}
