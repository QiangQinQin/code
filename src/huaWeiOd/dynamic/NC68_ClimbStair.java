package huaWeiOd.dynamic;

/**
 * @author QiangQin
 * * @date 2022/11/21
https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=196&tqId=37098&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3DNC68%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=NC68

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

输入：
2
返回值：
2
说明：
青蛙要跳上两级台阶有两种跳法，分别是：先跳一级，再跳一级或者直接跳两级。因此答案为2

示例2
输入：
7
复制
21
 */

public class NC68_ClimbStair {
////    递归
//    public static int jumpFloor(int target) {
//        int res=0;
//        if(target==1 || target==0){
//            res=1;
//        }else{
//            res=jumpFloor(target-1)+jumpFloor(target-2);
//        }
//
//        return  res;
//    }

//    非递归
    public static int jumpFloor(int number) {
        int a = 1 , b = 1 , c = 1;
        for (int i = 2 ; i <= number ; i ++) {
            c = a+b ;
            a = b ;
            b = c;
        }
        return c;
    }


    public static void main(String[] args) {
        System.out.println(jumpFloor(5));
    }

}
