package huaWeiOd.True1227;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/12/27

https://www.yuque.com/g/qiangqin/aw0bfu/ne0f7g/collaborator/join?token=N4DFdRFi1RrPay4q# 《04. 笔试记录》

5
0 20 40 10 30

报错：
 输入""
 */
public class True_202212_schoolBase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String in=sc.nextLine();
        if(in.equals("")){
            System.out.println(0);
        }else {
            String[] posStrs = in.trim().split(" ");// 先去掉首尾空格
            int[] family = new int[n];
            for (int i = 0; i < n; i++) {
                if(!posStrs[i].equals(""))
                    family[i] = Integer.parseInt(posStrs[i]);
            }

            HashMap<Integer, Long> map = new HashMap<>();
            for (int i = 0; i < family.length; i++) {
                Long curDistance = 0L; // 避免累加和过大
                for (int j = 0; j < family.length; j++) {
                    curDistance += (Math.abs(family[i] - family[j]));
                }
//            System.out.println( "curDis"+curDistance  +  "pos"+family[i]);
                map.put(family[i], curDistance);
            }

            ArrayList<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Long>>() {
                @Override
                public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                    if (!o1.getValue().equals(o2.getValue())) {
                        return (int) (o1.getValue() - o2.getValue());
                    } else {
                        // 距离相等，选值小的
                        return o1.getKey() - o2.getKey();
                    }
                }
            });

            System.out.println(list.get(0).getKey());
        }
    }

}
