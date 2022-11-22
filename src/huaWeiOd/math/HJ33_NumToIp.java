package huaWeiOd.math;

import java.util.Scanner;

/**
 * @author QiangQin
 * * @date 2022/11/21
https://www.nowcoder.com/practice/66ca0e28f90c42a196afd78cc9c496ea?tpId=37&tqId=21256&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26pageSize%3D50%26search%3DHJ33%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=HJ33

原理：ip地址的每段可以看成是一个0-255（即8位）的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
一个长整数。
举例：一个ip地址为10.0.3.193 ,
转换为10进制数就是10*Math.pow(2,24)+3*Math.pow(2,8)+193 = 167773121

转换为2进制：
每段数字             相对应的二进制数
10                   00001010
0                    00000000
3                    00000011
193                  11000001
组合起来即为：00001010 00000000 00000011 11000001,


数据范围：保证输入的是合法的 IP 序列
输入描述：
输入
1 输入IP地址
2 输入10进制型的IP地址

输出
1 输出转换成10进制的IP地址
2 输出转换后的IP地址

输入：
10.0.3.193
167969729

输出：
167773121
10.3.3.193

 自己要点：
 1） \\. 转义
 2）Long存储ip地址对应的数
 3）Long.toBinaryString(ip)  10进制 转 2进制
 */
public class HJ33_NumToIp {
    public static void main(String[] args) {

//=============================自己实现=======================================
////        System.out.println(Integer.toHexString(15));
////        System.out.println(Integer.toOctalString(11));
////        System.out.println(Integer.toBinaryString(15));
////        System.out.println(Integer.valueOf("FFFF",16));
////        System.out.println(Integer.valueOf("766",8));
////        System.out.println(Integer.valueOf("0101",2));
////        System.out.println(Integer.parseInt("FF",16));
////        System.out.println(Integer.toBinaryString(193));
////        System.out.println(Integer.parseInt("193",2));
////        System.out.println(Integer.toBinaryString((int)Math.pow(2,8)));//100000000
////        1.694498816E10
////        System.out.println(10*Math.pow(2,24)+3*Math.pow(2,8)+193);
////        System.out.println(Integer.valueOf("00001010000000000000001111000001",2));
//
//
//        Scanner sc = new Scanner(System.in);
//        String[] str = sc.nextLine().split("\\."); //转义!!!
//        long res=0;
//        for (int i = 0; i < str.length; i++) {
//           res+= Long.parseLong(str[i])*Math.pow(2,8*(str.length-1-i));
//        }
//        System.out.println(res);
//
//        long ip = Long.valueOf(sc.nextLine()); // 输入3868643487  超过 int的最大值2147483647
//        String ipStr=Long.toBinaryString(ip);//167969729)   ==》[1010     0000 0011    0000 0011    1100 0001] ==>10.3.3.193
//        int end=ipStr.length();
//        long[] ipNums=new long[(int)Math.ceil(end/8.0)]; //28/8.0=3.5!!!   28/8=3
//        for (int i = 0; i<4; i++) { //ip地址有4段
//            String sub=ipStr.substring( end-8>0?end-8:0  , end); //倒着往前处理   28位的话，第一段是【0，4）
//            Long tmp=Long.valueOf(sub,2); //二进制转十进制
//            ipNums[i]=tmp; //暂存某一段ip的结果
//            end=end-8;
//        }
//
//        for (int i = ipNums.length-1; i >=0 ; i--) {
//            System.out.print(ipNums[i]);
//            if(i!=0){
//                System.out.print(".");
//            }
//        }


/*
官方1：通过二进制
10.0.3.193
167969729
*/
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            if(s.contains(".")){
                System.out.println(ip2num(s));
            }else{
                System.out.println(num2ip(Long.parseLong(s)));
            }
        }



}

    public static long ip2num(String ip){
        String[] iip = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            int num = Integer.parseInt(iip[i]);  // 拆分
            String num2 = Integer.toBinaryString(num);  //转换为二进制
            while(num2.length()<8){
                num2 = "0" + num2;  // 在前面拼接0，直到8位
            }
            sb.append(num2);
        }
        return Long.parseLong(sb.toString(), 2);  // 转化为10进制
    }

    public static String num2ip(long num){
        String num2 = Long.toBinaryString(num);  //转换为2进制
        while(num2.length()<32){
            num2 = "0" + num2; // 在前面拼接0 到32位
        }
        String[] ans = new String[4];
        for(int i=0; i<4; i++){
            String s = num2.substring(8*i, 8*i+8);  //拆分
            s = Integer.toString(Integer.parseInt(s, 2));  //转化为10进制
            ans[i] = s;
        }
        return String.join(".", ans);  //拼接
    }



// 256进制
//public class Main {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.next();
//            if(s.contains(".")){
//                System.out.println(ip2num(s));
//            }else{
//                System.out.println(num2ip(Long.parseLong(s)));
//            }
//        }
//    }
//
//    public static long ip2num(String ip){
//        String[] iip = ip.split("\\.");
//        Long ans = (long)0;
//        for(int i = 0; i<4; i++){
//            ans = ans * 256 + Long.parseLong(iip[i]);
//        }
//        return ans;
//    }
//
//    public static String num2ip(long num){
//        String[] ans = new String[4];
//        for(int i=3; i>=0; i--){
//            ans[i] = Long.toString(num % 256);
//            num = num / 256;
//        }
//        return String.join(".", ans);
//    }
//}


}


