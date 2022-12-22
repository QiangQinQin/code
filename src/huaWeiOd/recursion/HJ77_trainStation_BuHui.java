package huaWeiOd.recursion;

/**
 * @author QiangQin
 * * @date 2022/12/11
https://www.nowcoder.com/practice/97ba57c35e9f4749826dc3befaeae109?tpId=37&tqId=21300&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=3&tags=&title=

描述
给定一个正整数N代表火车数量，0<N<10，
接下来输入火车  入站的序列，一共N辆火车，每辆火车以数字1-9编号，
火车站只有 一个方向进出，
同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。


要求输出所有火车出站的方案，以字典序排序输出。
数据范围：1≤n≤10
进阶：时间复杂度：O(n!)，空间复杂度：O(n)

输入描述：
第一行输入一个正整数N（0 < N <= 10），
第二行包括N个正整数，范围为1到10。

输出描述：
输出以 字典序 从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。

示例1
输入：
3
1 2 3
复制
输出：
1 2 3
1 3 2
2 1 3
2 3 1
3 2 1
复制
说明：
第一种方案：1进、1出、2进、2出、3进、3出
第二种方案：1进、1出、2进、3进、3出、2出
第三种方案：1进、2进、2出、1出、3进、3出
第四种方案：1进、2进、2出、3进、3出、1出
第五种方案：1进、2进、3进、3出、2出、1出
请注意，[3,1,2]这个序列是不可能实现的。
 */




/*   ？？？？？？？？？？？？    */
public class HJ77_trainStation_BuHui {
//          /* 栈 */
//        static List<String> l = new ArrayList<>(); //储存结果
//
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//
//            while (in.hasNext()) {
//                l.clear(); //静态变量，每次先清空
//                int nums = in.nextInt();
//                int[] id = new int[nums];
//                Stack<Integer> stack = new Stack<>();
//                for (int i = 0; i < nums; i++) {
//                    id[i] = in.nextInt();
//                }
//                trainOut(id, 0, stack, "", 0);
//                //对结果集排序
//                Collections.sort(l);
//                for (String str : l) {
//                    System.out.println(str);
//                }
//            }
//            in.close();
//        }
//
//        //i为入栈次数，n为出栈次数，str存储一趟结果
//        public static void trainOut(int[] id, int i, Stack<Integer> s, String str, int n) {
//            if (n == id.length) {
//                l.add(str); //如果所有火车均出栈则将当前结果保存
//            }
//
//            if (!s.empty()) { //栈非空时出栈
//                int temp = s.pop();
//                trainOut(id, i, s, str + temp + " ", n + 1);
//                s.push(temp); //恢复现场
//            }
//
//            if (i < id.length) {
//                s.push(id[i]);
//                trainOut(id, i + 1, s, str, n);
//                s.pop(); //恢复现场
//
//            }
//        }




    /*      dfs*/
//    private static boolean[] used = null;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        used = new boolean[n + 1];
//
//        int[] nums = new int[n];
//        int[] tmp = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//
//        dfs(n, nums, tmp, 0);
//
//        sc.close();
//    }
//
//
//    private static void dfs(int n, int[] nums, int[] tmp, int step) {
//        if (step == nums.length) {
//            if (isValid(nums, tmp)) {
//                System.out.println(printResult(tmp));
//            }
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            if (used[i]) {
//                continue;
//            }
//
//            used[i] = true;
//            tmp[step] = i;
//            dfs(n, nums, tmp, step + 1);
//            used[i] = false;
//        }
//    }
//
//    private static boolean isValid(int[] nums, int[] tmp) {
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//        Set<Integer> set = new HashSet<>();
//        int idx = 0;
//        for (int i = 0; i < tmp.length; i++) {
//            while (!set.contains(tmp[i])) {
//                set.add(nums[idx]);
//                idx++;
//            }
//
//            for (int j = map.get(tmp[i]) + 1; j < idx; j++) {
//                if (set.contains(nums[j])) {
//                    return false;
//                }
//            }
//            set.remove(tmp[i]);
//        }
//        return true;
//    }
//
//    private static String printResult(int[] tmp) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < tmp.length - 1; i++) {
//            sb.append(tmp[i]).append(" ");
//        }
//        sb.append(tmp[tmp.length - 1]);
//        return sb.toString();
//    }
}
