package Simulation;

import java.util.Scanner;

public class XiaoMi_9_20_PassWd {

    static class Node {
        int i;
        boolean set;
        Node prev;

        public Node(int i, boolean set, Node prev) {
            this.i = i;
            this.set = set;
            this.prev = prev;
        }
    }


    // 布尔数组 实现 优先队列
    static class PriorityQueue {
        private final boolean[] active;
        private int max;

        //  [0...upperBound]  共 upperBound+1个
        public PriorityQueue(int upperBound) {
            active = new boolean[upperBound + 1];
            active[0] = true;
            max = 0;
        }

        public void add(int i) {
            active[i] = true;
            if (i > max)
                max = i;
        }

        public void remove(int i) {
            active[i] = false;
            if (max == i)
                while (!active[max]) max--;
        }

        public int peek() {
            return max;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n个槽
        int m = sc.nextInt(); // m轮

        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            nodes[l] = new Node(i, true, nodes[l]);
            nodes[r + 1] = new Node(i, false, nodes[r + 1]);
        }

        long res = 0;
        PriorityQueue pq = new PriorityQueue(m);
        for (int index = 0; index < n; index++) {
            Node node = nodes[index];
            while (node != null) {
                if (node.set) {
                    pq.add(node.i);
                } else {
                    pq.remove(node.i);
                }
                node = node.prev;
            }
            int a_i = pq.peek();
            res = (res + (long) index * a_i) % 100000009L;
        }
        System.out.println(res);
    }
}