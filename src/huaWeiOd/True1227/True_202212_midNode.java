package huaWeiOd.True1227;

import java.util.HashMap;
import java.util.Scanner;

/**
  @author QiangQin
   @date 2022/12/27

   https://www.yuque.com/g/qiangqin/aw0bfu/ne0f7g/collaborator/join?token=N4DFdRFi1RrPay4q# 《04. 笔试记录》
00100 4
00000 4 -1
00100 1 12309
33218 3 00000
12309 2 33218

链表结构
  1 2 3 4
输出
    3
 要点：
  不成环
  可能有多余结点
  若有两个中间结点，输出第二个

 66.67
 */
class Node {
    int value;
    int next;

    Node(int value, int next) {
        this.value = value;
        this.next = next;
    }
}

public class True_202212_midNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str1s = str1.split(" ");
        int headAddress = Integer.parseInt(str1s[0]);
        int n = Integer.parseInt(str1s[1]);


        HashMap<Integer, Node> map = new HashMap<>(); // key为当前地址  value是结点
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            map.put(Integer.parseInt(tmp[0]), new Node(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
        }
        if (n == 1) {
            System.out.println(map.get(headAddress).value);
        } else {
            Node head = map.get(headAddress);
            int count = 1;//统计有效结点个数
            Node cur = head;
            while (cur.next != -1) {
                cur = map.get(cur.next);
                count++;
            }

            /*
            4个 0 1 2 3 找 2
            3个  0 1 2 找1
            * */
            // 3个结点找 2  4找第3个 0123
            int index = count/2 ;
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = map.get(cur.next);
            }

            System.out.println(cur.value);
        }

    }
}
