package Interview;

/**
 * @author QiangQin
 * * @date 2021/9/17
 */
public class Written_9_17_AoFeng {
    public static void main(String[] args) {

        int minCount = 0;
        int minCountCopy = minCount;

        for(int i = 0; i < 5; i++) {
            if(i == 0) {
                minCount = minCountCopy;
                minCount = minCount * 5 + 1; // 4*5+1=21
            } else {
                if(minCount % 4 != 0) {
                    minCount = minCountCopy;
                    minCount ++;
                    minCountCopy = minCount;
                    i = -1; //i++后为0，   即找到第一个能被0整除的数后，从头开始
                }

                minCount = minCount * 5 / 4 + 1; // i=1  21*5/4+1=26   =>   i=2  26*5/4+1=31 => i=3
            }
        }

        System.out.println(minCount);
    }
}
