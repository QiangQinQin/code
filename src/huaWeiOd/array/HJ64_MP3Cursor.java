package huaWeiOd.array;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/12/8
https://www.nowcoder.com/practice/eaf5b886bd6645dd9cfb5406f3753e15?tpId=37&tqId=21287&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。
为了简化处理，假设每屏只能显示  4首歌曲，光标  初始  的位置为第1首歌。

现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
1. 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
    光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；
    光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
    其他情况下用户按Up键，
        光标挪到上一首歌曲；
        用户按Down键，光标挪到下一首歌曲。

2. 歌曲总数大于4的时候（以一共有10首歌为例）：
   特殊翻页：
      屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。
      同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。

   一般翻页即屏幕显示的不是第一页时，
       光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
      光标当前屏幕的最后一首歌时的Down键处理也类似。

   其他情况，不用翻页，只是挪动光标就行。

数据范围：命令长度1≤s≤100 ，歌曲数量1≤n≤150
进阶：时间复杂度：O(n) ，空间复杂度：O(n)

输入描述：
输入说明：
1 输入歌曲数量
2 输入命令 U或者D

输出描述：
输出说明
1 输出当前  列表
2 输出当前 选中歌曲

示例1
输入：
10
UUUU
输出：
7 8 9 10
7

 出错：
83
UUDUDDDDUDUUDDDDUDD
 预期
3 4 5 6
6
 */
public class HJ64_MP3Cursor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         while(sc.hasNextLine()){
             int num=Integer.parseInt(sc.nextLine());
             if(num>4){
                 start=1;
                 end=4;
             }
             String orders=sc.nextLine();
             for (int i = 0; i < orders.length(); i++) {
                 deal(num,orders.charAt(i));
             }

             print();
         }
    }

    static int start=0,end=0,cur=1;
    private static void deal(int num, char order) {

  /*
    歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
    光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；
    光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
    其他情况下
        用户按Up键， 光标挪到上一首歌曲；
        用户按Down键，光标挪到下一首歌曲。
    * */
        if(num<=4){
            if(order=='U'){
                if(cur==1){
                   cur=num;
                }else{
                    cur=cur-1;
                }

            }else if(order=='D'){
                if(cur == num){
                    cur=1;
                }else {
                    cur=cur+1;
                }
            }
            start=1;
            end=num;
        }


            /*
歌曲总数大于4的时候（以一共有10首歌为例）：
   特殊翻页：
      屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。
      同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。

   一般翻页：
      屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
      光标当前屏幕的最后一首歌时的Down键处理也类似。

   其他情况，不用翻页，只是挪动光标就行。
            * */
        if(num>4){
            if(order=='U'){
                if(cur==1){
                    cur=num;
                    end=num;
                    start=end-3;
                }else if (cur==start) {
                    start=start-1;
                    end=end-1;
                    cur=cur-1;
                }else {
                    cur=cur-1;
                }
            }else if(order=='D'){
                if(cur == num){
                    cur=1;
                    start=1;
                    end=4;
                }else if(cur==end){
                    start=start+1;
                    end=end+1;
                    cur=cur+1;
                } else {
                    cur=cur+1;
                }
            }
        }


    }

    private static void print() {
        for (int i = start; i <= end ; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(cur);
    }
}
