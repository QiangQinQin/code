package huaWeiOd.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author QiangQin
 * * @date 2022/12/25
https://renjie.blog.csdn.net/article/details/128402052?spm=1001.2014.3001.5502

10
-1 0 4 -3 6 5 -6 5 -7 -3
 */
public class True_Q4_maxEqualSeq_BuHui {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Integer, List<int[]>> map = new HashMap<>();

        //两个for循环遍历所有的连续子数组
        for (int i = 0; i < N; i++) {
            int count = nums.get(i);
            for (int j = i; j < N; j++) {
                int[] temp = {i, j};   //首坐标i，尾座标j
                if (i != j) {
                    count += nums.get(j);
                }
                if (map.containsKey(count)) {
                    map.get(count).add(temp);
                } else {
                    List<int[]> tempList = new ArrayList<>();
                    tempList.add(temp);
                    map.put(count, tempList);// key为连续子序列的和   value为连续子序列的下标位置
                }
            }
        }

        int res = 0;
        for (List<int[]> list : map.values()) {
            res = Math.max(res, removeIntersect(list));
        }

        System.out.println(res);
    }

    // 排除有交集的连续子数组情况
    public static int removeIntersect(List<int[]> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            List<int[]> tempList = new ArrayList<>();
            tempList.add(list.get(i));
            int right = list.get(i)[1]; //第一个序列的最后一个元素下标
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    int left = list.get(j)[0];
                    if (left > right) {  //没有交集
                        tempList.add(list.get(j));
                        right = list.get(j)[1];
                    }
                }
            }
            max = Math.max(max, tempList.size());
        }

        return max;
    }
}
