package Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author QiangQin
 * * @date 2021/9/30
 */
public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list); //[aaa, bbb, ccc]

        Object[] strs=list.toArray();
        for (Object o:strs
             ) {
            System.out.print(o);
        }
        System.out.println(Arrays.toString( list.toArray() )); // 先转为 Object数组，然后 添上[]变成字符串打印
        Character.toChars(0x20001);
    }
}
