package huaWeiOd.tree;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/11/27

 I:
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树:[3,9,20,null,null,15,7],
    3
   / \
  9  20
     /  \
    15  7

返回：
[3,9,20,15,7]  （9的孩子为空，就不加入队列，不打印）


 II
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树:[3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]


剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
[3],
[20,9],
[15,7]
]

 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    // I
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();// 从队头移除
            ans.add(node.val);// 加入到 队尾
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    //************************自己******************************
//    public int[] levelOrder(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        if(root == null){
//            return null;
//        }else{
//            Stack<TreeNode> stack = new Stack<>();
//            stack.push(root);
//
//            while (!stack.isEmpty()){
//                TreeNode cur=stack.pop();
//                list.add(cur.val);
//                stack.push(cur.right);
//                stack.push(cur.left);
//            }
//        }
//
//        int[] ints = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ints[i]=list.get(i);
//        }
//        return  ints;
//    }

    // II  层次遍历  每层打印
//    *************自己**********************
//    public  List<List<Integer>> levelOrder2(TreeNode root) {
//        if(root == null) return new int[0];
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
//        List<List<Integer>> ans = new ArrayList<>();
//
//        while(!queue.isEmpty()) {
//            ArrayList<TreeNode> cur = new ArrayList<>();
//            TreeNode node = queue.poll();// 从队头移除
//            ans.add(cur);// 加入到 队尾
//            if(node.left != null) queue.add(node.left);
//            if(node.right != null) queue.add(node.right);
//        }
//
//        return ans;
//    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();// <>不需要传东西   List<List<Integer>> 记录每 层 的 值!!!

        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {//  处理完 当前层 所有([1,queue.size()]共size个); 每弹出一个，要加进来其子女,给下层准备
                TreeNode node = queue.poll();
                tmp.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            res.add(tmp);//变成List<List>
        }

        return res;
    }


    /*  非递归  */
    private List<List<Integer>> ret;//全局
    public List<List<Integer>> levelOrder2Nice(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }
    private void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (ret.size() == depth) { // 新建一个列表存放新的一层节点
            ret.add(new ArrayList<>());//list <list>
        }

        //调用是深度递归的,  分析时用层次法
        ret.get(depth).add(root.val);//即获得当前层的list(即二维数组的第i行),  然后往里加元素
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }


    // III 之字形遍历
    /* ****************     自己 ************** */
//    public List<List<Integer>> levelOrder3(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();// <>不需要传东西   List<List<Integer>> 记录每 层 的 值!!!
//
//        if (root != null)
//            queue.add(root);
//
//        int count = 1;
//        while (!queue.isEmpty()) {
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = queue.size(); i > 0; i--) {//  处理完 当前层 所有([1,queue.size()]共size个); 每弹出一个，要加进来其子女,给下层准备
//                TreeNode node;
//                if (count % 2 == 1) { // 根结点在 第一层，第二层就从左往右
//                    node = queue.removeFirst();
//                } else { // 第二层就从右往左
//                    node = queue.removeLast();
//                }
//
//
//                if (node.left != null)
//                    queue.addLast(node.left);
//                if (node.right != null)
//                    queue.addLast(node.right);
//                tmp.add(node.val);
//            }
//            count++;
//            res.add(tmp);//变成List<List>
//        }
//
//        return res;
//    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();//作为双端队列使用
        List<List<Integer>> res = new ArrayList<>();//默认为空列表

        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            // (存储当前层的打印结果！！！)  每一层,new一个, 二维数组多一行
            LinkedList<Integer> tmp = new LinkedList<>();

            for(int i = queue.size(); i > 0; i--) {//遍历的次数为  上一层的所有结点的数量,
                TreeNode node = queue.poll(); // 从头移除

                if(res.size() % 2 == 0)     // res.size()即res的元素个数  即  看已处理了 多少层。若之前为偶数层,则这层应 从左往右遍历,每次朝尾巴添加即可
                    tmp.addLast(node.val);
                else                        // 之前已处理了奇数层,当前层 将 从右往左遍历
                    tmp.addFirst(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            res.add(tmp);
        }

        return res;
    }

}
public class offer32_printBT {
}
