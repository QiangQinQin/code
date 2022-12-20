package huaWeiOd.String;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/12/18
 *
https://blog.csdn.net/misayaaaaa/article/details/127951051
给定一个字符串s，s包括以空格分隔的若干个单词，请对s进行如下处理后输出:
1、单词内部调整:对每个单词字母重新按字典序排序
2、单词间顺序调整:
    1)统计每个单词出现的次数，并按次数降序排列
    2)次数相同，按单词长度升序排列
    3）次数和单词长度均相同，按字典升序排列

请输出处理后的字符串，每个单词以一个空格分隔。

输入描述:
一行字符串，每个字符取值范围: 【a-zA-z0-9】以及空格，字符串长度范围: 【1，1000】

例1:
输入
This is an apple
输出
an is This aelpp

例2:
输入∶
My sister is in the house not in the yard
输出:
in in eht eht My is not adry ehosu eirsst
 */
public class True_Q4_rearrangeString {

//    ===========自己=================================
//    public static void main(String[] args) {
//          String input="This is an apple";
//
//          /*
//          treeset会去重，字典序 用优先级队列  或 Arrays.sort？？
//          * */
//
//        String[] words=input.split(" ");
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            if(map.containsKey(words[i])){
//                map.put(words[i],  map.get(words[i]+1));
//            }else{
//                map.put(words[i], 1);
//            }
//        }
//
//        Arrays.sort(words, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
////                1)统计每个单词出现的次数，并按次数降序排列
//                if(map.get(o1)!= map.get(o2)){
//                    return map.get(o2)-map.get(o1);
//                }
////                2)次数相同，按单词长度升序排列
//                else if(o1.length() != o2.length()){
//                    return   o1.length()-o2.length();
//                }
////                3）次数和单词长度均相同，按字典升序排列
//                else{
//                    for (int i = 0; i < o1.length(); i++) {
//                        if(o1.charAt(i)!=o2.charAt(i)){
//                            return  o1.charAt(i)-o2.charAt(2);
//                        }
//                    }
//                }
//                return 0;
//            }
//        });
//        System.out.println(Arrays.toString(words));
//    }

        public static void main(String[] args) {
            //处理输入
            Scanner in=new Scanner(System.in);
            String str = in.nextLine();
            String[] str1 = str.split(" ");

            /*
              第一步，单词内部调整
              将输入字符串中str1的每个单词   按照字典序排列其字母,处理完后放到 str_list
             */
            ArrayList<String> str_list = new ArrayList<String>();
            for (int i=0;i<str1.length;i++) {
                char[] chars = str1[i].toCharArray();
                Arrays.sort(chars); //对字符数组 排序
                str_list.add(String.valueOf(chars));
                //System.out.println(s);
            }

            /*
            第二步，单词间调整
              先统计每个单词出现的次数
              按 次数、长度、字典序排序
            */
//            先统计每个单词出现的次数
            HashMap<String, Integer> str_count = new HashMap<String, Integer>();
            for (int i=0;i<str_list.size();i++) {
                if(str_count.containsKey(str_list.get(i))) {
                    str_count.put(str_list.get(i), str_count.get(str_list.get(i)) + 1);
                } else {
                    str_count.put((str_list.get(i)), 1);
                }
            }

            // 按次数排序
            // 通过ArrayList构造函数把 str_count.entrySet()转换成list   ！！！ （用的是上面 用来统计次数的map）
            List<Map.Entry<String, Integer>> str_count_list = new ArrayList<Map.Entry<String, Integer>>(str_count.entrySet());
//            // 通过比较器实现比较排序
//            Collections.sort(str_count_list, new Comparator<Map.Entry<String, Integer>>() {
//                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
//                    // 按出现次数 降序
//                    if (a.getValue() > b.getValue()) {
//                        return -1;
//                    } else if(a.getValue() == b.getValue()) {
//                        // 次数相同时，先比长度
//                        if (a.getKey().length() > b.getKey().length()) {
//                            return 1;
//                        } else if (a.getKey().length() == b.getKey().length()) {
//                            // 长度还相同，比字典序！！！
//                            return a.getKey().compareTo(b.getKey());
//                        } else { // 比如 a.length <  b.length时
//                            return -1;
//                        }
//                    } else {
//                        return 1;
//                    }
//
//                }
//            });

            Collections.sort(str_count_list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
//                     1)统计每个单词出现的次数，并按次数降序排列
                        if(a.getValue()!= b.getValue()){
                            return  b.getValue()-a.getValue();
                        }
//                    2)次数相同，按单词长度升序排列
                        else if(a.getKey().length()!=b.getKey().length()){
                            return  a.getKey().length() -b.getKey().length();
                        }
//                    3）次数和单词长度均相同，按字典升序排列
                       else {
                           return a.getKey().compareTo(b.getKey());
                        }

                }
            });

            /*
            第三步： 打印
            注意输出 单词原有的个数
            * */
            String result="";
            for (int i=0;i<str_count_list.size();i++) {
                for (int j=0;j<str_count_list.get(i).getValue();j++) { // key拼接value次
                    result = result +str_count_list.get(i).getKey() + " ";
                }

            }
            System.out.println(result);
        }
}
