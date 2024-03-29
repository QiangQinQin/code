package huaWeiOd.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/8
https://www.nowcoder.com/practice/f96cd47e812842269058d483a11ced4f?tpId=37&tqId=21271&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
链表的值  不能重复。

数据范围：链表长度满足 1≤n≤1000  ，节点中的值满足 0≤val≤10000
测试用例保证输入合法

输入描述：
输入一行，有以下4个部分：
1 输入链表结点个数
2 输入头结点的值
3 按照格式插入各个结点
4 输入要删除的结点的值

输出描述：
输出一行
输出删除结点后的序列，每个数后都要加空格

示例1
输入：
5 2 3 2 4 3 5 2 1 4 3
输出：
2 5 4 1
说明：
形成的链表为2->5->3->4->1
删掉节点3，返回的就是2->5->4->1


示例2
输入：
6 2 1 2 3 2 5 1 4 5 7 2 2
输出：
7 3 1 5 4
说明：
则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示  第2个节点值后面  插入  第1个节点值，为以下表示:
1 2 表示为 （1插入到2后面）
2->1
链表为2->1

3 2表示为
2->3
链表为2->3->1

5 1表示为
1->5
链表为2->3->1->5

4 5表示为
5->4
链表为2->3->1->5->4

7 2表示为
2->7
链表为2->7->3->1->5->4

最后的链表的顺序为 2 7 3 1 5 4

最后一个参数为2，表示要删掉节点为2的值
删除 结点 2

则结果为 7 3 1 5 4

 */

class Node{
    int value;
    Node next;
    Node(int  value){
        this.value=value;
        this.next=null;
    }
}




public class HJ48_deleteSpecificNode {
    public static void main(String[] args) {
/*
方法一：直接法
* */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            HashMap<Integer, Node> map = new HashMap<>();
            int n=sc.nextInt();
            int headValue=sc.nextInt();
            Node head=new Node(headValue);
            map.put(headValue,head);

//            0...n-2共n-1个
            for (int i = 0; i < n-1; i++) {
                int firtValue=sc.nextInt();
                Node first=new Node(firtValue);
                map.put(firtValue,first);
                Node second=map.get(sc.nextInt());
                addNode(first,second);
            }

            int delValue=sc.nextInt();
            head=delValue(delValue,head);
            printNode(head);
        }



           /*
方法二：借助ArrayList来模拟链表
具体方法
  比如两个数字A B，需要将A插入到B的后面，可以使用linkedlist.indexOf(pre)，找到B所在的位置，在其后面一个位置放入A即可。
linkedlist.add(linkedlist.indexOf(B) + 1, A);
最后删除的时候通过linkedlist.remove(linkedlist.indexOf(remove));即可删除。
        * */
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int head = sc.nextInt();
//            List<Integer> linkedlist = new ArrayList<>();
//
//            // 插入结点
//            linkedlist.add(head);
//            //  其实nextInt了  2*n次
//            for (int i = 0; i < n - 1; i ++) {
//                int next = sc.nextInt();
//                int pre = sc.nextInt();
//                linkedlist.add(linkedlist.indexOf(pre) + 1, next); // Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
//            }
//
//            //  删除结点
//            int remove = sc.nextInt();
//            linkedlist.remove(linkedlist.indexOf(remove));// Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
//            for (int i : linkedlist) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

    private static void printNode(Node head) {
        Node cur=head;
        while (cur!=null){
            System.out.print(cur.value + " ");
            cur=cur.next;
        }
    }

//    在第二个结点后面插入第一个结点
    private static void addNode(Node first, Node second) {
        first.next=second.next;
        second.next=first;
    }

// 先找到待删除结点   然后 删除；  如果是头节点？或只有一个结点？
    private static Node delValue(int delValue, Node head) {
        Node cur=head;
        Node pre=head;
        while(cur.value!= delValue){
            pre=cur;
            cur=cur.next;
        }

        //删除结点
        if(cur==head){
            head=cur.next;
            cur=null;
        }else{
            pre.next=cur.next;
            cur=null;
        }
        return head;
    }
}
