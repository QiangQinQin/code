package huaWeiOd.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author QiangQin
 * * @date 2022/12/25

https://blog.csdn.net/misayaaaaa/article/details/128042802?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167195530316800192279961%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=167195530316800192279961&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-3-128042802-null-null.blog_rank_default&utm_term=%E5%B0%84%E5%87%BB%E6%AF%94%E8%B5%9B%E6%88%90%E7%BB%A9&spm=1018.2226.3001.4450

统计射击比赛成绩
题目
给定一个射击比赛成绩单，包含多个选手若干次射击的成绩分数，请对每个选手按其最高3个分数之和进行降序排名，输出降序排名后的选手ID序列。
条件如下:
    1、一个选手可以有多个射击成绩的分数，且次序不固定。
    2、如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手。
    3、如果选手的成绩之和相等，则成绩之和相等的选手按照其ID降序排列。
输入描述
输入第一行，一个整数N，表示该场比赛总共进行了N次射击，产生N个成绩分数（(2<=N<=100)。
输入第二行，一个长度为N整数序列，表示参与每次射击的选手ID(O<=ID<=99)。
输入第三行，一个长度为N整数序列，表示参与每次射击的选手对应的成绩（O<=成绩<=100)。输出描述
符合题设条件的降序排名后的选手ID序列。
示例1输入输出示例仅供调试，后台判题数据一般不包含示例输入
13
3,3,7,4,4,4,4,7,7,3,5,5,5
53,80,68,24,39,76,66,16,100,55,53,80,55
输出
5,3,7,4

说明
该场射击比赛进行了13次，参赛的选手为{3,4,5,7}。
3号选手成绩:53,80,55，最高3个成绩的和为:80+55+53=188。
4号选手成绩:24,39,76,66，最高3个成绩的和为:76+66+39=181。
5号选手成绩:53,80,55，最高3个成绩的和为:80+55+53=188。
7号选手成绩:68,16,100，最高3个成绩的和为:100+68+16=184。
比较各个选手最高3个成绩的和，有3号=5号>7号>4号，
由于3号和5号成绩相等且ID号5>3，所以输出为:5,3,7,4。

要点：
     成绩少于3无效
     按最高3分数之和进行降序排列，若和相等，按ID降序排列
 */


public class True_Q4_shotScore {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        String[] idsStr=sc.nextLine().split(",");
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i]=Integer.parseInt(idsStr[i]);
        }

        String[] scoreStr=sc.nextLine().split(",");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i]=Integer.parseInt(scoreStr[i]);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();// id 对应 所有成绩
        for (int i = 0; i < n; i++) {
            if(map.containsKey(ids[i])){
                map.get(ids[i]).add(scores[i]);
                map.put(ids[i], map.get(ids[i]));
            }else{
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(scores[i]);
                map.put(ids[i],arrayList);
            }
        }

        // 处理无效选手
        HashMap<Integer,Integer> waitSort = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() >=3){
                // 得到最高的3个成绩和
               entry.getValue().sort(new Comparator<Integer>() {
                   @Override
                   public int compare(Integer o1, Integer o2) {
                       return o2-o1;
                   }
               });
               waitSort.put(entry.getKey(),entry.getValue().get(0)+entry.getValue().get(1)+entry.getValue().get(2));
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(waitSort.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue().equals(o2.getValue()) ){ // Integer是基本类型，不能用==
                       return  o2.getKey()-o1.getKey();
                } else{
                       return  o2.getValue()-o1.getValue();
                }
            }
        });

        for (int i = 0; i < entryList.size(); i++) {
            System.out.print(entryList.get(i).getKey());
            if(i!=entryList.size()-1){
                System.out.print(",");
            }
        }

    }


//    /*
//    博主： stream流， 简单  清楚
//    * */
//    public static void main(String[] args) {
//        // 输入处理
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        List<Integer> ids = Arrays.stream(in.nextLine().split(","))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        List<Integer> scores =  Arrays.stream(in.nextLine().split(","))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        in.close();
//
//        // 存储选手成绩信息
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            List<Integer> list = map.getOrDefault(ids.get(i), new LinkedList<>());// 有就get，没有就new一个
//            list.add(scores.get(i));
//            map.put(ids.get(i), list);
//        }
//
//        StringBuilder builder = new StringBuilder();
//        //过滤+自定义排序
//        map.entrySet().stream()
//                .filter(x -> x.getValue().size() >= 3) //过滤个数 大于3
//                .sorted((o1, o2) -> { // 排序，先按分数，再按id
//                    Integer sum1 = get_sum_score(o1.getValue());
//                    Integer sum2 = get_sum_score(o2.getValue());
//                    if (sum1.equals(sum2)) {
//                        return o2.getKey() - o1.getKey();
//                    } else {
//                        return sum2 - sum1;
//                    }
//                })
//                .map(Map.Entry::getKey)
//                .forEach(x -> builder.append(x).append(","));
//
//        System.out.println(builder.substring(0, builder.length() - 1));
//
//    }
//
//    private static Integer get_sum_score(List<Integer> list) {
//        list.sort(Integer::compareTo);
//        int sum = 0;
//        for (int i = list.size() - 1; i >= list.size() - 3; i--) { // 若size小于3？？？
//            sum += list.get(i);
//        }
//        return sum;
//    }
}
