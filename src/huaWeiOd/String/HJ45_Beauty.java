package huaWeiOd.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/12/5
https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3?tpId=37&tqId=21268&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

给出一个字符串，该字符串仅由 小 写字母组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的  总和。
每个字母都有一个“漂亮度”，范围在 1到26 之间。
没有任何两个不同字母拥有 相同的“漂亮度” 。字母忽略大小写。

给出多个字符串，计算每个字符串 最大可能的“漂亮度”。

本题含有多组数据。
数据范围：输入的名字长度满足 1≤n≤10000

输入描述：
第一行一个整数N，接下来N行每行一个字符串
输出描述：
每个字符串可能的最大漂亮程度

示例1
输入：
2
zhangsan
lisi
输出：
192
101
说明：
对于样例lisi，让i的漂亮度为26，l的漂亮度为25，s的漂亮度为24，lisi的漂亮度为25+26+24+26=101.
zhangsan: {a=2, n=2, g=1, h=1,, s=1, z=1}  令a的漂亮度为26  n的漂亮度为25，以此类推，   最后将个数*漂亮度 求和
 */
public class HJ45_Beauty {

//    ------------------自己 =-------------
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < num; i++) {
//            char[] chars = sc.nextLine().toCharArray();
//            System.out.println(beauty(chars));
//        }
//    }
//
//    private static int beauty(char[] chars) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        for (int i = 0; i < chars.length; i++) {
//            if(map.containsKey(chars[i])){
//                map.put(chars[i],  map.get(chars[i])+1);
//            }else{
//                map.put(chars[i],1);
//            }
//        }
//
//        ArrayList<Object> list = new ArrayList<>();
//        for (int i = 0; i < map.size(); i++) {
//            list.add(map.get(i));
//        }
//        Collections.sort(list, new Comparator<HashMap<Character,Integer>>(){
//            @Override
//            public int compare(HashMap o1, HashMap o2) {
//                return 0;
//            }
//        }) ;
//        System.out.println(map);
//        return  map.size();
//    }


    public static void main(String[] args) throws IOException {
         /*
        方式1：
            1.开一个整型数组，下标  对应字母ASCII码 ，值 为对应字母出现的次数，
            2.对字母出现次数排序
            3.计算漂亮度
         * */
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            for(int i=0;i<n;i++){
                String str=in.next();
                int s[]=new int[128];

//                1.开一个整型数组，下标  对应字母ASCII码 ，值 为对应字母出现的次数，
                for(int j=0;j<str.length();j++){
                    s[str.charAt(j)]++;
                }
//    2.出现次数由小到大排序
                Arrays.sort(s);
//  3. 计算漂亮度
                int mul=26,sum=0;
                for(int j=s.length-1; j>=0&&s[j]>0 ;j--){
                    sum +=  s[j]*mul;
                    mul--;
                }
                System.out.println(sum);
            }
        }


       /*
题目可以转换为：输入一个字符串，每个字符对应一个分值，求字符串的最大总分值；
由于题目并没有限制某个字符对应某个分值，因此可以应用贪心的思想，即将最高分值 赋给 出现次数最多的字符；
因此问题的解决方案为：
  对字符串进行桶排序，我们只需要知道不同字符  出现的次数 ，甚至都不需要知道次数对应的是什么字符；
  然后再将次数降序排列，依次乘以当前还可以用的最高分值再加入总分值
       * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while ((s = br.readLine()) != null) {
            //  统计字符 和 对应出现次数
            int[] counter = new int[26];
            for(char c: s.toCharArray()) {
                counter[c-'a']++;
            }

            // 拿到出现次数
            List<Integer> list = new ArrayList<>();
            for(int n: counter) {
                if (n > 0) {
                    list.add(n);
                }
            }

            //  由大到小排序
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer i1, Integer i2) {
                    return i2.intValue() - i1.intValue();
                }
            });

            // 按次数多少赋值漂亮度，并求和
            int point = 26, sum = 0;
            for(int i = 0; i < list.size(); i++) {
                sum += (point - i) * list.get(i).intValue();
            }
            System.out.println(sum);
        }

        br.close();
    }
}
