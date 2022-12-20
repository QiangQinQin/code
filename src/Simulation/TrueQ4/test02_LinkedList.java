package Simulation.TrueQ4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/28
求单项链表中间的节点值，如果奇数个节点取中间，偶数个取 偏右边的那个值

输入：
第一行 链表头节点地址  后续输入的节点数n
后续输入每行表示一个节点，格式：节点地址  节点值 下一个节点地址(-1表示空指针)
输入保证链表  不会出现环 并且 可能存在一些节点不属于链表

测试用例:
00010 4
00000 3 -1
00010 5 12309
11451 6 00000
12309 7 11451

5-》7-》6-》3-》null
输入:
6

难点： 如果将结点串成链表--》
1)::每个结点的next 都遍历其他所有结点的地址 来匹配？   双重for
 2)::  用map存放 结点地址 和 结点详情（value,next）
 */
class Node{
    int value;
    String next;
    Node(int value,String next){
        this.value=value;
        this.next=next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next='" + next + '\'' +
                '}';
    }
}
public class test02_LinkedList {
    public static void main(String[] args) {


        /*
        方法1： 模拟法
        * */
        Scanner sc = new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        String headAddress=line1[0];
        int n=Integer.parseInt(line1[1]);

        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] info=sc.nextLine().split(" ");
            Node node = new Node(Integer.parseInt(info[1]),info[2]);
            map.put(info[0],node);
        }
//        System.out.println(map);

        Node cur=map.get(headAddress);
//        System.out.println(cur);

        int index= (n%2==0)?(n/2+1):(n/2);
        for (int i = 1; i < index; i++) { // 从第一个结点 移动 index-1次 可到第index个结点
            cur=map.get(cur.next);//先拿到地址,然后根据地址拿结点
//            System.out.println(cur);
        }
        System.out.println(cur.value);


        /*
        方法2：
        不建立链表，用LinkedList存储值
           add(int index, E element) ;  插入到指定位置
           get(int index)  获取指定位置
        * */





    }

}
