package huaWeiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 xcopy /s "C:\program files" "d:\"
 * * @date 2021/10/3
 */
public class HJ74 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();

            List<String> res = new ArrayList<>();
            int i=0, j=0;

            //  每一轮 可以 解析出 一个参数
            while(j<s.length()){
                //若 新起点 是 双引号
                if(s.charAt(j)=='"'){
                    while(j+1<s.length() && s.charAt(j+1)!='"') //移动到双引号末尾（即 j+1 为 "）
                        j++;
                    res.add(s.substring(i+1, j+1));// 内容 要去掉双引号[i+1,j]， 加入到结果
                    j += 3;//移动指针
                    i = j;
                }
                else{//若从字符开始
                    while(j+1<s.length() && s.charAt(j+1)!=' ')  // 移动到新空格前（即j+1处为' '）  或  字符串末尾 (即j+1 =s.length）
                        j++;
                    res.add(s.substring(i, j+1));//[i,j]

                    j += 2;
                    i = j;
                }
            }

            //输出结果
            System.out.println(res.size());
            for(String str : res){
                System.out.println(str);
            }
        }
    }
}
