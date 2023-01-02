package huaWeiOd.True1227;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/27
 *

https://www.yuque.com/g/qiangqin/aw0bfu/ne0f7g/collaborator/join?token=N4DFdRFi1RrPay4q# 《04. 笔试记录》

 3
 2 10 3

 8 10 3

 第一个比自己大
 找不到比自己大
 距离* 差值
 */
public class True_202212_splitBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(str[i]);
        }

        int[] res=new int[nums.length];
        for (int i = 0; i < n; i++) {
            boolean hasBig=false;
            for (int j = i+1; j < n; j++) {
                if(nums[j]>nums[i]){
                    hasBig=true;
                    res[i]= (j-i)*(nums[j]-nums[i]);
                    break;
                }
            }
            if(hasBig == false){
                res[i]=nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i]);
            if(i!=n-1){
                System.out.print(" ");
            }
        }
    }
}
