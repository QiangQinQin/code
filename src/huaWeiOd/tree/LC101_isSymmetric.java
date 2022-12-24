package huaWeiOd.tree;

/**
 * @author QiangQin
 * * @date 2022/12/23

https://leetcode.cn/problems/symmetric-tree/
给你一个二叉树的根节点 root ， 检查它是否轴对称。


能观察到镜像对称是 这么一个规律：
● 左子树 2 的左孩子 == 右子树 2 的右孩子
● 左子树 2 的右孩子 == 右子树 2 的左孩子

比如看下面这两个子树(他们分别是根节点的左子树和右子树)，
    2         2
   / \       / \
  3   4     4   3
 / \ / \   / \ / \
8  7 6  5 5  6 7  8


链接：https://leetcode.cn/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/

 */


import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class LC101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return  true;
            }
             return  check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }else if((left==null && right!=null)  ||  (left!=null && right==null)){
            return false;
        }else if(left.val!= right.val){
            return  false;
        }else{
            return check(left.left,right.right) && check(left.right,right.left);
        }


    }



    public boolean isSymmetricNice(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) {
            return true;
        }
        //用队列保存节点
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点的左右孩子放到队列中
        queue.add(root.left);
        queue.add(root.right);

        while(queue.size()>0) {
            //从队列中取出两个节点，再比较这两个节点
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();

            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if(left==null && right==null) {
                continue;
            }
            if(left==null || right==null) {
                return false;
            }

            if(left.val!=right.val) {
                return false;
            }
            //将左节点的左孩子， 右节点的右孩子放入队列
            queue.add(left.left);
            queue.add(right.right);

            //将左节点的右孩子，右节点的左孩子放入队列
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
