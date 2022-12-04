package huaWeiOd.String;

import java.util.ArrayList;

/*
* 一个字符串s中 如果有 两个不重叠的子串"NB"和"BN"，就返回YES
例如，
"NBN"，返回NO。
NB Y BN，  YES
BN  NB

语法知识基础，重要的是思想  和 效率

可能含有多个，一旦找到就可以退出

一个从前往后找（i i+1）   一个从后往前找(j j+1)  （判断是BN或NB）
肯定不冲突  有就行了，退出
如果位置和串都不一样(contNB  countBN)，则返回true


String截子串方法：String.substring(int beginIndex, int endIndex)   取得是begin...end-1的
String 包含某子串public boolean contains(CharSequence s)
               String.indexOf() 的用途是在一个字符串中寻找一个字的起始位置，同时也可以判断一个字符串中是否包含某个字符

获取字符串指定下标位置的值;s.charAt(i)
*/
public class NC718_NBN {

    public static String solve(String s) {
        if (s == null || s.length() < 3 || !s.contains("NB") || !s.contains("BN"))
            return "NO";
        StringBuffer stringBuffer=null;

        //有了还要确保 不重叠   BNB
        StringBuilder stringBuilder = new StringBuilder();
        int start = s.indexOf("NB");//start  和start+1 为NB
        //去掉该位置的NB，判断有没有BN(可以避免重叠)
        if (start - 1 >= 0) {
            stringBuilder.append(s.substring(0, start - 1));
        }
        if (start + 2 <= s.length() - 1) {
            stringBuilder.append(s.substring(start + 2, s.length()));//截取的是start + 2  。。。 s.length()-1
//            System.out.println(stringBuilder);
        }
        if (stringBuilder.toString().contains("BN")) {
            return "YES";
        }


        //为了避免选错了就凑不够了  BNB YZX NB
        StringBuilder stringBuilder2 = new StringBuilder();
        int start2 = s.indexOf("BN");
        if (start2 != 0) {
            stringBuilder.append(s.substring(0, start2 - 1));
        }
        if (start2 + 2 < s.length() - 1) {
            stringBuilder.append(s.substring(start2 + 2, s.length() ));
        }
        if (stringBuilder.toString().contains("NB")) {
            return "YES";
        }

        return "NO";
////            char[] strs=s.toCharArray();
//           // B NB N  错开一位
//            //NB  YY 就不用判断
//            int head=0;
//            int tail=s.length()-2;
//            int countBN=0;
//            int countNB=0;
//            while(head<tail){
//                //从后往前 从前往后 分别判断两个,肯定位置不冲突，就看数量了,够了就不用找了
//                //和原地前后的不重叠，移动后肯定不重叠
//                //有可能NB BN只在重叠处有一个，选错了就凑不够了  BNB YZX BN        BNB I BNB
//                // BN和NB重叠时谁在前谁在后不一定  BNB   NBN
//                // NB NB
//                if(s.substring(head,head+1).equals("BN") && countBN<1){
//                    countBN++;
//                }else if(s.substring(head,head+1).equals("NB")&& countNB<1) {
//                    countNB++;
//                }
//                if(s.substring(tail,tail+1).equals("BN") && countBN<1){
//                    countBN++;
//                }else if(s.substring(tail,tail+1).equals("NB")&& countNB<1){
//                    countNB++;
//                }
//
//                if( countBN >=1 && countNB>=1 )//
//                    return "YES";
//
//                head+=2;
//                tail-=2;
//            }
////             N BN B 后移1个，错开一位，哪个没有，就找哪个，有就退出
////            head=1;
////            tail=s.length()-3;
////            while(head<tail){
////                //从后往前 从前往后 分别判断两个,肯定位置不冲突，就看数量了,够了就不用找了
////                // NB NB
////                if(s.substring(head,head+1).equals("BN") && countBN<1){
////                    countBN++;
////                }else if(s.substring(head,head+1).equals("NB")&& countNB<1) {
////                    countNB++;
////                }
////                if(s.substring(tail,tail+1).equals("BN") && countBN<1){
////                    countBN++;
////                }else if(s.substring(tail,tail+1).equals("NB")&& countNB<1){
////                    countNB++;
////                }
////
////                if( countBN >=1 && countNB>=1 )//
////                    return "YES";
////
////                head+=2;
////                tail-=2;
////            }


    }

    public static void main(String[] args) {
//        NBBN   NBAAAAAAAABN
        System.out.println(solve("NBBN"));
//        ArrayList
    }
}
