package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/21
 * https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tqId=21240&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ17%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ17
 * <p>
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * <p>
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * <p>
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 */
public class HJ17_Move {
    static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] orders = in.nextLine().split(";");


        for (int i = 0; i < orders.length; i++) {
            if (judgeHeFa(orders[i])) {
                dealPos(orders[i]);
            }

        }
        System.out.println(x+","+ y);
    }

    private static void dealPos(String order) {
        int change = Integer.parseInt(order.substring(1, order.length()));
        switch (order.charAt(0)){
            case 'A':
                x=x-change;
                break;
            case 'D':
                x=x+change;
                break;
            case 'W':
                y=y+change;
                break;
            case 'S':
                y=y-change;
                break;
        }

    }

//    正则？？？
    private static boolean judgeHeFa(String order) {
        boolean isLength= false;
        boolean isCh=false;
        boolean isNum=true;
        if (order.length() >= 2 && order.length() <= 3) {
            isLength = true;
            if (order.charAt(0) == 'A' || order.charAt(0) == 'D' || order.charAt(0) == 'W' || order.charAt(0) == 'S') {   //  if(!s.matches("[WASD][0-9]{1,2}"))   【】是字符集  {}是出现次数 -是字符范围
                isCh = true;
                for (int i = 1; i < order.length(); i++) {
                    if (!Character.isDigit(order.charAt(i))) {
                        isNum = false;
                        break;
                    }
                }
            }
        }

        return  isLength&&isCh&&isNum;
    }
}
