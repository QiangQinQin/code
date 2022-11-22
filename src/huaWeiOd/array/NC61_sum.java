package huaWeiOd.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author QiangQin
 * * @date 2022/11/21
https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=196&tqId=37090&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3DNC61%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=&title=NC61

给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
（注：返回的数组下标  从1  开始算起，保证target一定可以由数组里面2个数字相加得到）

输入：
[3,2,4],6
返回值：
[2,3]
说明：
因为 2+4=6 ，而 2的下标为2 ， 4的下标为3 ，又因为 下标2 < 下标3 ，所以返回[2,3]

未通过：
[0,4,3,0],0
[1,4]
 hashMap  key为值，value为下标
 */
public class NC61_sum {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    public static int[] twoSum(int[] numbers, int target) {
//        // write code here
//        int[] res=new int[2];
//        ArrayList<HashMap<Integer,Integer>> list = new ArrayList<>();
//        for (int i = 0; i < numbers.length; i++) {
//            list.get(i).put(numbers[i],i+1);//因数组下标 要从1开始
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            HashMap<Integer, Integer> map = list.get(i);
//            if(map.)
//        }
//
//        return res;
//    }

    public static  int[] twoSum (int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        //遍历数组
        for (int i = 0; i < numbers.length; i++) {
            //若不包含target - numbers[i]，装入map中，   包含的话直接返回下标
            if(map.containsKey(target - numbers[i])){
                res[0]=map.get(target - numbers[i])+1; //因为要求 返回结果从1开始
                res[1]=i+1;
                break;
            }

            else
                map.put(numbers[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{0,4,3,0},6)));
    }
}
