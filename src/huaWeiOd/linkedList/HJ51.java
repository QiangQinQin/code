package huaWeiOd.linkedList;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/13
 */
//class Node{
//    int value;
//    Node next;
//
//    Node(){
//        this.value=0;
//        Node next=null;
//    };
//    Node(int value,Node next){
//        this.value=value;
//        this.next=next;
//    }
//
//    void add(Node e){
//
//    }
//}
//
//public class HJ51 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n =Integer.valueOf(in.nextLine());
//
//        Node head=new Node(1,null);
//        String[]  strs=in.nextLine().split(" ");
//        int[] values=new int[strs.length];
//        for (int i = 0; i < strs.length; i++) {
//            values[i]=Integer.parseInt(strs[i]);
//        }
//
//        int k=Integer.valueOf(in.nextLine());
//
//        // 先建表
//
//        // 然后从前往后第 n-(k-1)个，  也就是 倒数第k个
//        // 注意 hasNext 和 hasNextLine 的区别
//
//    }
//}


import java.util.Scanner;

class ListNode {
    ListNode next;
    int val;

    ListNode(int val) { //只传value
        this.val = val;
        next = null; //默认为null
    }
}

public class HJ51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意有多组输入
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.next());           // 第一个输入

            ListNode head = new ListNode(-1); // 头指针（-1不在有效value范围内）
            ListNode temp = head;   //  ①
            //生成链表
            for (int i = 0; i < n; i++) {
                ListNode node = new ListNode(sc.nextInt());   // 第二行的 所有输入
                temp.next = node; // ②
                temp = temp.next; // ③x
            }

            int k = Integer.parseInt(sc.next());   //第三行的输入

            ListNode res = getKthFromEnd(head.next, k);
            if (res != null) {
                System.out.println(res.val);
            } else {
                System.out.println(res);
            }
        }
    }

//    public static ListNode getKthFromEnd(ListNode head, int k) {
//        int n = 0;
//        ListNode node = null; // 保存结果结点
//        //因为node结点没有size属性； 所以需先记录有多少节点
//        for (node = head; node != null; node = node.next) {
//            n++;
//        }
//
//        // node重新指向头结点
//        node = head;
//
//        //找倒数第k个，即正数  n  n-1 .。。  n-k+1 个
//        for (int i=1; i< n-k+1; i++) {
//            node = node.next;
//        }
//
//        return node;
//    }

//    快慢指针
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= k; i++) {
            if(fast==null){return fast;} // 对应共4个，要返回倒数第5个的情况
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

