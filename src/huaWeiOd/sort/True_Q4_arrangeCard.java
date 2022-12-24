package huaWeiOd.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author QiangQin
 * * @date 2022/12/24

https://renjie.blog.csdn.net/article/details/128422784
题目
给定一组数字，表示扑克牌的牌面数字，忽略扑克牌的花色，请按如下规则对这一组扑克牌进行整理:
步骤1、对扑克牌进行分组，形成组合牌，规则如下:
    当牌面数字相同张数大于等于4时，组合牌为“炸弹".
    3张相同牌面数字＋2张相同牌面数字，且3张牌与2张牌不相同时，组合牌为“葫芦”
    3张相同牌面数字，组合牌为“三张”
    2张相同牌面数字，组合牌为“对子”剩余没有相同的牌，则为“单张”:
步骤2、对上述组合牌进行由大到小排列，规则如下:
    不同类型组合牌之间由大到小排列规则“炸弹”＞""葫芦">"三张">"对子"“单张"
    相同类型组合牌之间，除'葫芦"外，按组合牌全部牌面数字加总  由大到小排列"
    "葫芦"则先按3张相同牌面数字加总由大到小排列，3张相同牌面数字加总相同时，再按另外2张牌面数字加总由大到小排列;
    由于“葫芦"”">“三张”，因此如果能形成更大的组合牌，也可以将“三张"拆分为2张和1张，其中的2张可以和其它“三张"重新组合成“葫芦”，剩下的1张为“单张”
步骤3、当存在多个可能组合方案时，按如下规则排序取最大的一个组合方案:
    依次对组合方案中的组合牌进行大小比较，规则同上:
    当组合方案A中的第n个组合牌  大于  组合方案B中的第n个组合牌时，组合方案A大于组合方案B;

输入描述:
第一行为空格分隔的N个正整数，每个整数取值范围[1,13]，N的取值范围[1,1000]
输出描述:
经重新排列后的扑克牌数字列表，每个数字以空格分隔

示例1
输入:
1 3 3 3 2 1 5
输出:
3 3 3 1 1 5 2
示例2
输入:
4 4 2 1 2 1 3 3 3 4
输出:
4 4 4 3 3 2 2 1 1 3


 博主：
1:虽然题目很长，但是还是比较简单的—道题。
2∶就是  张数多的在前面，张数—样的，点数大的在前面。  单牌的话按点数大小排序
3:还有一个特殊情况就是葫芦（3张+2张）在前面，就像在示例2中，不是4 4 4 3 3 3，因为4 4 4 3 3是一个葫芦，所以要把3拆开。
4:考察的还是数据结构+排序。
 */
public class True_Q4_arrangeCard {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] strs = sc.nextLine().split(" ");
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            int num=Integer.parseInt(strs[i]);
//            if(map.containsKey(num)){
//                map.put(num,  map.get(num)+1);
//            }else{
//                map.put(num,1);
//            }
//        }
//
////        map转list
//        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
////                 张数多的在前面，  张数同的话，点数大的在前面
//                if(o1.getValue()!=o2.getValue()){
//                    return  o2.getValue()-o1.getValue();
//                }else{
//                    return o2.getKey()-o1.getKey();
//                }
////                if(o1.getKey()!=o2.getKey()){
////                    return o1.getKey()-o2.getKey();
////                }
////                return 0;
//            }
//        });
//
//        // 把3个拆成葫芦？？？
//
//        System.out.println(list);


                // 处理输入
        Scanner in = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //key为牌面点数，value为该点数的张数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);  //Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
        }

        // 排序，先按张数排序，再按点数排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (b.getValue() == a.getValue()) {
                return b.getKey() - a.getKey();
            }
            return b.getValue() - a.getValue();
        });

        // 特殊情况处理
        StringBuffer sb = new StringBuffer(); //存放最终要打印的牌
        List<Integer> split_cards = new ArrayList<>();//存放所有可被拆分的牌
        for (int i = 0; i < list.size(); i++) {// list为上面的排序结果
            Map.Entry<Integer, Integer> temp = list.get(i);// 拿到entry对象
            int carNum = temp.getKey();
            int carCount = temp.getValue();
            // 3+3的情况，要拆分成葫芦  （如果自己是3张，前张牌也是3张，则把自己拆开）
            if (i > 0 && list.get(i - 1).getValue() == 3 && carCount == 3) {
                split_cards.add(carNum);
                carCount = 2;
                temp.setValue(2);
                // 给 3个中 拆分出来的一个牌 重新组合一下
            } else if (carCount == 1 && split_cards.size() != 0) {
                for (int k = 0; k < split_cards.size(); k++) { // 试图把拆分的所有牌 都插入到当前牌 前
                    // 当 拆分中的牌  大于 此牌时，先安排拆分的牌
                    if (split_cards.get(k) > carNum) {
                        sb.append(split_cards.get(k) + " ");
                        split_cards.remove(k); // 元素个数变少，当前下标 会变成 原本下一个元素的下标 ！！！
                        k--;
                    }
                }
            }
            for (int j = 0; j < carCount; j++) { // 当前牌号 拼接 对应次数 个
                sb.append(carNum + " ");
            }
        }

        if (split_cards.size() != 0) {
            for (int i : split_cards) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
