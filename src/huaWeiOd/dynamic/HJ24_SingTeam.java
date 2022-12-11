package huaWeiOd.dynamic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/5
 *
https://www.nowcoder.com/practice/6d9d69e3898f45169a441632b325c7b4?tpId=37&tqId=21247&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=
通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
例子：
123 124   125    123 121 是一个合唱队形
123 123    124 122不是合唱队形，因为前两名同学身高相等，不符合要求
123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。

输入描述：
用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开

输出描述：
最少需要几位同学出列

示例1
输入：
8
186 186 150 200 160 130 197 200
输出：
4
说明：
由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class HJ24_SingTeam {
    public static void main(String[] args) {
//       /*   处理特殊情况，只通过 0/20 */
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            list.add(sc.nextInt());
//        }
//
//        if(n==1 ){
//            System.out.println(0);
//        }
//
//        boolean des=true; //降序 大--》小
//        for (int i = 1; i < list.size(); i++) {
//            if(list.get(i-1)< list.get(i)){
//                des=false;
//                break;
//            }
//        }
//        if(des){
//            System.out.println(0);
//        }
//
//        boolean inc=true;//升序：小--》大
//        for (int i = 1; i < list.size(); i++) {
//            if(list.get(i-1)> list.get(i)){
//                inc=false;
//                break;
//            }
//        }
//        if(inc){
//            System.out.println(0);
//        }


/*
方式1：动态规划

分析题目可得，其实就是求最长递增子序列的变种题目，只不过加了一个约束条件，需要左边递增右边递减的情况。

1、先找到每一个位置i左侧的最长上升子序列长度left[i]
2、再找到每一个位置i右侧的最长下降子序列长度right[i]
3、然后求出所有位置的最长序列长度=左侧最长子序列长度+右侧最长子序列长度-1（因为该位置被算了两次，所以减1）
4、然后用数目减去最长序列长度就是答案，需要出队的人数

arr:[186, 186, 150, 200, 160, 130, 197, 200]
left[  1,   1,   1,   2,   2,   1,   3,   4]
right[ 3,   3,   2,   3,   2,   1,   1,   1]
* */

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }


            int[] left = new int[n]; //存储 每个数 左边 小于 其的数的个数
            int[] right = new int[n];//存储每个数右边小于其的数的个数
            left[0] = 1;            //最左边的数设为1 （0号下标的 左侧递增数为1，即仅自己一个）
            right[n - 1] = 1;        //最右边的数设为1
            //计算  每个位置（i）  左侧的 最长 递增(left[i]) 比如left[7]=4 就是 7号下标左侧最长递增子序列长度（包含自己 没说连续）为4
            for (int i = 0; i < n; i++) {
                left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {   //动态规划
                        left[i] = Math.max(left[j] + 1, left[i]);
                    }
                }
            }

            //计算每个位置右侧的最长递减
            for (int i = n - 1; i >= 0; i--) {
                right[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {   //动态规划
                        right[i] = Math.max(right[i], right[j] + 1);
                    }
                }
            }

            // 记录每个位置的值
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                //位置 i计算了两次 所以需要－1
                result[i] = left[i] + right[i] - 1; //两个都包含本身
            }

            //找到最大的满足要求的值
            int max = 1;
            for (int i = 0; i < n; i++) {
                max = Math.max(result[i],max);
            }
            System.out.println(n - max);
        }

/*
方式2：
借助二分查找来求解。用一个num数组记录以i为终点的从左向右和从右向走的子序列元素个数。
举例说明： 8 186 186 150 200 160 130 197 200
* */
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
//
//            int[] left = new int[n]; //存储每个数左边小于其的数的个数
//            int[] right = new int[n];//存储每个数右边小于其的数的个数
//            left[0] = arr[0];
//            right[n - 1] = arr[n-1];
//            int num[] =new  int [n];//记录以i为终点的从左向右和从右向走的子序列元素个数
//            int index = 1;//记录当前子序列的长度
//            for(int i=1;i<n;i++){
//                if(arr[i]>left[index-1]){
//                    //直接放在尾部
//                    num[i] = index;//i左侧元素个数
//                    left[index++] = arr[i];//更新递增序列
//                }else {
//                    //找到当前元素应该放在的位置
//                    int low = 0,high = index-1;
//                    while(low < high){
//                        int mid = (low+high)/2;
//                        if(left[mid] <arr[i])
//                            low = mid + 1;
//                        else
//                            high = mid;
//                    }
//                    //将所属位置替换为当前元素
//                    left[low] = arr[i];
//                    num[i] = low;//当前位置i的左侧元素个数
//                }
//            }
//            index = 1;
//            for(int i=n-2;i>=0;i--){
//                if(arr[i]>right[index-1]){
//                    num[i] += index;
//                    right[index++] = arr[i];
//                }else {
//                    int low = 0,high = index-1;
//                    while(low < high){
//                        int mid = (high+low)/2;
//                        if(right[mid]<arr[i])
//                            low = mid+1;
//                        else
//                            high = mid;
//                    }
//                    right[low] = arr[i];
//                    num[i]+=low;
//                }
//            }
//            int max = 1;
//            for (int number: num )
//                max = Math.max(max,number);
//            // max+1为最大的k
//            System.out.println(n - max);
//        }

    }
}
