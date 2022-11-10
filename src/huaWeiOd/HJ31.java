package huaWeiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/10
 *
 *  * <p>
 *      https://www.nowcoder.com/practice/81544a4989df4109b33c2d65037c5836?tpId=37&tqId=38366&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title= </p>
 *  *
 *
 * <p>对字符串中的所有 单词 进行 倒排。</>
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 *
 * 数据范围：字符串长度满足 1 < n < 10000 \1≤n≤10000
 * 输入描述：
 * 输入一行，表示用来倒排的句子
 *
 * 输出描述：
 * 输出句子的倒排结果
 *
 * 示例1
 * 输入：
 * I am a student
 * 复制
 * 输出：
 * student a am I
 * 复制
 * 示例2
 * 输入：
 * $bo*y gi!r#l
 * 复制
 * 输出：
 * l r gi y bo
 */
public class HJ31 {
    public static void main(String[] args) {
//        Character c='c';
//        Character d='c';
//        System.out.println(c==d);
//        System.out.println(c.equals(d));
//        System.out.println(c.charValue());

//        $bo*y gi!r  #l
        Scanner in = new Scanner(System.in);
        String str = " "+in.nextLine();
        List<Character> list = new ArrayList<>();

        for (int i = 0 ; i < str.length() ; i ++) {    // 只统计字符
            if (Character.isLetter(str.charAt(i))) {
                list.add(str.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder(); // 查字符表， 倒着处理输出串。比如：$bo*y gi!r  #l  处理后为boygirl,先处理并打印 l
        for (int i = str.length() - 1, j = list.size() - 1; i >= 0; i--) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(list.get(j));
                j--;
            } else if ( !Character.isLetter(str.charAt(i))  ){ //遇到非字符，处理整个单词
                String s = sb.reverse().toString();
                System.out.print(s + " ");
                sb = new StringBuilder();
            }
        }

//
//        Scanner in = new Scanner(System.in);
//       String seq=in.nextLine();
//
//        StringBuilder builder = new StringBuilder();
//        String s = new String();
//        // 去掉非法字符
//        for(int i=0;i< seq.length();i++){
//
//            if( (seq.charAt(i)>= 'a' &&  seq.charAt(i)>= 'a')  ||   (seq.charAt(i)>= 'A' && seq.charAt(i) <= 'Z')){
//                builder.append(seq.charAt(i));
//            }else{
//                // 处理空格。  当前字符不是字符  且  之前没有拼空格 才会拼。比如r  #l ==》r l
//                s=builder.toString();
//                if(i-1>=0  && s.charAt(s.length()-1)!=' ')
//                builder.append(" ");
//            }
//        }
//
//        //
//        String str[] =builder.toString().split(" ");
//        for (int i=str.length-1;i>=0;i--){
//            System.out.print(str[i]);
//            if(i!=0){
//                System.out.print(" ");
//            }
//        }



    //
//        //倒序输出每个单词
//        String[] res=builder.toString().split(" ");
        /*
        *   //若前一个字符加到builder里，则说明非字母，要用 空格 隔开
                if( !(i-1>=0 && seq.charAt(i-1) ==builder.charAt(builder.length()-1)) ){
                    builder.append(" ");
                }
        * */
//        System.out.println(builder.toString());
    }
}
