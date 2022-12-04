package huaWeiOd.math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/29
https://www.nowcoder.com/practice/b9eae162e02f4f928eac37d7699b352e?tpId=37&tqId=21251&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ28%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ28

描述
题目描述
若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，
例如有4个正整数：2，5，6，13，如果 分组为 5和6  2和13  只能得到一组“素数伴侣”，而将   2和5、 6和13编组   将得到两组“素数伴侣”，
能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。

输入:
有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
输出:
输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。

数据范围： 1≤n≤100  ，输入的数据大小满足 2≤val≤30000
输入描述：
输入说明
1 输入一个正偶数 n
2 输入 n 个整数

输出描述：
求得的“最佳方案”组成“素数伴侣”的对数。

示例1
输入：
4
2 5 6 13
输出：
2
 */
public class HJ28_PrimeBrother {
    static int max=0;
    public static void main(String[] args){
        //标准输入
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //输入正偶数
            int n=sc.nextInt();
            //用于记录输入的n个整数
            int[] arr=new int[n];
            //用于存储所有的奇数
            ArrayList<Integer> odds=new ArrayList<>();
            //用于存储所有的偶数
            ArrayList<Integer> evens=new ArrayList<>();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                //将奇数添加到odds
                if(arr[i]%2==1){
                    odds.add(arr[i]);
                }
                //将偶数添加到evens
                if(arr[i]%2==0){
                    evens.add(arr[i]);
                }
            }


            //下标对应已经匹配的偶数的下标，值对应这个偶数的伴侣
            int[] matcheven=new int[evens.size()];
            //记录伴侣的对数
            int count=0;
            for(int j=0;j<odds.size();j++){
                //用于标记对应的偶数是否查找过
                boolean[] v=new boolean[evens.size()];
                //如果匹配上，则计数加1
                if(find(odds.get(j),  matcheven   ,evens  ,v)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //判断奇数x能否找到伴侣
    private static boolean find(int x, int[] matcheven, ArrayList<Integer> evens, boolean[] v){
        for(int i=0;i<evens.size();i++){
            //该位置偶数没被访问过，并且能与x组成素数伴侣
            if(isPrime(x+evens.get(i))  &&  v[i]==false){
                v[i]=true;
                /*
                  如果i位置偶数还没有伴侣，则与x组成伴侣，
                   如果已经有伴侣，并且这个伴侣能重新找到新伴侣，则把原来伴侣让给别人，自己与x组成伴侣
                */
                if(matcheven[i]==0  ||  find(matcheven[i],matcheven,evens,v)){
                    matcheven[i]=x;
                    return true;
                }
            }
        }
        return false;
    }
    //判断x是否是素数
    private static boolean isPrime(int x){
        if(x==1) return false;
        //如果能被2到根号x整除，则一定不是素数
        for(int i=2;i<=(int)Math.sqrt(x);i++){
            if(x%i==0){
                return false;
            }
        }
        return true;
    }
}
