package huaWeiOd.String;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/19
 *https://www.nowcoder.com/practice/52d382c2a7164767bca2064c1c9d5361?tpId=37&tqId=21310&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26judgeStatus%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=3&tags=&title=
 *
 1. 理解题意(如：字母全大/小写)
 2. 某一功能模块写完及时测试(判断是否为符号是 >= <=赋值错了)
 3. 想最佳方案
 */
public class HJ87_PassWordLevel {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String in=sc.nextLine();

        System.out.println(judge(in));

//        System.out.println(0x21);// 33
//        System.out.println((int)0x21); // 33
//        System.out.println((int)'{'); // 123
//        System.out.println('{'>0x21); // true
    }

    private static String judge(String str) {
        int score=0;
        score+=judgeLength(str.length());
        score+=judgeChar(str);
        score+=judgeNum(str);
        score+=judgeFuhao(str);
        score+=judgeReward(str);

        return judgeLevel(score);
    }

    private static int judgeReward(String str) {
        int score=0;

        /*
        2 分: 字母和数字
3 分: 字母、数字和符号
5 分: 大小写字母、数字和符号
        * */
        if(smallNum+bigNum>0  && numNum>0){
            score=2;
        }
        if(smallNum+bigNum>0 && numNum>0 && numFuhao>0){
            score=3;
        }
        if(smallNum>0 && bigNum>0 && numNum>0 && numFuhao>0){
            score=5;
        }
        return score;
    }


    static int numFuhao=0;
    private static int judgeFuhao(String str) {
        /*
    也可用 String sigStr = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

!"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
:;<=>?@             (ASCII码：0x3A~0x40)
[\]^_`              (ASCII码：0x5B~0x60)
{|}~                (ASCII码：0x7B~0x7B)
        * */

        int score=0;
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if( (ch>=0x21 &&  ch<=0x2F) ||  (ch>=0x3A &&  ch<=0x40) ||  (ch>=0x5B &&  ch<=0x60) ||  (ch>=0x7B &&  ch<=0x7B)    ){
                numFuhao++;
            }
            if(numFuhao>1){
                return 25;
            }
        }
        if(numFuhao==0){
            score=0;
        }else if(numFuhao==1){
            score=10;
        }else if(numFuhao>1){
            score=25;
        }
        return score;
    }

    static  int bigNum=0;
    static  int smallNum=0;
    private static int judgeChar(String str) {
        int score=0;
        int chTotal=0;
//        字母全都是小（大）写字母  不是 符号里全是字母，而是 符号里出现的字母大小写统一
//        Character.isUpperCase 判断大写  Character.isDigit
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch >='a' && ch<='z'){
                smallNum++;
            }else if(ch >='A' && ch<='Z'){
                bigNum++;
            }
        }

        if(bigNum+smallNum==0){
            score=0;
        } else if(smallNum==chTotal  ||  bigNum==chTotal){
            score=10;
        }else if(smallNum>0 &&  bigNum>0){
            score=20;
        }

        return score;
    }

    static int numNum =0;
    private static int judgeNum(String str) {
        int score=0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >='0'  && str.charAt(i)<='9'){  //注意字符0 ，加单引号
                numNum++;
            }
            if(numNum >1){
                return  score=20;
            }
        }

        if(numNum ==0){
            score=0;
        }else if(numNum ==1){
            score=10;
        }else if(numNum >1){
            score=25;
        }
        return score;
    }


    private static int judgeLength(int len) {
        int score=0;
        if(len <=4){
            score=5;
        }else if(5<=len && len<=8){
            score=10;
        }else if(len>=8){
            score=25;
        }

        return  score;
    }

    private static String judgeLevel(int score) {
//          switch(score / 10){
//            case 9:

        String res="";
        if(score>=90){
            res= "VERY_SECURE";
        }else if(score>=80){
            res= "SECURE";
        }else if(score>=70){
            res= "VERY_STRONG";
        }else if(score>=60){
            res= "STRONG";
        }else  if(score>=50){
            res= "AVERAGE";
        }else if(score>=25){
            res="WEAK";
        }else if(score>=0){
            res= "VERY_WEAK";
        }
        return  res;
    }

}
