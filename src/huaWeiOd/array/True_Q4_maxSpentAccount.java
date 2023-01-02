package huaWeiOd.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author QiangQin
 * * @date 2022/12/25
https://blog.csdn.net/misayaaaaa/article/details/128131836?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167195514616800184127966%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fblog.%2522%257D&request_id=167195514616800184127966&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~first_rank_ecpm_v1~rank_v31_ecpm-2-128131836-null-null.blog_rank_default&utm_term=%E6%9C%80%E5%A4%A7%E8%8A%B1%E8%B4%B9%E9%87%91%E9%A2%9D&spm=1018.2226.3001.4450

双十一众多商品进行打折销售，小明想购买自己心仪的一些物品，但由于受购买资金限制，所以他决定从众多心仪商品中购买三件，而且想尽可能的花完资金。
现在请你设计一个程序帮助小明计算尽可能花费的最大资金数额。
输入描述:
    输入第一行为一维整型数组M，
        数组长度小于100，
        数组元素记录单个商品的价格，
        单个商品价格小于1000。
    输入第二行为购买资金的额度R，R小于100000。
输出描述:
输出为满足上述条件的最大花费额度。
注意:
如果不存在满足上述条件的商品，请返回-1。

示例：
23,30,40
26
-1
因为输入的商品，无法组合出来满足三件之和小于26.故返回-1

23,26,36,27
78

76
说明
金额23、26和27相加得到76，而且最接近且小于输入金额78。


要点：
 购买3件
  不存在则返回-1
 尽可能大
 排序+暴力 + 大于就减枝
 */
public class True_Q4_maxSpentAccount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strs=sc.nextLine().split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i]=Integer.parseInt(strs[i]);
        }

        int target = Integer.parseInt(sc.nextLine());

        Arrays.sort(nums);
        if( nums.length <3 || (target < nums[0]+nums[1]+nums[2])){
            System.out.println(-1);
        }else {
            int res=0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int tmp = nums[i] + nums[j] + nums[k];
                        if (tmp > target || res==target){ // 数据递增，tmp会更大   或 已找到最终结果
                            break;
                        }else if(tmp == target){
                            res=tmp;
                            break;
                        }else if(tmp < target && tmp>res){
                            res= tmp;
                        }
                    }
                }
            }
            System.out.println(res);
        }


        /*
        CSDN:数组长度 小于100,可直接暴力遍历
        * */
                //处理输入
                Scanner in=new Scanner(System.in);
                List<Integer> m = Arrays.stream(in.nextLine().split(","))
                        .map(Integer::parseInt)
                        .sorted()
                        .collect(Collectors.toList());
                int r = Integer.parseInt(in.nextLine());

                int result = -1;
                //暴力遍历即可
                for (int i = 0; i < m.size() - 2; i++) {
                    for (int j = 0; j < m.size() - 1; j++) {
                        for (int k = 0; k < m.size(); k++) {
                            if (i != j && j != k && i != k) {
                                int sum = m.get(i) + m.get(j) + m.get(k);
                                if (sum <= r && sum > result) {
                                    result = sum;
                                }
                            }
                        }
                    }
                }

                System.out.println(result);
            }


}
