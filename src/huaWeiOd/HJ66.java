package huaWeiOd;

/**
 https://www.nowcoder.com/practice/ca6ac6ef9538419abf6f883f7d6f6ee5?tpId=37&&tqId=21289&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 输入：
 reset
 reset board
 board add
 board delet
 reboot backplane
 backplane abort

 复制
 输出：
 reset what
 board fault
 where to add
 no board at all
 impossible
 install first


 */
import java.util.*;

public class HJ66 {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("reset","reset what");
        map.put("reset board","board fault");
        map.put("board add","where to add");
        map.put("reboot backplane","impossible");
        map.put("backplane abort","install first");
        map.put("board delete","no board at all");
        map.put("noMatch","unknown command");

        Set< String[] > str = new HashSet<>();
        for (String s: map.keySet()) { // 得到map键值对 里面的 键，分割成  字符串数组，然后存到 set 里面
            str.add( s.split(" ")  ) ;
        }


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] arr = sc.nextLine().split(" ");
            String res = "noMatch";
            int count = 0;
            for (String[] s: str) {
                if (arr.length==1){
                    if (s.length==2)
                        continue;
                    else {
                        if (s[0].startsWith(arr[0]))
                            res = s[0];
                    }
                }

                if (arr.length==2){
                    if (s.length==1)
                        continue;
                    else{
                        if (s[0].startsWith(arr[0]) && s[1].startsWith(arr[1])) {
                            res = s[0] + " " + s[1];
                            count++;
                        }
                    }
                }
            }

            System.out.println(count>1? "unknown command":map.get(res));
        }
    }
}