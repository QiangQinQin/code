package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author QiangQin
 * * @date 2021/9/16
 */
public class Written_9_16_DeRong {
    public static void main(String[] args) {
        int i = 10;
        float f = 1.25f;
        double d = 1.25;
        long m = 4090;

        double num = 1.333;
        Double num2 = 1.333;

//        float num3=1.333;
//        Float num4=1.333;
//
//        long num5=1.333;


//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("pang");
//            }
//        };
//        thread.start();
//        System.out.println("ping");


//// 编写一个Java程序实现 多线程，在线程中输出线程的名字，隔300毫秒输出一次，共输出20次
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                  // 睡眠10次，然后线程执行结束
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(300);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, "我是线程a").start();

       //String  转  数组
        String s = "hello";
        char[] chars = s.toCharArray();

        //char数组  转化为  String
        String s2 = String.valueOf(chars);
        String s3 = new String(chars);


//  https://www.cnblogs.com/feifeicui/p/9576864.html
// 1.List转String数组
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("51gjie");
        String[] arr = list.toArray(new String[list.size()]);//将List 转为 Array,保存到  new 的 String[list.size()] 里

 // 2.String数组  转  List
        String[] strs = new String[]{"s1","s2","s3"};
        List<String> list1 = Arrays.asList(strs );


//    https://blog.csdn.net/jk_wzw/article/details/79768147
    }
}