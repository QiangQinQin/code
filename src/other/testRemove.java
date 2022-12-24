package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2022/11/12
 */
public class testRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>() {{
                add("test1");
                add("test1");
                add("test2");
                add("test3");
            }};

//        for (int k = 0; k < list.size(); k++) {
//            if (list.get(k).equals("test1")) {
//                list.remove(k); // 元素个数会变少  且  删除位置后面的元素 下标会前移一个
//            }
//        }
//        System.out.println(list);

        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).equals("test1")) {
                list.remove(k); // 元素个数变少，当前下标 会变成 原本下一个元素的下标
                k--;
            }
        }
        System.out.println(list);
//        for(String s:list){
//            if(s.equals("test1")){
//                list.remove(s);
//            }
//        }

//        // 查看 bin目录下的 二进制文件
//        Iterator var2 = list.iterator();
//
//        while(var2.hasNext()) {
//            String s = (String)var2.next();  //  源码859  会先检查modCount
//            if (s.equals("test3")) {
//                list.remove(s);  // 源码 527  删除第一次出现的s ,并修改modCount    modCount++;
//            }
//        }


//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if (next == "test1") {
//                iterator.remove();  // ArrayList源码  879行     expectedModCount = modCount;
//            }
//        }
//        System.out.println(list);

//        Lists.newArrayListWithCapacity(100);

//        List<Integer> list2 = new ArrayList<Integer>().add("","","","");
//        List<Integer> list = Lists.newArrayList();


    }}

