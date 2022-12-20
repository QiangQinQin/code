package huaWeiOd.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/19
 
https://blog.csdn.net/misayaaaaa/article/details/127972503

题目
【租车骑绿岛】100分
部门组织绿岛骑行团建活动。租用公共双人自行车，每辆自行车最多坐两人，做最大载重M。给出部门每个人的体重，请问最少需要租用多少双人自行车。
输入描述:
第一行两个数字m、n，分别代表自行车限重，部门总人数。
第二行，n个数字，代表每个人的体重，体重都小于等于自行车限重m。0<m<=200
0<n<=1000000输出描述:
最小需要的双人自行车数量。

输入输出示例仅供调试，后台判题数据一般不包含示例输入
示例1
3 4
3 2 2 1
输出
3

4 12 1 1 1 2 2 2 2 2 2 2 3 3   应该是 6

思路
1:题目中有两个隐含的条件:
    1、一辆车最多骑两个人
    2、人的重量不可能大于车的载重
2:那么可以先排序，然后用两个指针，一个指向头部left，一个指向尾部right，
如果w[lef] + w[right]>车的载重，那么意味着最重的人，加上最轻的人都会超载，只能他一个人骑，right -- 。
如果w[lefi]+ wright]<=车的载重，那么意味着这两个人可以一起骑，left++,right--。


 */
public class True_Q4_BikeIsland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int maxLoad=sc.nextInt();// 自行车限重
            int peopleNum=sc.nextInt();// 部门总人数
            Integer[] weights = new Integer[peopleNum];//每个人的体重
            for (int i = 0; i < peopleNum; i++) {
                weights[i]=sc.nextInt();
            }

            // 第一步： 降序
            Arrays.sort(weights, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            /*
            第二部： 组合
            不存在体重大于车限重
            至少一人一个车
            最多两人一车
            首指针指向最大，尾指针指向最小
            * */

            int count=0;// 最少需要的车量数
            for (int left = 0,right=peopleNum-1; left <=right ; ) {
                if(weights[left] == maxLoad){
                    count++;
                    left++;
                }else if(weights[left] < maxLoad){
                    if(weights[left]+weights[right] <= maxLoad){
                        count++; //  即当前最重 和 最轻，共两人 一辆车
                        right--;
                        left++;
                    }else  if(weights[left]+weights[right] > maxLoad){
                        count++;
                        left++;  // 即 left号 一人一辆
                    }
                }
            }

            System.out.println(count);
        }
    }
}
