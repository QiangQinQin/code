package huaWeiOd.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author QiangQin
 * * @date 2022/11/13
 *https://www.nowcoder.com/practice/c4f11ea2c886429faf91decfaf6a310b?tpId=37&tqId=21303&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
 *
 *题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 *
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述：
 * 输出合并之后的数组
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 * ==> -1 0 1 2 3 5
 *
 * 6
 * 2 8 3 6 3 2
 * 6
 * 6 3 6 2 8 11
 * ==>236811
 */
public class HJ80_ArrayMerge {
    public static void main(String[] args) {
////先排序
//        Scanner scanner = new Scanner(System.in);
//        int num1=scanner.nextInt();
//        int nums1[] =new int[num1];
//        for(int i=0;i<num1;i++){
//            nums1[i]=scanner.nextInt();
//        }
//
//        int num2=scanner.nextInt();
//        int nums2[] =new int[num2];
//        for(int i=0;i<num2;i++){
//            nums2[i]=scanner.nextInt();
//        }
//
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
////        System.out.println("aux"+Arrays.toString(nums2));
////        合并，注意去重
//
//        /*
//           2 2 3 3 6 8
//           2 3 6 6 8 11
//            ==> 22336688(要记录之前打印了2，就不能输出第2个2)
//                0 2 3 0 6 11 8 8   有bug!!!!
//        * */
//        int[] res = new int[num1 + num2];
//        int ptr=0;
//        int j=0;
//        int i=0;
//            while(i<num1 && j<num2)
//            {
//                if(nums1[i]<nums2[j]) {
//                    if(ptr-1>=0 && res[ptr-1]!=nums1[i]){
//                        res[ptr]=nums1[i];
//                    }
//                    i++;
//                }else if(nums1[i]==nums2[j]){
//                    if(ptr-1>=0 && res[ptr-1]!=nums1[i]){
//                        res[ptr]=nums1[i];
//                    }
//
//                    i++;  j++;
//                }
//                else{
//                    if(ptr-1>=0 && res[ptr-1]!=nums2[i]){
//                        res[ptr]=nums2[i];
//                    }
//                    j++;
//                }
//                ptr++;
//            }
//
//            if(i<num1){
//                while(i<num1) {
//                  res[ptr]=nums1[i];
//                  ptr++;
//                  i++;
//                }
//            }else{
//                while(j<num1) {
//                    res[ptr]=nums1[j];
//                    ptr++;
//                    j++;
//                }
//            }
//
//            for(int k=0;k<ptr;k++){
//                System.out.print(res[k]+" ");
//            }
//
//        System.out.println(Arrays.toString(res));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            Set<Long> set = new TreeSet<>();
            //接收第一个整形数组大小
            int size1 = sc.nextInt();
            for (int i = 0; i < size1; i++) {
                set.add(sc.nextLong()); //将该组的整数按数组大小循环添加进 set
            }
            //接收第二个整形数组大小
            int size2 = sc.nextInt();
            for (int i = 0; i < size2; i++) {
                set.add(sc.nextLong());
            }
            //遍历输出
            for (long n : set) {
                System.out.print(n);
            }
      /*
      注意：测试案例会以 两个整形数组 为一组测试用例， 并可能输入多组
      要记得组与组的结果之间换行
      */
            System.out.println();
        }

    }

}
