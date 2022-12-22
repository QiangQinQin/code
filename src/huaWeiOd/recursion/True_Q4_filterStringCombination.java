package huaWeiOd.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/22
https://renjie.blog.csdn.net/article/details/128025836

题目
数字0、1、2、3、4、5、6、7、8、9分别关联a~z  26个英文字母。
0关联"a","b", "c"
1关联"d" ," e" ,"f"
2关联"g","h" ,"i"
3关联"j","k","l"
4关联"m","n","o"
5关联"p","q","r
"6关联"s","t"
7关联"u", "v"
8关联"w" ,"x"
9关联"y"","z"

示例:
输入:
78
ux
输出:uw vx vw
说明:
    ux完全包含屏蔽字符串ux，因此剔除
    7关联"u","v"，8关联"x","w"，
    输入一个字符串例如78",和一个屏蔽字符串"ux",
    那么"78"可以组成多个字符串例如:“ux",“tw"，“vx"，“vw”，
    过滤这些完全包含屏蔽字符串的每一个字符的字符串，然后输出剩下的字符串。
 */
public class True_Q4_filterStringCombination {
//    public static void main(String[] args) {
//
//        /*
//        疑惑：
//           输入数字只有2个吗？ 1234
//            前后顺序颠倒吗？ 比如UX 和 XU
//        * */
//        Scanner sc = new Scanner(System.in);
//        String nums=sc.nextLine();
//        String filter=sc.nextLine();
//
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(0,"abc");
//        map.put(1,"def");
//        map.put(2,"ghi");
//        map.put(3,"jkl");
//        map.put(4,"mno");
//        map.put(5,"pqr");
//        map.put(6,"st");
//        map.put(7,"uv");
//        map.put(8,"wx");
//        map.put(9,"yz");
//
//
//
//    }


    /*
      博主：
    * */
        public static ArrayList<String> res_str_list;

        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            String num_str = in.nextLine();
            String block_str = in.nextLine();
            //预设值（因为输入字符串的每一位  也是一个字符）
            HashMap<Character, String> num_char_map = new HashMap<Character, String>();
            num_char_map.put('0',"abc");
            num_char_map.put('1',"def");
            num_char_map.put('2',"ghi");
            num_char_map.put('3',"jkl");
            num_char_map.put('4',"mno");
            num_char_map.put('5',"pqr");
            num_char_map.put('6',"st");
            num_char_map.put('7',"uv");
            num_char_map.put('8',"wx");
            num_char_map.put('9',"yz");

            res_str_list = new ArrayList<String>();
            ArrayList<Character> char_list_temp = new ArrayList<Character>();
            dfs(num_str, char_list_temp, 0, num_char_map);

            int result_count = res_str_list.size();
            for (String s : res_str_list) {
                if(!s.equals(block_str)){
                    System.out.println(s);
                }

            }
        }

        // 递归求出所有可能的排列组合    78               存结果                递归深度                  数字和字符的映射关系
        // 即全排列  https://leetcode.cn/problems/permutation-i-lcci/
        public static void dfs(String num_str, ArrayList<Character> list, int index, HashMap<Character, String> num_char_map) {
            if(index == num_str.length()) {
                String temp_str = "";// 将 list的结果变成 String 并 放到结果集里
                for (int i=0;i<list.size();i++) {
                    temp_str = temp_str + list.get(i);
                }
                res_str_list.add(temp_str);
                return;
            }

            // 遍历 数字对应的每个字符
            for (char single_char : num_char_map.get(num_str.toCharArray()[index]).toCharArray()) {
                list.add(single_char);// 将当前字符 添加到 临时list里
                dfs(num_str, list, index+1, num_char_map);//递归处理下一个数字
                list.remove(list.size() - 1);
            }
        }

}
