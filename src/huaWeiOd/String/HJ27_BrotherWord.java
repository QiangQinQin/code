package huaWeiOd.String;

import java.util.*;

/**
 * @author QiangQin
 * * @date 2022/11/24
 * https://www.nowcoder.com/practice/03ba8aeeef73400ca7a37a5f3370fe68?tpId=37&tqId=21250&ru=/exam/oj
 * <p>
 * 描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母  顺序  （注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词 不同（那原来单词的 兄弟单词之间可以重复吗？？？）。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 *
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 * 注意：字典中可能有重复单词。
 * <p>
 * 数据范围：1≤n≤1000 ，输入的字符串长度满足 1≤len(str)≤10  1≤k<n
 * 输入描述：
 * 输入只有一行。  先输入字典中单词的个数n ，再输入n个单词作为字典单词。   然后输入一个单词x     最后后输入一个整数k
 * <p>
 * 输出描述：
 * 第一行输出查找到x的兄弟单词的个数m 第二行输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * <p>
 * 示例1
 * 输入：
 * 3 abc bca cab abc 1
 * <p>
 * 输出：
 * 2
 * bca
 * <p>
 *
 *
 * 示例2
 * 输入：
 * 6 cab ad abcd cba abc bca abc 1   (即输入6个单词，分别是cab ad abcd cba abc bca,找 abc的兄弟单词中的第一个)
 * 输出：
 * 3
 * bca
 * 复制
 * 说明：
 * abc的兄弟单词有cab cba bca (abc不算)，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 *
 *
 *
 *
473 bb daccb caddd bddc c baa adb ad abbcb cdaa abab a abcc ddcbd cadcc cdacd aaa a b acccd bbb dacc cc acbdd bcbb ba bacaa adda acd aaad d ab acac bc dabab abcd aacba aba daa bb ad cddab a bbaa aacad cdac acbcc cada bacd adcad cdadc bcbcc aa b acd cbaac ddcd ccb dac a dac adbcb bcda dda a ab ca dd d abd a dbb ccabd bdddd abd adc aaa baccb ccdcd a da c cadc dcdbd d aa bb a cac c ad adb ca cdcc cadd dddca d cba cb caab caa dd cd bca abc cdaa cdb bad dad bda d ddbc dab baaa adaac b a dbccd bd b bdad cdacd baa ac ddcad d bb acc aa cd cbdbb bbbcb a cc aacc c aadc dbcd a bca dd abbb ccdcd ccd ab d a a dadcd dbd bcaa c cda b ddab caaaa cdcdb b acbc ccaa dabca dcd b ba dbcc da bdbcc ab abaca bb cddc caca da dadba accdd bdac dbcd bcbbd ab bd ccb ddaa aa b b d bddd cabac aaba ab ccdb db abbd ada bdadb c abba dd cdb bca cccda badba abaa ac aabad db ccbad bddd ada dba acba b bc dd bbbbd cc cbdd cd abcaa bb ddaca acadb bbbb bddcc bdada aaa bcbda c aaa aadd cdddc adb cdbab c cbca bb aacab acdb bbdab b acbda cbdcd bda bacdc db d adcbd bccc c aaa cdd bdcd bac a aaab ddbb cd ccdbb addcc cdc c ca baadc addba dbdbd dba bbdda bcb c cdad aacac dcada cb aaad a cccab caca aad bbb dd b babbb cba bdaca db bacd bc bcbda cdda bcccd bdcda bdbcd adb cbcb a c bacba abbb adab adab b b d bca badbc baa cdb b abc aabb b d c cdab cacda d cdcda adcdc bcc bbccd b adb caba cbaaa aadb dcc add bcac bacbd bb a b c cabaa c caad c aa bcc ccab ddc dadca cdcba aaba dabbd dcb a bddb bb a c c cbc ccd dd a cabbb b caadb cb dca cbb ddaa bcadc dab a bbda cd bc ccad bbd ab c acddd cdd dbbbb daaab abbb cabc add ca caa bbbb dcab daaaa baca dcd ccacb ba bddaa acac dbcc bcc cbbcc b abba daa dbab bcca ba aa d dcdc d dcaa cbcda bd b ccbcb baa dcacd d c cbda baba d abb c cbdc da dbbb cd aabc dadc b a ddb c ddd ccdc ccd cba dbaac dcccd ddbac dbbdd bad bcdd cb dac dccd d a acdd d c cb b bcbb c a aca bcba d d bbdbc d c dabad ccca dc adb ddb dcdd dba ad ddaba c ac ddac bbbd cd a dacbb 1
预期输出
6
adbcb（具体为： adbcb  bcbda  cdbab  bcbda  badbc  bacbd）
实际输出
0
 */
