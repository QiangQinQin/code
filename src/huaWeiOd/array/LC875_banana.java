package huaWeiOd.array;

/**
 * @author QiangQin
 * * @date 2022/12/27

https://leetcode.cn/problems/koko-eating-bananas/

 3,6,7,11
 8
 预期
 4


[332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184]
823855818
预期14


116 / 122 个通过测试用例
[1000000000,1000000000]
3
预期：
1000000000

start:
666666667

 */
public class LC875_banana {

    public static int minEatingSpeed(int[] piles, int h) {
        int maxSize = 0;
        long sum = 0;// 和 可能超过int
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            maxSize = Math.max(piles[i], maxSize);
        }

        int startSpeed = (int) Math.ceil((double) sum / h); // 最慢 h小时刚好吃完，每一小时不换堆
        int res = 0;
        for (int speed = startSpeed; speed <= maxSize; speed++) {  // 最多一个小时吃一堆
            int totalHour = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHour += Math.ceil((double) piles[i] / speed);
                if (totalHour > h) {
                    break;
                }
            }
            if (totalHour <= h) {
                res = speed;
                break;
            }
        }
        return res;
    }





    /*
    二分法

    * */
     public int minEatingSpeedBin(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1; // 最少一次吃一个
        // 速度最大的时候，耗时最短
        int right = maxVal;// 最多一个吃一颗树

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写  + (speed - 1)
            sum += (pile +      speed - 1) / speed;
        }
        return sum;
    }



    public static void main(String[] args) {
        long startTime=System.currentTimeMillis(); //获取开始时间
//        System.out.println(minEatingSpeed(new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184},823855818));
        System.out.println(minEatingSpeed(new int[]{1000000000,1000000000},3));
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)/1000+"s"); // 10ms     时间限制：1秒  空间限制：32M
    }
}
