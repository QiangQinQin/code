package huaWeiOd;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            //创建TreeSet进行去重排序
            TreeSet set = new TreeSet();
            for (int i = 0; i < num; i++) {
                set.add(sc.nextInt());
            }


            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

}
