package Interview;

/**
 * @author QiangQin
 * * @date 2021/10/7
 */
public class Written_9_30_YuShi_18 {
    public static void main(String[] args) {

        // 测试数据
        int[] b = {3, 2, 1, 0};

        // 遍历数组中所有的值
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - 1; j++) {
                // 如果前面的比后面的大，那就让两者交换
                if (b[j] > b[j + 1]) {
                    int c = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = c;
                }
            }
        }

        // 遍历排序后的数组
        for (int d : b) {
            System.out.println(d);
        }

    }
}
