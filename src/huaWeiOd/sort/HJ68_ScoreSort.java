package huaWeiOd.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/26
 *
https://www.nowcoder.com/practice/8e400fd9905747e4acc2aeed7240978b?tpId=37&tqId=21291&ru=/exam/oj
描述
给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩

都按先录入排列在前的规则处理。

例示：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高
smith     67
jack      70
Tom       70
peter     96

注：0代表从高到低，1代表从低到高

输入描述：
第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开

输出描述：
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

示例1
输入：
3
0
fang 90
yang 50
ning 70

输出：
fang 90
ning 70
yang 50
 */
class Student{
  String name;
  int score;
  int index; //即输入的序号

  Student(String name,int score,int index){
      this.name=name;
      this.score=score;
      this.index=index;
  }

    @Override
    public String toString() {
         return name + " " + score ;
    }
}

public class HJ68_ScoreSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int order=Integer.parseInt(sc.nextLine());
        Student[] stus =new Student[n];//开辟空间，内容为空
        for (int i = 0; i < n; i++) {
            String[] ins=sc.nextLine().split(" ");
            stus[i]=new Student(ins[0],Integer.parseInt(ins[1]),i);
        }

        Arrays.sort(stus, new Comparator<Student>() {
            /*
            0代表从高到低，1代表从低到高
            成绩从高到低或从低到高排列,
            相同成绩都按先录入排列在前
            * */
            @Override
            public int compare(Student o1, Student o2) {
                if(order==1){
                    if(o1.score !=o2.score){
                        return o1.score-o2.score;
                    }
                }else{ //即order==0
                    if(o1.score !=o2.score){
                        return o2.score-o1.score;
                    }
                }

                return  o1.index-o2.index;
            }
        });

        for (int i = 0; i < stus.length; i++) {
            System.out.println(stus[i].name+" "+stus[i].score);
        }

////        用流操作并打印！！！
//        Arrays.stream(stus).sorted(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                if(order==1){
//                    if(o1.score !=o2.score){
//                        return o1.score-o2.score;
//                    }
//                }else{ //即order==0
//                    if(o1.score !=o2.score){
//                        return o2.score-o1.score;
//                    }
//                }
//
//                return  o1.index-o2.index;
//            }
//        }).forEach(System.out::println);
    }
}
