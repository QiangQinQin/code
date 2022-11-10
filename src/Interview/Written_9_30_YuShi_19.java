package Interview;

import java.io.UnsupportedEncodingException;

/**
 * @author QiangQin
 * * @date 2021/10/7
 */
public class Written_9_30_YuShi_19 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
//        jiequ("我ABC汉DEF",6);
         str_split("我汉汉DEF",7);

//        String str="汉";
//        byte[] bytes = str.getBytes("GBK");
//        for (int i=0;i<bytes.length;i++ ) {
//            System.out.println(bytes[i]+" ");
//        }

    }
//    public static void jiequ(String s,int num)  {
//        int count=0;
//        String temp="";
//        for(char a:s.toCharArray()) {
//            count+=(a+"").getBytes().length;
//            if (count>num) {
//                break;
//            }
//            temp+=a;
//        }
//        System.out.println(temp);
//    }

    public static void str_split(String str1, int n) {
        if (str1 == null) {
            System.out.println("please input valid!");
            return;
        }
        int byteNum = str1.length();

        byte bytes[] = str1.getBytes();
        if (n > byteNum)
            n = byteNum;

        // 截取长度n,即数组的[0...n-1]，若n处是负数，说明汉字没结束
        if(bytes[n]<0){
            while(bytes[n] <0) //找 这个汉字前面最后一个的下标    错误！！！  前面要是也是汉字，bytes值也是负数
                n--;
        }
        System.out.println( new String(bytes,0, n+1));  // 最后一个参数： length ： The number of bytes to decode

    }
}
