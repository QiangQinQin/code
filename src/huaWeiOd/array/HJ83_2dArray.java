package huaWeiOd.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/17
 *
https://www.nowcoder.com/practice/2f8c17bec47e416897ce4b9aa560b7f4?tpId=37&tqId=21306&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=

 不关注表格数据，只关注 坐标范围 是否合法

4 9
5 1 2 6
0
8
2 3


0
-1
0
-1
0


4 9
5 1 2 6
0
8
2 3



4 7
4 2 3 2
3
3
4 7


5 9
4 4 1 7
3
1
0 7

0
0
0
-1
0

 */
public class HJ83_2dArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m=sc.nextInt(); //行
            int n=sc.nextInt(); //列
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            int findX=sc.nextInt();
            int findY=sc.nextInt();

          //todo 如果初始化失败，后边 还能进行吗？？？？？？？
            if(m>=0 && m<=9 && n>=0 && n<=9){   //优化成 ? 0:-1  !!!
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            // 9行下标范围是 0--8    m行下标是0~m-1(注意边界)
            if(x1>=0 && x1<m  && y1>=0 && y1<n && x2>=0 && x2<m && y2>=0 && y2<n ){  // 优化成 Math.max(x1,x2)< m
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            if(x>=0 && x<m && m+1<=9){ //坐标合法 且 插入一方后 不超最大行的最大规格  //TODO 要不要该表行数或列数？？？？？？？？？
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            if(y>=0 && y<n && n+1<=9){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

            if(findX>=0  &&  findX<m  && findY >=0  && findY<n ){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }
        }

    }
}
