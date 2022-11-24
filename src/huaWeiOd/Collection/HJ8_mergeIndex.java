package huaWeiOd.Collection;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2021/10/3
 *
https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&ru=/exam/oj

数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照  index值升序  进行输出。

提示:
0 <= index <= 11111111
1 <= value <= 100000

输入描述：
先输入键值对的个数n（1 <= n <= 500）
接下来n行每行输入成对的index和value值，以空格隔开

输出描述：
输出合并后的键值对（多行）

示例1
输入：
4
0 1
0 2
1 2
3 4

输出：
0 3  // 0下标的1和2
1 2
3 4
 */
public class HJ8_mergeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (scanner.hasNextInt()){
            int key=scanner.nextInt();
            int value=scanner.nextInt();

            if(map.get(key)==null){ //table.containsKey(key
                map.put(key,value);
            }else{
                map.put(key,map.get(key)+value);
            }

        }


/*
 for (Integer key : table.keySet()) {
          System.out.println( key + " " + table.get(key));
      }
* */
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer key = iterator.next();
            Integer value = map.get(key);

            System.out.println(key+" "+value);
        }
    }
}
