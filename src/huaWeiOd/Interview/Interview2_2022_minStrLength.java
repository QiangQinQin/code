package huaWeiOd.Interview;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2023/1/11

ⅰ. https://leetcode.cn/problems/short-encoding-of-words/
ⅱ. https://leetcode.cn/problems/iSwD2y/
l
问题描述：
给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与  一个索引列表 A。
例如，如果这个列表是 [“same”, “me”, “bell”]，我们就可以将其表示为 S = “same#bell#” 和 indexes = [0, 2, 5]。
对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 “#” 结束，来恢复我们之前的单词列表。
那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
示例1：
输入： words = ["same", "me", "bell"]
输出：10
说明：S= "same#bell#"，indexes=[0,2,5]
示例2：
输入： words = ["bell", "me", "same", "bell"]
输出：10
说明：S= "bell#same#"，indexes=[0,7,5,0]
提示：
1.	 1 <= words.length <= 2000
2.	1 <= words[i].length < =7
3.	每个单词都是小写字母

https://leetcode.cn/problems/short-encoding-of-words/

67分钟
自我介绍
简历上有3个项目，讲一下背景  开发的功能  遇到的问题    pg驱动是什么？
SSM和SSH， H有什么不好？
索引的底层实现，哪些类型不适合建索引，索引失效
Springe AOP 代理模式有哪几种实现方式
springboot和cloud的关系和区别
云原生的理解
用到什么设计模式 ，都知道哪些？
麦克风有回声

假如这个项目不行  或者  不通过，要不要去非华为线？

手撕算法
理解题意
刚写完，还在debug吗？时间差不多了，你主要有两个问题
i+1;  endWith
 时间复杂度

 ====================================

未通过用例:
输入：
["time","me","bell"]
输出：
13  (因为 处理后为 bell   me  time)
预期结果：
10


 */


public class Interview2_2022_minStrLength {
//  //     自己
 //    public static Integer getMinLen(String[]  strs){
//        if(strs== null  ||  strs.length==0){
//            return 0;
//        }else{
//           TreeSet<String> set = new TreeSet<>();
//            // 单词去重
//            for (int i = 0; i < strs.length; i++) {
//                set.add(strs[i]);
//            }
//
//            // 按字典序和长度排序
//            ArrayList<String> list = new ArrayList<>(set);
//            Collections.sort(list, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    if(o1.length() != o2.length()){
//                        return  o2.length()-o1.length();
//                    }else{
//                        return o1.compareTo(o2);
//                    }
//                }
//
//            });
//
//            // 单词有contains关系
//            for (int i = 0; i < list.size(); i++) {
//                for (int j = i+1; j < list.size(); j++) {
//                    if(list.get(i).endsWith(list.get(j))){
//                        set.remove(list.get(j));
//                    }
//                }
//            }
//            // 每个单词末尾拼#
//            StringBuilder builder = new StringBuilder();
//            for (String s : set) {
//                builder.append(s+"#");
//            }
//            //统计长度
//            return  builder.length();
//        }
//
////        return length;
//
//    }


/*

https://leetcode.cn/problems/short-encoding-of-words/solution/dan-ci-de-ya-suo-bian-ma-by-leetcode-solution/
如果单词 X 是 Y 的后缀，那么单词 X 就不需要考虑了。如果 words 中同时有 "me" 和 "time"，我们就可以在不改变答案的情况下不考虑 "me"
因此，目标就是  保留所有不是其他单词后缀的单词，  最后的结果就是  这些单词长度加一的总和  ，
细节 看 动图
* */
    public int minimumLengthEncodingBySet(String[] words) {
        //1. 先把words去重后放到 good里
        Set<String> good = new HashSet<String>(Arrays.asList(words));

        // 2.从good中去除  后缀为words的
        for (String word: words) {
            //遍历 当前迭代变量的  后缀是否在集合中 （如good为 time  me  dell  el  de时 ， time的后缀 me  就在其中，可去掉 ）
            for (int k = 1; k < word.length(); ++k) {
                good.remove(word.substring(k));  //  remove不存在的元素 只是返回false
            }
        }

        // 3. 累加长度
        int ans = 0;
        for (String word: good) {
            ans += (word.length() + 1);// 因为每个单词编码后后面还需要跟一个 # 符号
        }
        return ans;
    }





    /*
            字典树 优化！！！   https://baike.baidu.com/item/%E5%AD%97%E5%85%B8%E6%A0%91/9825209?fr=aladdin
           下标对应，26个字符
？？？？
反序之后插入字典树中。例如，我们有 "time" 和 "me"，可以将 "emit" 和 "em" 插入字典树中。
然后，字典树的叶子节点（没有孩子的节点）就代表没有后缀的单词，
统计叶子节点代表的单词长度加一的和即为我们要的答案。

细节 看 动图

    * */
    public static int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode(); // 字典树的 根结点
        Map<TrieNode, Integer> nodes = new HashMap<TrieNode, Integer>();//存放所有单词对应的结点   并且和  单词下标对应

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) { // 反序  插入字典树中
                cur = cur.get(  word.charAt(j)  ); // 自定义的方法。 比如 time、me 当处理到 me时，从e开始找 ，发现有 e m  i t的字典树了，就 维护字典树并返回当前结点cur，然后从m找 发现有 m i t了，继续 维护字典树并返回当前结点cur
            }
            nodes.put(cur, i); //  和  单词下标对应
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0) {
                ans += words[  nodes.get(node)  ].length() + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
//        System.out.println(getMinLen(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }




}

class TrieNode {
    TrieNode[] children;
    int count; // 即该子节点的长度
   // 构造函数
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }

    // 插入 和 获取结点
    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {  // 26个字母对应0-25的下标
            children[c - 'a'] = new TrieNode();
            count++; // 即该子节点的长度
        }
        return children[c - 'a'];
    }
}


