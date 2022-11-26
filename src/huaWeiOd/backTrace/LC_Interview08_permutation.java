package huaWeiOd.backTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2022/11/18

面试题 08.07. 无重复字符串的排列组合
https://leetcode.cn/problems/permutation-i-lcci/
无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 示例1:
  输入：S = "qwe"
  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]

 示例2:
  输入：S = "ab"
  输出：["ab", "ba"]

面试题 08.08. 有重复字符串的排列组合
https://leetcode.cn/problems/permutation-ii-lcci/
有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

示例1:
输入：S = "qqe"
输出：["eqq","qeq","qqe"]

示例2:
输入：S = "ab"
输出：["ab", "ba"]

提示:
字符都是英文字母。
字符串长度在[1, 9]之间。

 */
/******************************************无重复字母***************************************************/
class Solution {
    List<String> permutations = new ArrayList<String>();//全局变量，存放结果
    char[] temp;//存储当前排列
    int n;//字符个数

    public String[] permutation(String s) {
        temp = s.toCharArray();
        n = s.length();
        backtrack(0);
        return permutations.toArray(new String[permutations.size()]); // list转数组 ，如  ["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
    }

    //回溯
    public void backtrack(int index) { //index是当前 递归 初始下标位置 ；i 是要交换位置的 元素下标
        if (index == n) {
            permutations.add(new String(temp));// qwe--> qwe
        } else {
            for (int i = index; i < n; i++) {// 注意 i 从index开始
                swap(temp, index, i);// 将i号元素 固定到index   位置
                backtrack(index + 1); // 递归调
                swap(temp, index, i);// 还原 i  index元素原本的位置
            }
        }
    }

    public void swap(char[] temp, int index1, int index2) {
        char c = temp[index1];
        temp[index1] = temp[index2];
        temp[index2] = c;
    }
}

/******************************************有重复***************************************************/
// ---------------------自己----------------------------------------
//class Solution2 {
//    List<String> permutations = new ArrayList<String>();//全局变量，存放结果
//    char[] temp;//存储当前排列
//    int n;//字符个数
//
//    public String[] permutation(String s) {
//        temp = s.toCharArray();
//        n = s.length();
//        backtrack(0);
//        return permutations.toArray(new String[permutations.size()]); // list转数组 ，如  ["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
//    }
//
//    public void backtrack(int index) {
//        if (index == n) {
//            permutations.add(new String(temp));
//        } else {
//            for (int i = index; i < n; i++) {//index是当前 递归 初始下标位置 ；i 是要交换位置的 元素下标
//                if(temp[index]!=temp[i]){ // 不重复  或 重复且但之前未访问  才有必要交换位置，否则 直接看下个元素（如qqe 的 qq就不用换）；但这样的写法有问题：如 vqv 中两个v没连； qqe中的index不加，i一直加
//                    swap(temp, index, i);// 将index号元素 固定到i位置
//                    backtrack(index + 1); // 递归调
//                    swap(temp, index, i);// 还原 i  index元素原本的位置
//                }
//            }
//        }
//    }
//
//    public void swap(char[] temp, int index1, int index2) {
//
//        char c = temp[index1];
//        temp[index1] = temp[index2];
//        temp[index2] = c;
//    }
//
//----------------------------有重复字符（用set去重）--------------------------------------------------
class Solution2 {
    HashSet<String> set =new HashSet<String>();

    List<String> permutations = new ArrayList<String>();//全局变量，存放结果
    char[] temp;//存储当前排列
    int n;//字符个数

    public String[] permutation(String s) {
        temp = s.toCharArray();
        n = s.length();
        backtrack(0);
        Arrays.sort(set.toArray());
        System.out.println("set"+set);
        return permutations.toArray(new String[permutations.size()]);
    }

    //回溯
    public void backtrack(int index) { //index是当前 递归 初始下标位置 ；i 是要交换位置的 元素下标
        if (index == n) {
            set.add(new String(temp));
            permutations.add(new String(temp));// qwe--> qwe
        } else {
            for (int i = index; i < n; i++) {// 注意 i 从index开始
                swap(temp, index, i);// 将i号元素 固定到index   位置
                backtrack(index + 1); // 递归调
                swap(temp, index, i);// 还原 i  index元素原本的位置
            }
        }
    }

    public void swap(char[] temp, int index1, int index2) {
        char c = temp[index1];
        temp[index1] = temp[index2];
        temp[index2] = c;
    }
}


class Solution3 {
    List<String> permutations = new ArrayList<String>();
    StringBuffer temp = new StringBuffer();//暂存 序列
    char[] arr;
    int n;
    boolean[] visited;

    public String[] permutation(String s) {
        arr = s.toCharArray();
        Arrays.sort(arr);//排序！！！，让重复的相连
        this.n = s.length();
        this.visited = new boolean[n];

        backtrack(0);
        return permutations.toArray(new String[permutations.size()]);
    }

    public void backtrack(int index) {
        if (index == n) {
            permutations.add(temp.toString());
        } else {
            for (int i = 0; i < n; i++) {// 从0开始！！！
                if (visited[i] ||   (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])    ) { // 当前字符已加入过当前排列  或 该字符和前个相同，且前个还没访问过（如qqe的第一个q为false时） 都不能将i位置元素加入当前排列；  （注意i>0 ,才能保证i-1>0）
                    continue;
                }

                temp.append(arr[i]);//准备排列该字符，所以 加入，并设置 排列标志    第几层backtrack(int index)，就append到第几个下标
                visited[i] = true;

                backtrack(index + 1);

                temp.deleteCharAt(index);//deleteCharAt删除字符  恢复原样
                visited[i] = false;
            }
        }
    }
}





public class LC_Interview08_permutation {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        char[] chars = str.toCharArray();

        // 无重复
        System.out.println(Arrays.toString(new Solution().permutation("qwe")));;
        // 有重复
        System.out.println(Arrays.toString(new Solution3().permutation("qqe")));;

    }
}
