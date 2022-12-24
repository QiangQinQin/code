package huaWeiOd.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author QiangQin
 * * @date 2022/12/22

题目描述:
A公司准备对他下面的N个产品评选最差奖，
评选的方式是首先对每个产品进行评分，然后根据评分区间计算相邻几个产品中最差的产品。

评选的标准是依次找到从当前产品开始前M个产品中最差的产品，请给出最差产品的评分序列。

输入描述:
第一行，数字M，表示评分区间的长度，取值范围是0<M<10000
第二行，产品的评分序列，比如[12,3,8,6,5]，
产品数量N范围是-10000<N<10000

输出描述:
评分区间内最差产品的评分序列

示例1
输入:
3
12,3,8,6,5
输出:
3,3,5
说明:
12.3.8最差的是3
3.8,6中最差的是3
8.6.5中最差的是5
 */
public class True_Q4_worseProduct {
    public static void main(String[] args) {
        /*
        思路1： 双重for （每个起点，遍历区间内每个元素）
        思路2： 用一个副组栈
        * */
        Scanner sc = new Scanner(System.in);
        int m=Integer.parseInt(sc.nextLine());// 区间大小
        String[] nums=sc.nextLine().split(",");

        ArrayList<String> list = new ArrayList<>();
        int minIndex=0;//区间内 最小下标对应的index
        for (int i = 0,count=0; i < nums.length; i++) {
            if(count!=m) {
                count++; // 每进一次for，个数加1
                if(Integer.parseInt(nums[minIndex])>= Integer.parseInt(nums[i])){
                    minIndex=i;
                }
            }

            if(count==m){
                list.add(nums[minIndex]);
                count=2;
                // 如果滑动窗口往后移动一格后，移出去的元素恰好是单调队列最小元素，则需重新寻找最小元素对应的下标
                if(minIndex == i-m){
                    minIndex=i-m+1;
                    for (int j = i-m+1; j <=i ; j++) {
                        if(Integer.parseInt(nums[minIndex])>= Integer.parseInt(nums[i])){
                            minIndex=i;
                        }
                    }
                }
            }
        }

        list.add(nums[minIndex]); //最后一个元素

        System.out.println(String.join(",",list));

//
//        //todo 需要理解实现
//        Scanner in = new Scanner(System.in);
//        int M = in.nextInt();
//        in.nextLine();
//        List<Integer> nums = Arrays.stream(in.nextLine().split(","))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        Deque<Integer> dq=new LinkedList<>();
//        for(int i = 0; i < nums.size(); i++) {
//            if(i >= M) { //M,M+1,...i...,nums.size
//                // 输出单调队列  队首元素，该元素即为  移动前滑动窗口的最小值
//                System.out.print(dq.peekFirst());
//                System.out.print(",");
//                // 如果滑动窗口往后移动一格后，移出去的元素恰好是单调队列最小元素，则出队它
//                if(nums.get(i - M) == dq.peekFirst()) {
//                    dq.pollFirst();
//                }
//            }
//            /*
//              队列不为空  且  队列中最后的元素 大于 当前元素的话
//              需先将队列最后元素出队，因为它不可能成为最小元素了
//             */
//            while(!dq.isEmpty() && dq.peekLast() > nums.get(i)) {
//                dq.pollLast();
//            }
//            // 当前元素入队
//            dq.addLast(nums.get(i));
//        }
//
//        System.out.print(dq.peekFirst()); //打印最后一个元素
    }
}
