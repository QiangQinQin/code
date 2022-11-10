package huaWeiOd;

import java.util.*;

public class HJ2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str =sc.nextLine().toLowerCase();
//        String s = sc.nextLine().toLowerCase(); // 111111aAbbbbbbrbrbr   A   2
//        System.out.print(  str.length() - str.replaceAll(s,"").length() );


        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine().toLowerCase(); // 全转为 小写
        char s = sc.nextLine().toLowerCase().charAt(0);

        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray=str.toCharArray();

         // 统计出每个字符的次数
        for (char ch:charArray ) {
            if(map.containsKey(ch)){ // 之前有次数就加1
                map.put(ch, map.get(ch)+1 );
            }else{
                map.put(ch,1);
            }
        }

        System.out.println(map.getOrDefault(s,0));
    }
}
