package huaWeiOd.Collection;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/17
https://www.nowcoder.com/practice/3350d379a5d44054b219de7af6708894?tpId=37&tqId=21317&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
（注：不合法的投票指的是投票的名字不存在n个候选人的名字中！！）

数据范围：每组输入中候选人数量满足 1≤n≤100  ，总票数量满足 1≤n≤100
输入描述：
第一行输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。

输出描述：
按照输入的顺序，每行输出候选人的名字和得票数量（以" : "隔开，注：英文冒号左右两边都有一个空格！），最后一行输出不合法的票数，格式为"Invalid : "+不合法的票数。

输入：
4
A B C D
8
A D E CF A GG A B
复制
输出：
A : 3
B : 1
C : 0
D : 1
Invalid : 3
复制
说明：
E CF GG三张票是无效的，所以Invalid的数量是3.
 */



public class HJ94_vote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        String[] peo=in.nextLine().split(" ");
        int n2=Integer.parseInt(in.nextLine());
        String[] vote=in.nextLine().split(" ");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < peo.length; i++) {
            map.put(peo[i],0);
        }
        map.put("Invalid",0);

        for (int j = 0; j < vote.length; j++) {
            if(map.containsKey(vote[j])){
                map.put(vote[j], map.get(vote[j])+1);
            }else{
                map.put("Invalid", map.get("Invalid")+1);
            }

        }

        for(String tmp:map.keySet()){
            System.out.println(tmp+" : "+map.get(tmp));
        }

    }
}
