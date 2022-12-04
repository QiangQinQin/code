package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/5
https://www.nowcoder.com/practice/48b3cb4e3c694d9da5526e6255bb73c3?tpId=37&tqId=21236&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ13%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ13
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符


 */
public class HJ13_Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();

        int j = input.length() - 1, i = j;
        StringBuilder res = new StringBuilder();

        while(i >= 0) {
            while(i >= 0 && input.charAt(i) != ' ') i--; // 搜索首个空格（直到i=-1,退出while）
            res.append(input.substring(i + 1, j + 1) + " "); // 添加单词  [i+1,j]

            while(i >= 0 && input.charAt(i) == ' ') i--; // 跳过与下一个单词间的 空格（' '）
            j = i; // j 指向下个单词的尾字符
        }

        System.out.println(res.toString());
    }
}
