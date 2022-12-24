package huaWeiOd.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/24
https://renjie.blog.csdn.net/article/details/128402292?spm=1001.2014.3001.5502

题目描述:
去除文本多余空格，但不去除配对单引号之间的多余空格。
给出关键词的起始和结束下标，去除多余空格后刷新关键词的起始和结束下标。

输入描述:
输入为两行字符串:
第一行:待去除多余空格的文本，用例保证如果有单引号，则单引号成对出现，且单引号可能有多对.
第二行:关键词的开始和结束坐标，关键词间以逗号区分，关键词内的开始和结束位置以单空格区分

例如:
Life is painting a  picture, not doing 'a sum'8 15,20 26,43 45
关键单词为: painting picture sum
输出描述:
输出为两行字符串:
第—行:去除多余空格后的文本
第二行:去除多余空格后的关键词的坐标开始和结束位置，为数组方式输出
例如:
Life is painting a picture, not doing 'a sum'[8,15][19,25][42,44]

条件约束:
    1，不考虑关键词起始和结束位置为空格的场景
    2，单词的的开始和结束下标保证涵盖一个完整的单词，即一个坐标对开始和结束下标之间不会有多余的空格:3，如果有单引号，则用例保证单引号成对出现:
    4，关键词可能会重复:
    5，文本字符长度length取值范围:[0,100000]:
示例1
输入
Life is painting a picture, not doing 'a sum'(a和picture之间有两个空格)
8 15,20 26,43 45
输出:
Life is painting a  picture, not doing 'a sum'[8,15][19,25][42,44]
说明:
a和picture中间多余的空格进行删除

示例2
输入:
Life is painting a  picture, not doing 'a sum'8 15,19 25,42 44
输出
Life is painting a picture, not doing 'a sum'[8,15]19,25][42,44]
说明:
a和sum之间有多余的空格，但是因为有成对单引号，不去除多余空格

 难点：
  输入输出格式的处理
 多余空格的去除
 新坐标的获取

Life is painting a  picture, not doing 'a sum'
8 15,20 26,43 45


 */
public class True_deleteMoreSpace {
    public static void main(String[] args) {
        /*   自己 */
//        Scanner sc = new Scanner(System.in);
//        String text = sc.nextLine(); // Life is painting a  picture, not doing 'a sum'
//        String[]  pos=sc.nextLine().split(","); //对应输入为 8 15,20 26,43 45
//        int[][] indexs = new int[pos.length][2];
//        for (int i = 0; i < pos.length; i++) {
//            String[] index=pos[i].split(" ");
//            indexs[i][0]=Integer.parseInt( index[0]);
//            indexs[i][1]=Integer.parseInt( index[1]);
//        }
//
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < text.length(); i++) {
//            char ch=text.charAt(i);
//            if(ch != ' '){
//                builder.append(ch);
//            }else if(ch == ' ' &&  builder.charAt(builder.length()-1)!=' '){
//                builder.append(' ');
//            }else if(ch=='\''){
//                builder.append(ch);
//                i++;
//                while(i<text.length() ){
//                    char tmp=text.charAt(i);
//                    if(tmp !='\''){  // '之间保持原样，不去除多余空格
//                        builder.append(tmp);
//                    }else if(tmp =='\''){
//                        builder.append(ch);
//                        break;
//                    }
//                    i++;
//                }
//                i--; // 因为上面 while里多了一次i++
//            }
//        }
//
//        String res=builder.toString();
//        for (int i = 0; i < indexs.length; i++) {
//            int tmpStart=indexs[i][0];
//            indexs[i][0]=res.indexOf(text.substring(indexs[i][0],indexs[i][1]+1));//要包含下边界  且 开始和结束之间覆盖一个完整单词，没有多余空格
//            indexs[i][1]=indexs[i][0]+(indexs[i][1]-tmpStart);//加 单词长度
//        }
//
//        for (int i = 0; i < indexs.length; i++) {
//            System.out.print("["+indexs[i][0]+","+indexs[i][1]+"]");
//        }

//todo 理解博主
                Scanner in = new Scanner(System.in);
                String input_str = in.nextLine();
                String[] keywords = in.nextLine().split(",");

                List<int[]> coords = new ArrayList<>(); // list的每个元素是一个int数组
                int count = 0;  //空格个数

                for(String keyword : keywords){
                    String[] keyword_coord = keyword.split(" ");
                    int start = Integer.parseInt(keyword_coord[0]);
                    int end = Integer.parseInt(keyword_coord[1]);
                    int left_space_count = 0;
                    int right_space_count = 0;
                    int[] coord = new int[2];
                    if(!check(start, input_str)){
                        left_space_count = left_space_count(start, input_str);
                        right_space_count = right_space_count(end, input_str);
                    }

                    coord[0] = start - count - left_space_count;
                    coord[1] = end - count - left_space_count;
                    count += left_space_count + right_space_count;    //记录 总共去除的空格数
                    coords.add(coord);
                }

                String res = "";
                for(int[] coord : coords){
                    res += coord[0] + " " + coord[1] + ",";
                }

                System.out.println(res.substring(0, res.length()-1));
            }
// 统计 单词左侧 多余空格数？
            public static int left_space_count(int index, String input_str){
                int count = 0;
                if(index == 0){
                    return count;
                }else {
                    while (true){
                        index --;
                        if(index >= 0 && input_str.charAt(index) == ' '){
                            count ++;
                        }else {
                            break;
                        }
                    }
                }
                return count > 1 ? count - 1 : 0;   //空格数小于等于1时，多余空格数为0
            }

            public static int right_space_count(int index, String input_str){
                int count = 0;
                if(index == 0){
                    return count;
                }else {
                    while (true){
                        index ++;
                        if(index < input_str.length() && input_str.charAt(index) == ' '){
                            count ++;
                        }else {
                            break;
                        }
                    }
                }
                return count > 1 ? count - 1 : 0;
            }

            public static boolean check(int start ,String input_str){
                String str1 = input_str.substring( 0, start);
                int count = 0;
                //判断左侧是否有奇数个单引号出现
                for(int i=0; i<str1.length(); i++){
                    if(str1.charAt(i) == '\''){
                        count ++;
                    }
                }

                return count%2 == 0 ? false : true;
            }
}
