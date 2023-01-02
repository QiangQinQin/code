package huaWeiOd.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/26
 * <p>

 https://renjie.blog.csdn.net/article/details/128245208
箱子之字形摆放
题目
有一批箱子(形式为字符串Q，设为str) ,
要求将这批箱子按从上到下以之字形的顺序摆放在宽度为n的空地，请输出箱子的摆放位置。
例如:箱子ABCDEFG，空地宽度为3，摆放结果如图:
则输出结果为:
AFG
BE
CD

输入描述
输入一行字符串，通过空格分隔，前面部分为字母或数字组成的字符串str，表示箱子;
后面部分为数字n，表示空地的宽度。例如:
ABCDEFG 3

备注:
.请不要再最后一行输出额外的空行
.str只包含字母和数字，1<= len(str)<= 1000
.1<= n <= 1000


 ABCDEFG 3
 */
public class True_Q4_placeBox {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] strs = sc.nextLine().split(" ");
//        String boxStr = strs[0];
//        int wide = Integer.parseInt(strs[1]);
//
//        // 自己-- 数学规律--需要画图
//        ArrayList<ArrayList> list = new ArrayList<>();
//        for (int i = 0; i < wide; i++) {
//            list.add(new ArrayList()); // 动态二位数组!!!
//        }
//        for (int i = 0; i < boxStr.length(); i++) {
//            if ((i / wide) % 2 == 0) { //偶数从上往下
//                list.get(i % wide).add(boxStr.charAt(i));
//            } else {
//                list.get(wide - i % wide - 1).add(boxStr.charAt(i));
//            }
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) { // 注意是i的size
//                System.out.print(list.get(i).get(j));
//            }
//            System.out.println();
//        }


/*
思路
1:可以设置一个大小为n的数组，这样需要做的就变成了怎么把对应的字母放到指定的数组中去。
2∶设置一个flag变量，这样的话就可以控制在转弯的时候放到哪个数组中去了。
        * */
                // 处理输入
                Scanner in = new Scanner(System.in);
                String input_str = in.nextLine();
                String[] split = input_str.split(" ");
                String str = split[0];
                int n = Integer.parseInt(split[1]);

                // 将n行格子看作是n个数组
                List<List<Character>> lists = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    lists.add(new ArrayList<>());
                }
                int index = 0;
                // 控制下一个字符归属到哪个数组
                boolean flag = true;

                char[] chars = str.toCharArray();
                for (char c : chars) {
                    if (index == -1) {
                        index = 0;
                        flag = true;
                    }
                    if (index == n) { // 当从上往下把宽度填满时，则开始由下往上填
                        index = n - 1;
                        flag = false;// 表示 从下往上填
                    }
                    lists.get(index).add(c);// 给一维数组中的某个元素 对应的list再添加元素

                    if (flag) {
                        index++;
                    } else {
                        index--;// 0-->-1 说明要 从上往下填了
                    }
                }

// 简洁的写法！！！！
                for (List<Character> list : lists) {
                    for (Character c : list) {
                        System.out.print(c);
                    }
                    System.out.println();
                }
            }
}
