package huaWeiOd.array;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/22
 *
https://www.nowcoder.com/practice/dd0c6b26c9e541f5b935047ff4156309?tpId=37&tqId=21324&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ101%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ101
输入整型数组和排序标识，对其元素按照升序或降序进行排序
第一行输入数组元素个数
第二行输入待排序的数组，每个数用空格隔开
第三行输入一个整数0或1。0代表升序排序，1代表降序排序

示例1
输入：
8
1 2 4 9 3 55 64 25
0
输出：
1 2 3 4 9 25 55 64
 */
public class HJ101_sortByFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            Integer[] arr=new Integer[num];
            for (int i = 0; i <num; i++) {
                arr[i]=sc.nextInt();
            }
            int flag=sc.nextInt();

            Arrays.sort(arr,new Comparator<Integer> (){ //注意arr不能是int,需要时 integer类型
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(flag==0){
                        return o1-o2; //升序
                    }else if(flag==1){
                        return o2-o1;
                    }
                    return 0;
                }
            });

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }


//  方法2：
//            int flag = sc.nextInt();//接收排序标识
//            Arrays.sort(arr);//数组排序
//
//            if (flag == 0) {//正序输出
//                for(int i =0; i < arr.length; i++){
//                    System.out.print(arr[i] + " ");
//                }
//            }
//            else {//逆序输出
//                for(int i = arr.length - 1; i >= 0; i--){
//                    System.out.print(arr[i] + " ");
//                }
//            }
        }


    }
}
