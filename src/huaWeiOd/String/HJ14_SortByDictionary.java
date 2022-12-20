package huaWeiOd.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/11/23
描述
给定 n 个字符串，请对 n 个字符串按照字典序排列。

数据范围： 1≤n≤1000  ，字符串长度满足 1≤len≤100
输入描述：
输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。

输出描述：
数据输出n行，输出结果为按照字典序排列的字符串。

示例1
输入：
9
cap
to
cat
card
two
too
up
boat
boot
输出：
boat
boot
cap
card
cat
to
too
two
up
 */
public class HJ14_SortByDictionary {
    // 方法一: 调用API实现
    public static void withArraysAPI() throws IOException {
        // read and store strings in an array from input stream
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = br.readLine();
        }
        br.close();

        // use stream to sort and output strings, which may use more time
        Arrays.stream(ss).sorted().forEach(System.out::println);

        // alternatively, use Arrays.sort(Object[] a) and for loop to output, which may use less time
    }

    // 方法二: 使用PriorityQueue
    public static void withPriorityQueue() throws IOException {
        // read and store strings in a priority queue from input stream
        PriorityQueue<String> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // read the first line, but the number will not be used.
        String s;
        while ((s = br.readLine()) != null) {
            pq.offer(s);
        }
        br.close();

        // output
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    // 方法三: 使用list并自己实现Comparator
    public static void withComparator() throws IOException {
        // read and store strings in a list from input stream
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // read the first line, but the number will not be used.
        String s;
        while ((s = br.readLine()) != null) {
            list.add(s);
        }
        br.close();
        // sort with self defined comparator
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        })
        list.sort((s1, s2) -> {
            int i = 0;

            while (i < s1.length() && i < s2.length()) {
                if (s1.charAt(i) > s2.charAt(i)) {
                    return 1;
                } else if (s1.charAt(i) < s2.charAt(i)) {
                    return -1;
                } else {
                    i++;
                }
            }
            // 对于 aaaa  aaaab,上面没分出胜负，就看长短了
            return s1.length() - s2.length();
        });

        // indeed, default comparator works for this case
        // list.sort(null);
        // or you may use Collections.sort method to avoid null
        // Collections.sort(list);

        // output
        list.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
////===============虽增序，但去重了 ×××××××××× =================
//        TreeSet<String> set = new TreeSet<>();
//        int n = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < n; i++) {
//            set.add(sc.nextLine());
//        }
//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }


//        withArraysAPI();
//        withPriorityQueue();
//        withComparator();

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());

        String[] words=new String[n];
        for (int i = 0; i < n; i++) {
            words[i]=sc.nextLine();
        }

        Arrays.sort(words);
        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }

    }
}
