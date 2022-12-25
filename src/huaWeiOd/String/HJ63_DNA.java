package huaWeiOd.String;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/12/25
https://www.nowcoder.com/practice/e8480ed7501640709354db1cc4ffd42a?tpId=37&tqId=21286&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

描述
一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。
G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的  总的出现次数  除以总的字母数目（也就是序列长度）。
在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。

给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中  从左往右  找出 GC-Ratio 最高  且  长度为 N 的  第一个子串。
DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等

数据范围：字符串长度满足 1≤n≤1000  ，输入的字符串只包含 A/C/G/T 字母
输入描述：
输入一个string型基因序列，和int型子串的长度

输出描述：
找出GC比例最高的子串,如果有多个则输出第一个的子串

示例1
输入：
ACGT
2

输出：
CG

说明：
ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG

示例2
输入：
AACTGTGCACGACCTGA
5
输出：
GCACG
说明：
虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。



 判断子串？
 得到比例最高的

 优化：
     滑动窗口
     不用计算比例，得到C G总个数就行

AACTGTGCACGACCTGA
5
未通过：
CCCAAGTCTTCCAATCGTGCCCCCCAATTGAGTCTCGCTCCCCAGGTGAGATACATCAGAAGC
63
 */

/*
自己
* */
//public class HJ63_DNA {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextLine()) { // 注意 while 处理多个 case
//            String str= in.nextLine();
//            int size= Integer.parseInt(in.nextLine());
//            System.out.println(maxRatio(str,size));
//        }
//    }
//
//    private static String maxRatio(String str, int size) {
//        HashMap<String, Integer> map = new LinkedHashMap<>(); //有序
//        int max=0;
//        for (int i = 0; i <= str.length()-size; i++) { // 注意下界   [0, ...,i ...., str.length()-size,...,str.length-1,str.length)
//            String tmp=str.substring(i,i+size);
//            int count=0;
//            for (int j = 0; j < tmp.length(); j++) {
//                char ch=tmp.charAt(j);
//                if(ch=='G' || ch=='C'){
//                    count++;
//                }
//            }
//            map.put(tmp,count);
//            max=Math.max(count,max);// 得到最大出现次数
//        }
//
//        String res="";
//        for (int i = 0; i <= str.length()-size; i++) {
//            String key=str.substring(i,i+size);
//            if(map.get(key)==max){
//                res=key;
//                break;
//            }
//        }
//        return res;
//    }
//}

/*
解题思路：
    遍历str的所有长度为n的子串，过程中通过两个变量分别保存每次符合的子串的起始索引和CG个数
算法流程：
    通过三个变量保存状态：maxSum记录GC字母个数，index保存结果子串的起始索引，gcSum记录每个子串中GC长度
    从起点索引开始向后遍历n个字符
    最后比较gcSum是否大于maxSum，符合则更新状态即可
* */

//public class HJ63_DNA {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.next();
//            int n = scanner.nextInt();
//            System.out.println(Solution(str, n));
//        }
//    }
//
//    public static String Solution(String str, int n) {
//        // GC字母个数
//        int maxSum = 0;
//        // 结果子串的起始索引
//        int index = 0;
//        // 起始索引
//        for(int i = 0; i <= str.length() - n; i++) {
//            int gcSum = 0;
//            // 从起点索引开始向后遍历n个字符
//            for(int j = i; j < i + n; j++) {
//                if(str.charAt(j) == 'C' || str.charAt(j) == 'G') {
//                    gcSum++;
//                }
//            }
//            if(gcSum > maxSum) {  // gcSum 小于等于 maxSum时 都不用更新index
//                index = i;
//                maxSum = gcSum;
//                // 剪枝（即  等于窗口大小，不用再找了）
//                if(gcSum == n) {
//                    return str.substring(index, index + n);
//                }
//            }
//        }
//        return str.substring(index, index + n);
//    }
//}

/*
//todo 滑动窗口???
解题思路：
    通过滑动窗口的机制实现子串中的统计处理

算法流程：
    通过左右指针维护一个滑动窗口
    每次右指针右移，并判断字符，更新状态变量
    窗口缩小时，left左指针右移，同时更新count状态变量
* */

public class HJ63_DNA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int n = scanner.nextInt();
            System.out.println(Solution(str, n));
        }
    }

    public static String Solution(String str, int n) {
        int left = 0, right = 0;
        int start = 0, count = 0, max = 0;
        while(right < str.length()) {
            char c = str.charAt(right++); // 窗口右边先扩大
            if(c == 'C' || c == 'G') {
                count++;
            }
            // 可能还没到n个元素，count就已经大于max了
            if(count > max){
                max = count;
                start = left;
                // 剪枝
                if(count == n) {
                    return str.substring(start, start + n);
                }
            }
            // 窗口缩小(当窗口长大于n时，左边界右移一个)
            if(right - left >= n) {
                char d = str.charAt(left++);
                if(d == 'C' || d == 'G') {
                    count--;
                }
            }
        }
        return str.substring(start, start + n);
    }
}
