import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2021/10/5
 */
public class HJ13 {
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
