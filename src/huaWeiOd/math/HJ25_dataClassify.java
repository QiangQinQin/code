package huaWeiOd.math;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/11/27
https://www.nowcoder.com/practice/9a763ed59c7243bd8ab706b2da52b7fd?tpId=37&tqId=21248&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ25%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ25
语雀：
https://www.yuque.com/g/qiangqin/aw0bfu/btitff/collaborator/join?token=KPNKH14fH6soIn4U# 《华为牛客题库》
序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
说明：
30----后续有30个整数
3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
6--- 存在6个包含3的I
0--- 123所在的原序号为0
123--- 123包含3，满足条件
 */
public class HJ25_dataClassify {
    public static void main(String[] args) {
          /*
         根据题解可知：整数序列I 和 规则整数序列R
         1、是根据R中元素   到  I序列中进行匹配查询   并将  I序列中出现的R[i]的  索引(index)  和 I[i]的值  进行记录
         2、定义R_list 用于记录  待查找条件R[i] 和 R[i]出现的次数(count) ,最后将第一步得到的集合I_list放进来即可，此处也可使用StringBuffer
         */
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            // 1）处理输入
            int In = scanner.nextInt(); //整数序列I的个数
            String[] I_arr =  new String[In]; //需要保存下标
            for(int i=0;i<In;i++){
                I_arr[i]= String.valueOf(scanner.nextInt());
            }

            int Rn = scanner.nextInt();//规则整数序列R的个数
            Set<Integer> R_set = new TreeSet<>();//使用TreeSet进行  排序和去重
            for(int i = 0; i<Rn; i++){
                R_set.add(scanner.nextInt());
            }

            // 2) 处理结果
            List<Integer> I_list = new ArrayList<>();//用于存储整数序列I
            List<Integer> R_list = new ArrayList<>();//用于存储规则整数序列R
            for(int item : R_set){
                int count = 0;//统计R中元素在I中出现的次数
                for(int i =0; i<I_arr.length; i++){ //
                    if(I_arr[i].contains(String.valueOf(item))){
                        count++;
                        I_list.add(i); // （）添加下标和值
                        I_list.add(Integer.valueOf(I_arr[i]));
                    }
                }

                if(count>0){ //添加 规则序列 、个数 、 具体的每个下标和值
                    R_list.add(item);
                    R_list.add(count);
                    R_list.addAll(I_list);
                }
                I_list.clear();
            }

            // 3）处理输出
            System.out.print(R_list.size()+" ");
            for(Integer i:R_list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
