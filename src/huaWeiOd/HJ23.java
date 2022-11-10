package huaWeiOd;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 * (若出现次数最少的字符有多个)
 *
 * 示例1
 * 输入：
 * aabcddd
 * 复制
 * 输出：
 * aaddd
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in=scanner.nextLine();

        HashMap map = new HashMap<Character,Integer>();

        // 统计次数
        for(int i=0;i<in.length();i++){
            // 统计次数，有就加1，没有就初始化为0
            if(map.get(in.charAt(i))!=null){
                map.put(in.charAt(i),(Integer)map.get(in.charAt(i))+1);
            }else{
                map.put(in.charAt(i),1);
            }
//            map.putIfAbsent( (Integer)map.get(in.charAt(i))+1 ,0  );
//            int value= (int) map.getOrDefault((Integer)map.get(in.charAt(i))+1,0);
        }

        int min=Integer.MAX_VALUE;
        // 得到出现次数最少的
        for(int i=0;i<map.size();i++){
            if(min> (int)map.get(in.charAt(i))){
                min=(int)map.get(in.charAt(i));
            }
        }


            //删除，并打印
        for(int i=0;i<in.length();i++){
            if(min != (int)map.get(in.charAt(i))){
                System.out.print(in.charAt(i));
            }
        }
    }
}
