package huaWeiOd;

import java.util.Arrays;
import java.util.Scanner;

/**
 https://www.nowcoder.com/practice/69ef2267aafd4d52b250a272fd27052c?tpId=37&tqId=21281&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D1%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=1&judgeStatus=undefined&tags=&title=

 输入n个整数，找出其中最小的k个整数并按升序输出

 本题有多组输入样例

 数据范围：1 \le n \le 1000 \1≤n≤1000  ，输入的整数满足 1 \le val \le 10000 \1≤val≤10000
 输入描述：
 第一行输入两个整数n和k
 第二行输入一个整数数组

 输出描述：
 从小到大输出最小的k个整数，用空格分开。

 示例1
 输入：
 5 2
 1 3 5 7 2
 复制
 输出：
 1 2
 */
public class HJ58 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int  n=0,k=0;
        String[] tmps=null;
        tmps=in.nextLine().split(" ");
        n=Integer.valueOf(tmps[0]);
        k=Integer.valueOf(tmps[1]);

        tmps=in.nextLine().split(" ");
        int[] nums=new int[tmps.length];
        for(int i=0;i< tmps.length;i++){
            nums[i]=Integer.valueOf(tmps[i]);
        }

//         Collections.sort(arr);
        int tmp=0;
       //由小到大   冒泡排序    一趟一个到最终位置， 没有需要交换，说明已经有序
        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
               if(nums[i]>nums[j]){
                   tmp=nums[i];
                   nums[i]=nums[j];
                   nums[j]=tmp;
               }
            }
        }

        for(int i=0;i<k;i++){
            System.out.print(nums[i]);
            if(i!=k-1){
                System.out.print(" ");
            }
        }

    }
}
