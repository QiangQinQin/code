import java.util.*;
class LRUCache {
    class Node {
        int k, v; // key  value
        Node l, r;// 上一个结点   下一个结点
        Node(int _k, int _v) {
            k = _k;
            v = _v;
        }
    }


    int n;////缓存的大小超过 n 时，移除最不经常使用的记录。
    Node head, tail; // 哨兵结点
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        n = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }


    //某个key的set或get操作一旦发生，认为这个key的记录成了 最常使用的 ，然后都会刷新缓存。
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
            return node.v;
        }
        return -1;// 规定 若key未出现过或已被移除，则返回-1
    }


    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {//有该key,就不能重复插入
            node = map.get(key);
            node.v = value;
        } else {
            if (map.size() == n) {   //缓存的大小超过 K 时， 移除 最不经常使用的记录
                Node del = tail.l;
                map.remove(del.k);
                delete(del);
            }

            node = new Node(key, value);
            map.put(key, node);//  保存到map里
        }

        refresh(node); // 移动到头部，即建立起  node的前后关系
    }

    // 插入新结点 和 访问结点 都要调用refresh 操作。分两步：
    // 1. 先将当前节点从双向链表中删除（如果该节点本身存在于双向链表中的话）
    // 2. 将当前节点添加到双向链表头部
    void refresh(Node node) {
        delete(node);
        node.r = head.r;
        node.l = head;
        head.r.l = node;
        head.r = node;
    }

    // delete 操作：将当前节点从双向链表中移除
    // 由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.l 不为空，则代表了 node 本身存在于双向链表（不是新节点）
    void delete(Node node) {
        if (node.l != null) {
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }
    }
}

public class LRU {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        List<Integer> list = new ArrayList<>();
        LRUCache lru = new LRUCache(k);

        for (int[] op : operators) {
            int type = op[0];
            if (type == 1) {
                // set(k,v) 操作
                lru.put(op[1], op[2]);
            } else {
                // get(k) 操作
                list.add(lru.get(op[1]));
            }
        }

        // list  转 int数组
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = list.get(i);

        return ans;
    }
}