public class HJ27_BrotherWord {

//    static HashMap<Character,Integer> map = new HashMap<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] strs = new String[n];
//        TreeSet<String> treeSet = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            strs[i] = sc.next();
//        }
//
//        String target=sc.next();
//        int k=sc.nextInt();
//
//
//        //判断兄弟单词 （长度  字符）
//
//        // 1)统计目标串的字符种类和个数
//        for (int i = 0; i < target.length(); i++) {
//            char ch=target.charAt(i);
//            if(map.containsKey(ch)){
//                map.put(ch,map.get(ch)+1);
//            }else{
//                map.put(ch,1);
//            }
//        }
//        // 2)判断某个串 是否符合
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            if( judgeBrother(strs[i],target)){
//                arrayList.add(strs[i]);
//            }
//        }
////         排序
//        Object[] array = arrayList.toArray();
//        Arrays.sort(array);
//
//
//        System.out.println(array.length);
//        if(k>=0  &&  k<array.length){
//            System.out.println(array[k-1]);
//        }
//
//    }
//
//    private static boolean judgeBrother(String cur, String target) {
//        boolean res=true;
//        // 去重
//        if(cur.length() != target.length()  ||  cur.equals(target)){
//            return false;
//        }
//
//        HashMap<Character,Integer> map2 = new HashMap<>();
//        // 统计候选串的  字符种类和个数
//        for (int i = 0; i < cur.length(); i++) {
//            char ch=cur.charAt(i);
//            if(map2.containsKey(ch)){
//                map2.put(ch,map2.get(ch)+1);
//            }else{
//                map2.put(ch,1);
//            }
//        }
//
//        // 比较候选串 和 目标串  (但 候选串中可能有重复的，比如：6 adbcb  bcbda  cdbab  bcbda  badbc  bacbd  dacbb 1 中的 bcbda，但题目中好像不要求，即2个bcbda都算 dacbb的兄弟串)
//        for (Character ch : map2.keySet()) {
//            if(!map.containsKey(ch) ||  ! (map.get(ch)==map2.get(ch))){
//                res=false;
//                break;
//            }
//        }
//        return res;
//    }

// ======================网上解法================================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String[] ss = scanner.nextLine().split(" ");  // 从输入串中截取 各参数:下标   0   1.。。。a   length-2   length-1
            Integer a = Integer.parseInt(ss[0]);//
            String x = ss[ss.length-2];
            Integer k = Integer.parseInt(ss[ss.length-1]);
            List<String> list = new ArrayList<>();

            //逐个判断是不是目标串的兄弟
            for (int i = 1; i <=a ; i++) {
                if (isBrother(x,ss[i])){
                    list.add(ss[i]);
                }
            }
            //处理输出结果
            int size = list.size();
            System.out.println(size);
            if (size>=k){
                Collections.sort(list);
                System.out.println(list.get(k-1));
            }

        }
    }


    public static boolean isBrother(String x,String y){
        if (x.length()!=y.length()||y.equals(x)){
            return false;
        }
        char[] s = x.toCharArray();
        char[] j= y.toCharArray();
        Arrays.sort(s);
        Arrays.sort(j);
        return new String(s).equals(new String(j));


    }

}
