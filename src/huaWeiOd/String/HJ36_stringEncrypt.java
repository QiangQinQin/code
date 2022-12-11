package huaWeiOd.String;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/12/11
 *
https://www.nowcoder.com/practice/e4af1fe682b54459b2a211df91a91cf3?tpId=37&tqId=21259&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=3&judgeStatus=undefined&tags=&title=

描述
有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：
首先，选择一个单词作为密匙，如TRAILBLAZERS。
如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，
并将新建立的字母表中  未出现的字母   按照正常字母表顺序  加入新字母表。
如下所示：
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

T R A I L B Z E S C D F G H J K M N O P Q U V W X Y (实际需建立小写字母的字母表，此字母表仅为方便演示,  新插入的为  C D F G H J K M N O P Q U V W X Y）

上面其他用字母表中剩余的字母填充完整。
在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
因此，使用这个密匙， Attack AT DAWN (黎明时攻击)就会被加密为Tpptad TP ITVH。

请实现下述接口，通过指定的密匙和明文得到密文。

数据范围：1≤n≤100  ，保证输入的字符串中   仅包含小写字母

输入描述：
先输入key和要加密的字符串

输出描述：
返回加密后的字符串

示例1
输入：
nihao
ni
输出：
le


 难点：
  寻找未出现的字母
  将字符 和 字母表对应
 */
public class HJ36_stringEncrypt {
    public static void main(String[] args) {
        /*
        1. 自己
        * */
        System.out.println((char) 97);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            //  1. 先输入key
            String str = sc.nextLine();
            LinkedHashSet<Character> hashSet = new LinkedHashSet<Character>();

            //得到单词中不重复的字符
            for (int i = 0; i < str.length(); i++) {
                hashSet.add(str.charAt(i));
            }

            char[]   chs={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            // 追加未出现的字母
            for (int i = 0; i < chs.length; i++) {
                if(!hashSet.contains(chs[i])){
                    hashSet.add(chs[i]);
                }
            }

            // 得到 加密字母 和 原字母表的映射关系
            Object[]  encrypt=hashSet.toArray();
            HashMap<Object , Object> map = new HashMap<>();
            for (int i = 0; i < chs.length; i++) {
                map.put(chs[i],encrypt[i]);
            }


            // 2. 输入要加密的字符串
            String str2 = sc.nextLine();
            for (int i = 0; i < str2.length(); i++) {
                System.out.print(map.get(str2.charAt(i)));
            }
        }

        /*
         2. 网友
        *
        * */

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String key = sc.next().toLowerCase();
//            String s = sc.next();
//            ArrayList<Character> list = new ArrayList<>();
//            for(int i=0;i<key.length();i++){
//                //如果list中不存在就放入  (无需用linkedHashSet)
//                if(!list.contains(key.charAt(i))){
//                    list.add(key.charAt(i));
//                }
//            }
//            //将a-z放入到list中
//            for(int i= 97;i<=122;i++){
//                char c = (char) i;
//                if(!list.contains(c))
//                    list.add(c);
//            }

//            Map<Character,Character> map = new HashMap<>();
//            int begin = 97;
//            for (int i=0;i<list.size();i++) {
//                map.put((char)(begin+i),list.get(i)); // 自动将 ASCII转为 字符
//            }
//
//            StringBuilder result = new StringBuilder();
//            for (int i=0;i<s.length();i++){
//                char c = s.charAt(i);
//                Character character = map.get(c);
//                if(s.charAt(i)>=97 && s.charAt(i)<=122){
//                    result.append(character);
//                }else {
//                    result.append(Character.toUpperCase(character));
//                }
//            }
//            System.out.println(result.toString());
//        }
    }
}
