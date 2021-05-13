package huaWeiOd.Interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2021/5/13
 */

/*
list<list<integer>>
他给了一个 arr[[1,2,3],[3,5,8],[6,7,8]]
让输出 arr[1,2,3,3,5,6,7,8,8]
二维数组   归并排序
* */
public class List_List_Integer {
        public static void main(String[] args) {

//            ListListInteger对象转为二维数组
            List<Integer> integerList = new ArrayList<>();
            integerList.add(1);
            integerList.add(5);
            integerList.add(2);
            integerList.add(0);
            List<Integer> integerList1 = new ArrayList<>();
            integerList1.add(1);
            integerList1.add(3);
            integerList1.add(2);
            integerList1.add(0);
            List<Integer> integerList2 = new ArrayList<>();
            integerList2.add(1);
            integerList2.add(5);
            integerList2.add(1);
            integerList2.add(0);


            List<List<Integer>> lists = new ArrayList<>();
            lists.add(integerList);
            lists.add(integerList1);
            lists.add(integerList2);
            for (List<Integer> tmp : lists) {
                System.out.println(tmp);
            }
            /*
             [1, 5, 2, 0]
            [1, 3, 2, 0]
            [1, 5, 1, 0]
            */
            System.out.println("----------------------------------------");
            Integer[][] a = new Integer[lists.size()][lists.get(0).size()];
//          转化成数组
            for (int i = 0; i < lists.size(); i++) {
                Integer[] b = lists.get(i).toArray( new Integer[lists.get(i).size()] );
                for (int j = 0; j < lists.get(i).size(); j++) {
                    a[i][j] = b[j];
                }
            }
//            输出
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.println(a[i][j]);
                }
            }
        }
}
