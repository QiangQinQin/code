package huaWeiOd.String;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/12/20
https://renjie.blog.csdn.net/article/details/128052253

题目
在一行中输入一个字符串数组，
如果其中一个字符串的 所有 以索引0开头的子串 在数组中都有，那么这个字符串就是潜在密码，
在所有潜在密码中最长的是真正的密码，
如果有多个长度相同的真正的密码，那么取字典序Q最大的为唯一的真正的密码，

求唯一的真正的密码。
示例1:
输入: h he hel hell hello o ok n ni nin ninj ninja
输出: ninja
说明:
  按要求,，hello、ok、 ninja都是潜在密码。 因为 h he  hel hell hello o ok n ni nin  ninj ninja在输入串的元素中 都能找到。 并且  不是在某个串中 部分包含，而是 两串就相等
  检查长度，hello、ninja是真正的密码。
  检查字典序，ninja是唯一真正密码。

示例2:
输入∶a b c d f
输出:f
说明:按要求, a b c d f都是潜在密码。检查长度,a bcd f是真正的密码。检查字典序，f是唯一真正密码。
 */
public class True_Q4_realPassWOrd {
    public static void main(String[] args) {
/*
自己思路：
   先找到潜在密码
      hashset存放输入串的每个元素，便于快速找到 某个子串有没有出现过
   然后找最大长度
   再找字典序最大的串
* */
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        HashSet<String> set = new HashSet<String>(Arrays.asList(strs)); // 数组==》List ==》 set

        ArrayList<String> arrayList = new ArrayList<>();
        //
        for (String s : set) {
            boolean isContain=true;
            for (int i = 1; i <= s.length(); i++) { // subString不含右边界，所以不会越界
                if(!set.contains( s.substring(0,i) )){
                    isContain=false;
                    break;
                }
            }
            if(isContain){
                arrayList.add(s);
            }
        }


        int maxLen=0;
        for (String s : arrayList) {
            if(s.length() >maxLen){
                maxLen=s.length();
            }
        }

        TreeSet treeSet = new TreeSet<>();
        for (String s : arrayList) {
            if(s.length()==maxLen){
                treeSet.add(s);
            }
        }
        System.out.println(treeSet.toArray()[treeSet.size()-1]); //字典序的最大

    }
}



/*
class Main {
    public static int min_times;
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");

        // 将所有字符串放入哈希集合
        HashSet<String> word_set=new HashSet<>();
        for (String s : strs) {
            word_set.add(s);
        }

        // 真正的密码
        String true_pass_word="";

        //按顺序检查每一个词
        for (String s : strs) {
            // 条件1：检查这个词所有以索引0开头的子串在数组中是否都有
            boolean flag=true;
            for(int i=1;i<s.length();i++){
                // 以索引0开头的子串
                String sub_str=s.substring(0,i);
                if(!word_set.contains(sub_str)){
                    flag=false;
                    break;
                }
            }

            // 如果是潜在密码，就 和目前最优解比一比。  if里只列举了 要更新 真密码的情况
            if(flag){
                // 条件2：比较密码长度
                if(s.length()>true_pass_word.length())
                    true_pass_word=s;
                // 条件3：比较密码字典排序
                if(s.length()==true_pass_word.length()&&s.compareTo(true_pass_word)>0){
                    true_pass_word=s;
                }
            }
        }

        System.out.println(true_pass_word);
    }
}
*/
